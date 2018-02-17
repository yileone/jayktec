package com.jayktec.xyzOlympus.models;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

/*
 
Table: atletarutina
Columns:
atleta_idatleta int(11) PK 
rutina_idrutina int(11) PK 
fechaInicio date 
FechaRegistro date 
FechaFin date 
observacion longtext
 */
@Entity
@Table(name="atletarutina", schema="deportic")
public class AtletaRutina {
	@Id
	@Hidden
	@Column(name="idatletarutina",length=11)
	private int oidAtletaRutina;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="atleta_idatleta",insertable=true,updatable=true)
	private Atleta atleta;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="rutina_idrutina",insertable=true,updatable=true)
	private Rutina rutina;
	
	@Column(name="fechaInicio",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date fechaInicio;	
	
	
	@Column(name="FechaFin",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date FechaFin;	
	
	@Column(name="FechaRegistro",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date FechaRegistro;	
	
	@Stereotype("TEXTOGRANDE")
	@Column(name="observacion",length=255)
	private String observacion;

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public Rutina getRutina() {
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		FechaFin = fechaFin;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getOidAtletaRutina() {
		return oidAtletaRutina;
	}

	public void setOidAtletaRutina(int oidAtletaRutina) {
		this.oidAtletaRutina = oidAtletaRutina;
	}	
	
	
	
	
	

}
