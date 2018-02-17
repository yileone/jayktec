package com.jayktec.xyzOlympus.models;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

/*
 Table: historialfisico
Columns:
idhistorialFisico int(11) PK 
atleta_idatleta int(11) 
FechaRegistro date 
altura int(11) 
peso int(11) 
tallaCamisa int(11) 
tallaZapato int(11) 
tallaPantalon varchar(45) 
porcGrasa int(11) 
porcMusculo int(11) 
imagen blob 
funcionario_idfuncionario int(11)*/
@Entity
@Table(name="historialFisico", schema="deportic")
public class HistorialFisico {
	@Id
	@Hidden
	@Column(name="idhistorialFisico",length=11)
	private int oid;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="atleta_idatleta",insertable=true,updatable=true)
	private Atleta atleta;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="funcionario_idfuncionario",insertable=true,updatable=true)
	private Funcionario funcionario;
	
	
	@Column(name="FechaRegistro",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date FechaRegistro;	
	
	@Column(name="altura",length=11)
	private int altura;
	
	@Column(name="peso",length=11)
	private int peso;
	@Column(name="tallaCamisa",length=11)
	private int tallaCamisa;
	
	@Column(name="tallaZapato",length=11)
	private int tallaZapato;
	
	@Column(name="taltallaPantalon",length=11)
	private String taltallaPantalon;
	
	@Column(name="porcGrasa",length=11)
	private int porcGrasa;
	
	@Column(name="porcMusculo",length=11)
	private int porcMusculo;

	@Column(name="imagen",length=255)
	
	
	//TODO Indagar como guardar la imagen en la base de datos con openxava
	@Stereotype("IMAGEN")
	private byte[] imagen;
	
	

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getTallaCamisa() {
		return tallaCamisa;
	}

	public void setTallaCamisa(int tallaCamisa) {
		this.tallaCamisa = tallaCamisa;
	}

	public int getTallaZapato() {
		return tallaZapato;
	}

	public void setTallaZapato(int tallaZapato) {
		this.tallaZapato = tallaZapato;
	}

	public String getTaltallaPantalon() {
		return taltallaPantalon;
	}

	public void setTaltallaPantalon(String taltallaPantalon) {
		this.taltallaPantalon = taltallaPantalon;
	}

	public int getPorcGrasa() {
		return porcGrasa;
	}

	public void setPorcGrasa(int porcGrasa) {
		this.porcGrasa = porcGrasa;
	}

	public int getPorcMusculo() {
		return porcMusculo;
	}

	public void setPorcMusculo(int porcMusculo) {
		this.porcMusculo = porcMusculo;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	


}
