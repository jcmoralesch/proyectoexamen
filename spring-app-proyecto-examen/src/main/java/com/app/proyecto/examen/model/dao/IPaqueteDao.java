package com.app.proyecto.examen.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.proyecto.examen.model.entity.Paquete;

public interface IPaqueteDao extends JpaRepository<Paquete, Long> {

}
