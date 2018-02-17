package com.jayktec.xyzOlympus.models;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

/*Columns:
identrenador int(11) AI PK 
desde date 
hasta date 
Persona_idPersona int(11) PK 
equipo_idEquipo int(11) PK 
estado varchar(45)*/
@Entity
@Table(name="entrenador", schema="deportic")
public class Entrenador {

	@Id
	@Hidden
	@Column(name="identrenador",length=11)
	private int oidEntrenador;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="Persona_idPersona",insertable=true,updatable=true)
	private Persona persona;
	

	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="equipo_idEquipo",insertable=true,updatable=true)
	private Equipo equipo;
	
	@Column(name="desde",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date fechaInicio;
	
	@Column(name="hasta",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date fechaFin;
	
	

	
	//TODO Esto es un catalogo hay que crear la tabla y llenar el catalogo desde sus modulos EstadoEntrenador
	@NoModify
	@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="estado",insertable=true,updatable=true,table="entrenador")
	@DescriptionsList(condition="e.oidEntrenador in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='EstadoEntrenador')",
			showReferenceView=false,
			descriptionProperties="valorVarchar")  
	@ReferenceView("VVarchar")
	private Catalogo estado;




	public int getOidEntrenador() {
		return oidEntrenador;
	}




	public void setOidEntrenador(int oidEntrenador) {
		this.oidEntrenador = oidEntrenador;
	}




	public Persona getPersona() {
		return persona;
	}




	public void setPersona(Persona persona) {
		this.persona = persona;
	}




	public Equipo getEquipo() {
		return equipo;
	}




	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
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




	public Catalogo getEstado() {
		return estado;
	}




	public void setEstado(Catalogo estado) {
		this.estado = estado;
	}




	
}
