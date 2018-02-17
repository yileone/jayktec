package com.jayktec.xyzOlympus.models;

import javax.persistence.*;

import org.openxava.annotations.*;

/*
 * 
 Table: equipo
Columns:
club_idclub int(11) 
id_equipo int(11) AI PK 
nombre varchar(45) 
categoria varchar(45)*/
@Entity
@Table(name="equipo", schema="deportic")
public class Equipo {
	

	@Id
	@Hidden
	@Column(name="id_equipo",length=11)
	private int oidEquipo;
	
	
	@Column(name="nombre",length=45)
	private String nombreEquipo;
	
	//TODO Esto es un catalogo hay que crear la tabla y llenar el catalogo desde sus modulos CategoriaEquipo
	@NoModify
	@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="categoria",insertable=true,updatable=true,table="equipo")
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='CategoriaEquipo')",
	showReferenceView=false,
	descriptionProperties="valorVarchar")  
	@ReferenceView("VVarchar")
	private Catalogo categoriaEquipo;
	

	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="club_idclub",insertable=true,updatable=true)
	private Club club;

	public int getOidEquipo() {
		return oidEquipo;
	}

	public void setOidEquipo(int oidEquipo) {
		this.oidEquipo = oidEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public Catalogo getCategoriaEquipo() {
		return categoriaEquipo;
	}

	public void setCategoriaEquipo(Catalogo categoriaEquipo) {
		this.categoriaEquipo = categoriaEquipo;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	
}
