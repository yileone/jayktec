package com.jayktec.xyzOlympus.models;


import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import java.io.*;
import java.util.Date;

/*Table: Representante
Columns:
idrepresentante int(11) AI PK 
fechaInicio date 
fechaFin date 
fechaRegistro date 
idpersona int(11) PK 
idclub int(11) PK*/

@Entity
@Table(name="representante", schema="deportic")
public class Representante implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Hidden
	@Column(name="idrepresentante",length=11)
	private int oid;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="idpersona",insertable=true,updatable=true)
	private Persona Persona;
	
	@Column(name="fechaInicio",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date fechaInicio;
	
	@Column(name="fechaFin",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date fechaFin;
	
	
	@Column(name="fechaRegistro",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date fechaRegistro;
	


	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="idclub",insertable=true,updatable=true)
	private Club club;



	public int getOid() {
		return oid;
	}



	public void setOid(int oid) {
		this.oid = oid;
	}



	public Persona getPersona() {
		return Persona;
	}



	public void setPersona(Persona Persona) {
		this.Persona = Persona;
	}



	public Date getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public Date getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}



	public Date getFechaRegistro() {
		return fechaRegistro;
	}



	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



	public Club getClub() {
		return club;
	}



	public void setClub(Club club) {
		this.club = club;
	}


	
}
