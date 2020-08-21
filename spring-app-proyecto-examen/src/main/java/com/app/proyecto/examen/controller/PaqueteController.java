package com.app.proyecto.examen.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
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
	
	

}
