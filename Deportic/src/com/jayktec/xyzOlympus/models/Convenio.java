package com.jayktec.xyzOlympus.models;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;


/*
 Table: convenio
Columns:
idconvenio int(11) AI PK 
nombreConvenio varchar(45) 
Valor int(11) 
descripcion varchar(45) 
vigencia date 
*/
@Entity
@Table(name="convenio", schema="deportic")
public class Convenio {
	
	@Id
	@Hidden
	@Column(name="idconvenio",length=11)
	private int oidCovenio;

	@Column(name="nombreConvenio",length=45)
	private String nombreConvenio;
	
	@Column(name="Valor",length=11)
	private int valor;
	
	
	@Stereotype("TEXTOGRANDE")
	@Column(name="descripcion",length=255)
	private String descripcion;
	
	
	@Column(name="vigencia",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date vigencia;




	public int getOidCovenio() {
		return oidCovenio;
	}


	public void setOidCovenio(int oidCovenio) {
		this.oidCovenio = oidCovenio;
	}


	public String getNombreConvenio() {
		return nombreConvenio;
	}


	public void setNombreConvenio(String nombreConvenio) {
		this.nombreConvenio = nombreConvenio;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getVigencia() {
		return vigencia;
	}


	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	
	
	
	
	
}
