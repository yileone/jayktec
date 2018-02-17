package com.jayktec.xyzOlympus.models;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import jdk.nashorn.internal.ir.annotations.*;
/*
Table: Persona
Columns:
idpersona int(11) AI PK 
rut int(11) 
digitoVerificador varchar(1) 
primerNombre varchar(45) 
segundoNombre varchar(45) 
primerApellido varchar(45) 
segundoApellido varchar(45) 
fechaNac date 
estadoCivil varchar(45) 
lugarNacimiento varchar(45) 
nacionalidad varchar(45) 
fechaRegistro date 
sexo varchar(45) 
manoHabil varchar(45)

*/
@Entity
@Table(name="persona", schema="deportic")
public class Persona implements Serializable  {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Hidden
	@Column(name="idpersona",length=11)
	private int oid;
	
	// ver el tamanio del rut 
	@Column(name="rut",length=11)
	private String rut;
	
	// para que es este campo?
	@Column(name="digitoVerificador",length=1)
	private String digitoVerificador;
	
	
	@Column(name="primerNombre",length=45)
	private String primerNombre;
	
	@Column(name="segundoNombre",length=45)
	private String segundoNombre;
	
	
	@Column(name="primerApellido",length=45)
	private String primerApellido;
	
	@Column(name="segundoApellido",length=45)
	private String segundoApellido;
	
	@DefaultValueCalculator(CurrentDateCalculator.class)
	@Column(name="fechaNac",length=12)
	private Date fechaNac;
	
	@Column(name="lugarNacimiento",length=45)
	private String lugarNacimiento;
	
	
	@OneToMany(mappedBy="persona")
	@CollectionView("VPersona")
	private Collection<Contacto> listacontactos;

		
		public Collection<Contacto> getListacontactos() {
		return listacontactos;
	}

	public void setListacontactos(Collection<Contacto> listacontactos) {
		this.listacontactos = listacontactos;
	}
	
	
	//TODO CARGA DATA PARA EL CATALOGO Nacionalidades
	@NoModify
	@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="nacionalidad",insertable=true,updatable=true,table="persona")
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='Nacionalidades')",
	showReferenceView=false,
	descriptionProperties="valorVarchar")  
	@ReferenceView("VVarchar")
	private Catalogo nacionalidad;
	
	
	//TODO CARGA DATA PARA EL CATALOGO SEXO
	@NoModify
	@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="sexo",insertable=true,updatable=true,table="persona")
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='Sexo')",
	showReferenceView=false,
	descriptionProperties="valorVarchar")  
	@ReferenceView("VVarchar")
	private Catalogo sexo;
	
	//TODO CARGA DATA PARA EL CATALOGO Lateralidad 
	@NoModify
	@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="manoHabil",insertable=true,updatable=true,table="persona")
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='Lateralidad')",
	showReferenceView=false,
	descriptionProperties="valorVarchar")  
	@ReferenceView("VVarchar")
	private Catalogo manoHabil;
	
	
	//TODO para la relacion oneTomany tengo rollos ver con yishen para encontrar solucion


	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDigitoVerificador() {
		return digitoVerificador;
	}

	public void setDigitoVerificador(String digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}



	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public Catalogo getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Catalogo nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Catalogo getSexo() {
		return sexo;
	}

	public void setSexo(Catalogo sexo) {
		this.sexo = sexo;
	}

	public Catalogo getManoHabil() {
		return manoHabil;
	}

	public void setManoHabil(Catalogo manoHabil) {
		this.manoHabil = manoHabil;
	}

	

	


	
	
	
	
	
}
