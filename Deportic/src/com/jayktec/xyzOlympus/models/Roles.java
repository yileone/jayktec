package com.jayktec.xyzOlympus.models;

import javax.persistence.*;

import org.openxava.annotations.*;

/*
Columns:
id_rol int(11) PK 
descripcion varchar(255) 
funcionario_idfuncionario int(11)
 */
@Entity
@Table(name="roles", schema="deportic")
public class Roles {
	
	@Id
	@Hidden
	@Column(name="idrol",length=11)
	private int oid;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="idpersona",insertable=true,updatable=true)
	private Persona persona;
	

	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="funcionario_idfuncionario",insertable=true,updatable=true)
	private Funcionario funcionario;
	
	@Stereotype("TEXTOGRANDE")
	@Column(name="descripcion",length=255)
	private int descripcion;

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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
