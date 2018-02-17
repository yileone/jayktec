package com.jayktec.xyzOlympus.models;

import javax.persistence.*;

import org.openxava.annotations.*;
/*

Table: Contacto
Columns:
idcontacto int(11) AI PK 
tipoContacto int(11) PK 
idpersona int(11) 
Valor*/
@Entity
@Views({
	@View(name="VClub",members="club;tipoContacto;valor"),
	@View(name="VPersona",members="persona.oid;tipoContacto;valor")})
@Table(name="contacto", schema="deportic")
public class Contacto {
	
	@Id
	@Hidden
	@Column(name="idcontacto",length=11)
	private int oid;

	/*@Hidden
	@Column(name="idpersona",length=11)
	private int oidpersona;*/
	//@Hidden
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name="idpersona",insertable=false,updatable=false)
	private Persona persona;
	
	/*@Column(name="idclub",length=11)
	private int oidclub;*/
	//@Hidden
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name="idclub",insertable=false,updatable=false)
	private Club club;
    
    
    
    
	
	//TODO LLENAR EL CATALOGO PARA TIPO DE CONTACTO
	@NoModify
	@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="tipoContacto",insertable=true,updatable=true,table="contacto")
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='TipoContactos')",
	showReferenceView=false,
	descriptionProperties="valorVarchar")  
	@ReferenceView("VVarchar")
	private Catalogo tipoContacto;
	
	
	@Column(name="valor",length=255)
	private String valor;

	

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	/*public int getOidpersona() {
		return oidpersona;
	}

	public void setOidpersona(int oidpersona) {
		this.oidpersona = oidpersona;
	}*/

	/*public int getOidclub() {
		return oidclub;
	}

	public void setOidclub(int oidclub) {
		this.oidclub = oidclub;
	}*/
	
	
	
	
	

	public Catalogo getTipoContacto() {
		return tipoContacto;
	}



	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.club= null;
		this.persona = persona;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
		this.persona=null;
	}

	public void setTipoContacto(Catalogo tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
