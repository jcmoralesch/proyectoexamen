package com.app.proyecto.examen.model.service;

import java.util.List;

import com.app.proyecto.examen.model.entity.Paquete;

public interface IPaqueteService {
	
	public void save(Paquete paquete);
	public void delete(Long id);
	public Paquete findById(Long id);
	public List<Paquete> findAll();

}
