package com.jayktec.xyzOlympus.models;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

/*
Table: contrato
Columns:
atleta_idatleta int(11) 
convenio_idconvenio int(11) 
contratocol varchar(45) PK 
FechaRegistro date 
fechaInicio date 
FechaFin date 
formaPago varchar(45) 
valorCuota int(11) 
cantidadCuotas int(11) 
equipo_idEquipo int(11)
*/
@Entity
@Table(name="contrato", schema="deportic")
public class Contrato {
	
	
	@Id
	@Hidden
	@Column(name="contratocol",length=11)
	private int oidContrato;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="atleta_idatleta",insertable=true,updatable=true)
	private Atleta atleta;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="convenio_idconvenio",insertable=true,updatable=true)
	private Convenio idconvenio;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="equipo_idEquipo",insertable=true,updatable=true)
	private Equipo equipo;
	
	@Column(name="fechaInicio",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date fechaInicio;
	
	@Column(name="FechaFin",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date fechaFin;
	
	
	@Column(name="FechaRegistro",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date fechaRegistro;
	
	@Column(name="formaPago",length=45)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private String formaPago;
	
	@Column(name="valorCuota",length=11)
	private int valorCuota;
	
	@Column(name="cantidadCuotas",length=11)
	private int cantidadCuotas;

	public int getOidContrato() {
		return oidContrato;
	}

	public void setOidContrato(int oidContrato) {
		this.oidContrato = oidContrato;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public Convenio getIdconvenio() {
		return idconvenio;
	}

	public void setIdconvenio(Convenio idconvenio) {
		this.idconvenio = idconvenio;
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public int getValorCuota() {
		return valorCuota;
	}

	public void setValorCuota(int valorCuota) {
		this.valorCuota = valorCuota;
	}

	public int getCantidadCuotas() {
		return cantidadCuotas;
	}

	public void setCantidadCuotas(int cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}

}
