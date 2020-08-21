package com.app.proyecto.examen.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.app.proyecto.examen.model.entity.Paquete;

public interface IPaqueteDao extends JpaRepository<Paquete, Long> {
	
	@Procedure( name = "java_procedure_paquete")
	String procedureRegistrarPaquete(@Param("paramIn1") String paramIn1,@Param("paramIn2") Double paramIn2,@Param("paramIn3") String paramIn3,@Param("paramIn4") String paramIn4,@Param("paramIn5") String paramIn5);

}
