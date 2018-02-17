package com.jayktec.xyzOlympus.models;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

/*
Table: pagos
Columns:
id_contrato varchar(45) 
pagos int(11) AI PK 
FechaRegistro date 
Monto varchar(45) 
numeroCheque varchar(45) 
banco varchar(45) 
tdc varchar(45) 
efectivo int(11) 
numerotransaccion int(11) 
transferencia int(11)*/
@Entity
@Table(name="pagos", schema="deportic")
public class Pagos {
	
	
	@Id
	@Hidden
	@Column(name="id_contrato",length=11)
	private int oidContrato;
	
	
	//TODO Ver el tipo de datos creo mejor colocarlo Float pagos
	@Column(name="pagos",length=11)
	private int pago;
	
	@NoModify
	@Column(name="FechaRegistro",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date FechaRegistro;	
	
	
	//TODO Ver el tipo de datos creo mejor colocarlo Float  Monto
	@Column(name="Monto",length=45)
	private String monto;	
	
	
	@Column(name="numeroCheque",length=45)
	private String numeroCheque;	
	
	//TODO ESTO ES UN CATALOGO ?
	@Column(name="banco",length=45)
	private String 	banco;
	
	
	
	//TODO Ver como funciona este estereotipo tarjeta de credito
	@Stereotype("TARJETA_CREDITO")
	@Column(name="tdc",length=45)
	private String numeroTarjeta;
	
	//TODO Ver el tipo de datos creo mejor colocarlo Float  efectivo
	@Column(name="efectivo",length=45)
	private int efectivo;
	
	
	@Column(name="numerotransaccion",length=45)
	private int numerotransaccion;
	
	@Column(name="transferencia",length=45)
	private int numerotransferencia;

	public int getOidContrato() {
		return oidContrato;
	}

	public void setOidContrato(int oidContrato) {
		this.oidContrato = oidContrato;
	}

	public int getPago() {
		return pago;
	}

	public void setPago(int pago) {
		this.pago = pago;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getEfectivo() {
		return efectivo;
	}

	public void setEfectivo(int efectivo) {
		this.efectivo = efectivo;
	}

	public int getNumerotransaccion() {
		return numerotransaccion;
	}

	public void setNumerotransaccion(int numerotransaccion) {
		this.numerotransaccion = numerotransaccion;
	}

	public int getNumerotransferencia() {
		return numerotransferencia;
	}

	public void setNumerotransferencia(int numerotransferencia) {
		this.numerotransferencia = numerotransferencia;
	}

	

}
