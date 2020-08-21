package com.app.proyecto.examen.restFull;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.proyecto.examen.model.entity.Venta;

@RestController
@RequestMapping("/api")
public class VentaRestController {
	
	@GetMapping("/consulta/venta/{id}/{fecha1}/{fecha2}")
	public List<Venta> consultarVenta(@PathVariable("id") Long id, @PathVariable("fecha1") LocalDate fecha1,@PathVariable("fecha2") LocalDate fecha2){
		
		
		  
		
		return null;
		
	}

}
