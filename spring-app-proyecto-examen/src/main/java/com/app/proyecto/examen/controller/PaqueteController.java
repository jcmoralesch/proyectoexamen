package com.app.proyecto.examen.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.app.proyecto.examen.model.entity.Paquete;
import com.app.proyecto.examen.model.service.IPaqueteService;

@Controller
@RequestMapping("/paquete")
@SessionAttributes("paquete")
public class PaqueteController {
	
	@Autowired
	private IPaqueteService paqueteService;
	
	@GetMapping("/listar")
	public String listar(Map<String, Object> model) {
		
		List<Paquete> paquetes=paqueteService.findAll();
		
		model.put("titulo", "Paquetes disponibles");
		model.put("paquetes", paquetes);
		
		return "paquete/listar";
	}
	
	@GetMapping("/form")
	public String formulario(Map<String, Object> model) {
		
		Paquete paquete = new Paquete();
		
		model.put("paquete",paquete);
		model.put("titulo", "Formulario de registro");
		return "/paquete/form";
	}
	
	@PostMapping("/guardar")
	public String guardar(Paquete paquete, RedirectAttributes flash,SessionStatus status) {
		
		paquete.getCantidadBolson().toUpperCase();
		paquete.getTipo().toUpperCase();
		paquete.getVigencia().toUpperCase();
		
		paqueteService.save(paquete);
		status.setComplete();
		flash.addFlashAttribute("success", "Operacion realizada con exito");
		
		return "redirect:/paquete/listar";		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id,Map<String, Object> model,RedirectAttributes flash) {
        if(id>0) {	
        	Paquete paquete=paqueteService.findById(id);
        	
        	if(paquete!=null) {
        	model.put("titulo", "Acualizar datos de paquete");
        	model.put("paquete", paquete);
        	return "/paquete/form";
        	}
        }
        	
        	flash.addFlashAttribute("danger", "Registro no existe en la BBDD");
        	return "redirect:/paquete/listar";	
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id,RedirectAttributes flash) {
		
		Paquete paquete= paqueteService.findById(id);
		if(paquete!=null) {
			paqueteService.delete(id);
			flash.addFlashAttribute("success", "Registro elimanado con exito");
			
			return "redirect:/paquete/listar";
		}
		
		flash.addFlashAttribute("danger", "Error al eliminar no existe el registro en la BBDD");
		return "redirect:/paquete/listar";
	}

}
