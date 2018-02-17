package com.jayktec.xyzOlympus.models;


import java.io.*;
import java.util.*;

import javax.persistence.*;

/*
 Table: Atleta
Columns:
idatleta int(11) AI PK 
idpersona int(11) 
tipoSangre varchar(45) 
alergia varchar(45) 
enfermedades varchar(45) 
idclub int(11)
 * */
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.filters.*;

@Entity
@Table(name="atleta", schema="deportic")
public class Atleta implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	@Id
	@Hidden
	@Column(name="idatleta",length=11)
	private int oid;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="idpersona",insertable=true,updatable=true)
	private Persona persona;
	
	@NoModify
	@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="tipoSangre",insertable=true,updatable=true,table="atleta")
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='TipoSangre')",
			showReferenceView=false,
			descriptionProperties="valorVarchar")  
	@ReferenceView("VVarchar")private Catalogo tipoSangre;

	
	/*@NoModify
	@NoCreate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="alergia",insertable=true,updatable=true,table="atleta")
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='Alergias')")
	private Catalogo alergia;*/
	
	
	
	/*@NoCreate
	@OneToMany(targetEntity=com.jayktec.xyzOlympus.models.Catalogo.class)
	private Collection <Catalogo> alergia;*/
	
	
	/*@NoModify
	@NoCreate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="enfermedades",insertable=true,updatable=true,table="Atleta")*/
	
	
	/*@OneToMany(cascade=CascadeType.ALL, mappedBy="idCatalogo")
	private Collection <Catalogo> enfermedades;*/


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

	public Catalogo getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(Catalogo tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	/*public Collection<Catalogo> getEnfermedades() {
		
		return enfermedades;
	}

	public void setEnfermedades(Collection<Catalogo> enfermedades) {
		this.enfermedades = enfermedades;
	}*/


	

	










}
