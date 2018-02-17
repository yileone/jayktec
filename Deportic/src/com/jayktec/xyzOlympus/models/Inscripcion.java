package com.jayktec.xyzOlympus.models;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author Anthonny
 *
 */
@Entity
@Table(name="inscripcion", schema="deportic")
public class Inscripcion {
	
	
	
	@Id
	@Hidden
	@Column(name="idincripcion",length=11)
	private int oidIncripcion;
	
	//TODO Esta tabla no tiene id esta bien ?
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="equipo_idEquipo",insertable=true,updatable=true)
	private Equipo equipo;
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="torneo_idtorneo",insertable=true,updatable=true)
	private Torneo torneo;


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


	public Torneo getTorneo() {
		return torneo;
	}


	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}


	public int getOidIncripcion() {
		return oidIncripcion;
	}


	public void setOidIncripcion(int oidIncripcion) {
		this.oidIncripcion = oidIncripcion;
	}
	
	
	

}
