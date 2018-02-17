package com.jayktec.xyzOlympus.models;

import javax.persistence.*;

import org.openxava.annotations.*;
/*
 Table: rutina
Columns:
idrutina int(11) AI PK 
Actividad varchar(45) 
frecuencia varchar(45) 
tiempo varchar(45) 
descansoFrecuencia varchar(45) 
rutinaNombre varchar(45)
 */
@Entity
@Table(name="roles", schema="deportic")
public class Rutina {
	
	@Id
	@Hidden
	@Column(name="idrutina",length=11)
	private int oidRutina;
	
	@Column(name="rutinaNombre",length=50)
	private String rutinaNombre;
	
	
	//TODO Ver si est es un catalogo
	@Stereotype("TEXTOGRANDE")
	@Column(name="Actividad",length=255)
	private String actividad;
	
	//TODO Ver si est es un catalogo
	@Column(name="frecuencia",length=50)
	private String frecuencia;
	
	
	//TODO DEBE SER tipo TIME ?
	@Column(name="tiempo",length=50)
	private String tiempo;
	
	@Column(name="descansoFrecuencia",length=50)
	private String descansoFrecuencia;
	
	public int getOidRutina() {
		return oidRutina;
	}
	public void setOidRutina(int oidRutina) {
		this.oidRutina = oidRutina;
	}
	public String getRutinaNombre() {
		return rutinaNombre;
	}
	public void setRutinaNombre(String rutinaNombre) {
		this.rutinaNombre = rutinaNombre;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getDescansoFrecuencia() {
		return descansoFrecuencia;
	}
	public void setDescansoFrecuencia(String descansoFrecuencia) {
		this.descansoFrecuencia = descansoFrecuencia;
	}


}
