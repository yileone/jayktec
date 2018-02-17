package com.jayktec.xyzOlympus.models;

import javax.persistence.*;

import org.openxava.annotations.*;

/*
 * 
 Table: torneo
Columns:
idtorneo int(11) AI PK 
nombre varchar(45) 
descripcion varchar(255)
 */
@Entity
@Table(name="torneo", schema="deportic")
public class Torneo {
	
	@Id
	@Hidden
	@Column(name="idtorneo",length=11)
	private int oidTorneo;
	
	@Column(name="nombre",length=45)
	private String nombre;
	
	@Stereotype("TEXTOGRANDE")
	@Column(name="descripcion",length=255)
	private String descripcion;

	public int getOidTorneo() {
		return oidTorneo;
	}

	public void setOidTorneo(int oidTorneo) {
		this.oidTorneo = oidTorneo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
