package com.jayktec.xyzOlympus.models;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

/*Table: historiallogros
Columns:
atleta_idatleta int(11) 
FechaRegistro date 
logro longtext 
lugar varchar(45) 
competencia varchar(45) 
funcionario_idfuncionario int(11) 
torneo_idtorneo int(11)*/
@Entity
@Table(name="historialLogros", schema="deportic")
public class HistorialLogros {
	
	//TODO No tiene id para la tabla historialLogros esta bien ?
	@Id
	@Hidden
	@Column(name="idhistorialogro",length=11)
	private int oidHistlogro;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="atleta_idatleta",insertable=true,updatable=true)
	private Atleta atleta;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="funcionario_idfuncionario",insertable=true,updatable=true)
	private Funcionario funcionario;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="torneo_idtorneo",insertable=true,updatable=true)
	private Torneo torneo;

	
	@Column(name="FechaRegistro",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date FechaRegistro;	

	@Stereotype("TEXTO_GRANDE")
	@Column(name="logro",length=10)
	private String logro;	

	@Column(name="lugar",length=10)
	private String lugar;	
	
	//TODO Esto es un catalogo ?
	@Column(name="competencia",length=45)
	private String competencia;

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

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	public String getLogro() {
		return logro;
	}

	public void setLogro(String logro) {
		this.logro = logro;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCompetencia() {
		return competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public int getOidHistlogro() {
		return oidHistlogro;
	}

	public void setOidHistlogro(int oidHistlogro) {
		this.oidHistlogro = oidHistlogro;
	}



	

}
