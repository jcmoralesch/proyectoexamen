package com.app.proyecto.examen.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			  name = "java_procedure_paquete",
			  procedureName = "registrarpaquete",
			  parameters = {
					  @StoredProcedureParameter(mode = ParameterMode.IN,name = "paramIn1",type = String.class),
					  @StoredProcedureParameter(mode = ParameterMode.IN,name = "paramIn2",type = Double.class),
					  @StoredProcedureParameter(mode = ParameterMode.IN,name = "paramIn3",type = String.class),
					  @StoredProcedureParameter(mode = ParameterMode.IN,name = "paramIn4",type = String.class),
					  @StoredProcedureParameter(mode = ParameterMode.IN,name = "paramIn5",type = String.class),
					  @StoredProcedureParameter(mode = ParameterMode.OUT,name = "paramOut",type = String.class)
			  }
			)
})
@Table(name = "paquetes")
public class Paquete implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30)
	private String nombre;
	private Double precio;
	@Column(length = 10)
	private String tipo;
	@Column(length = 30, name = "cantidad_bolson")
	private String cantidadBolson;
	@Column(length = 20)
	private String vigencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCantidadBolson() {
		return cantidadBolson;
	}

	public void setCantidadBolson(String cantidadBolson) {
		this.cantidadBolson = cantidadBolson;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
}
