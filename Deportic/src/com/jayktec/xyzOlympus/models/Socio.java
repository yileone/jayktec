package com.jayktec.xyzOlympus.models;

import javax.persistence.*;

import org.openxava.annotations.*;

/*
 Table: socio
Columns:
idsocio int(11) AI PK 
club_idclub int(11) PK 
Persona_idPersona int(11) PK
 */
@Entity
@Table(name="socio", schema="deportic")
public class Socio {
	
	@Id
	@Hidden
	@Column(name="idsocio",length=11)
	private int oidSocio;
	
	@Column(name="club_idclub",length=11)
	private Club club;
	
	

	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="Persona_idPersona",insertable=true,updatable=true)
	private Persona persona;




	public int getOidSocio() {
		return oidSocio;
	}




	public void setOidSocio(int oidSocio) {
		this.oidSocio = oidSocio;
	}




	public Club getClub() {
		return club;
	}




	public void setClub(Club club) {
		this.club = club;
	}




	public Persona getPersona() {
		return persona;
	}




	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
	
	

}
