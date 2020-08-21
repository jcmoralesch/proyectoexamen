package com.app.proyecto.examen.model.service;

import java.util.List;
import com.app.proyecto.examen.model.entity.Paquete;

public interface IPaqueteService {
	
	public void save(Paquete paquete);
	public void delete(Long id);
	public Paquete findById(Long id);
	public List<Paquete> findAll();
	
	String procedureRegistrarPaquete(String paramIn1,Double paramIn2,String paramIn3,String paramIn4,String paramIn5);

}
