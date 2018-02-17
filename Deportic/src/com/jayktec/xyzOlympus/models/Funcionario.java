package com.jayktec.xyzOlympus.models;

import javax.persistence.*;

import org.openxava.annotations.*;

/*
Table: funcionario
Columns:
Persona_idPersona int(11) 
idfuncionario int(11) AI PK*/
@Entity
@Table(name="funcionario", schema="deportic")
public class Funcionario {
	
	@Id
	@Hidden
	@Column(name="idfuncionario",length=11)
	private int oid;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="Persona_idPersona",insertable=true,updatable=true)
	private Persona persona;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}


}
