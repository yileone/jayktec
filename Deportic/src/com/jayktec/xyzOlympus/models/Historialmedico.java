package com.jayktec.xyzOlympus.models;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

/*
Table: historialmedico
Columns:
atleta_idatleta int(11) 
FechaRegistro date 
medicoTratante varchar(45) 
centroClinico varchar(45) 
tratamiento longtext 
operacion longtext 
reposoDesde date 
reposoHasta date 
fractura varchar(45) 
funcionario_idfuncionario int(11)*/
@Entity
@Table(name="historialmedico", schema="deportic")
public class Historialmedico {
	
	@Id
	@Hidden
	@Column(name="idhistoriaMedico",length=11)
	private int oidHistMedico;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="atleta_idatleta",insertable=true,updatable=true)
	private Atleta atleta;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="funcionario_idfuncionario",insertable=true,updatable=true)
	private Funcionario funcionario;
	
	
	@Column(name="FechaRegistro",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date FechaRegistro;	
	
	@Column(name="medicoTratante",length=45)
	private String medicoTratante;	
	
	
	//TODO Esto es un catalogo ?
	@Column(name="centroClinico",length=45)
	private String centroClinico;	
	
	@Stereotype("TEXTO_GRANDE")
	@Column(name="tratamiento",length=45)
	private String tratamiento;
	
	
	@Column(name="reposoDesde",length=10)
	private Date reposoDesde;
	
	@Column(name="reposoHasta",length=10)
	private Date reposoHasta;

	//No Entiendo el concepto de esto mejor tratarlo como un catalogo y va en el registro de atletas
	@Column(name="fractura",length=45)
	private String fractura;

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

	public String getMedicoTratante() {
		return medicoTratante;
	}

	public void setMedicoTratante(String medicoTratante) {
		this.medicoTratante = medicoTratante;
	}

	public String getCentroClinico() {
		return centroClinico;
	}

	public void setCentroClinico(String centroClinico) {
		this.centroClinico = centroClinico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Date getReposoDesde() {
		return reposoDesde;
	}

	public void setReposoDesde(Date reposoDesde) {
		this.reposoDesde = reposoDesde;
	}

	public Date getReposoHasta() {
		return reposoHasta;
	}

	public void setReposoHasta(Date reposoHasta) {
		this.reposoHasta = reposoHasta;
	}

	public String getFractura() {
		return fractura;
	}

	public void setFractura(String fractura) {
		this.fractura = fractura;
	}

	public int getOidHistMedico() {
		return oidHistMedico;
	}

	public void setOidHistMedico(int oidHistMedico) {
		this.oidHistMedico = oidHistMedico;
	}

	
	
	

}
