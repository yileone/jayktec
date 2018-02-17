package com.jayktec.xyzOlympus.models;

import java.io.*;
import java.util.*;
import javax.persistence.*;

import org.openxava.annotations.*;

/*
Table: club
Columns:
idclub int(11) AI PK 
razonSocial varchar(45) 
direccion longtext 
logo blob 
fono varchar(45) 
email varchar(45) 
paginaWeb varchar(45)*/


@Entity
@Table(name="club", schema="deportic")
public class Club implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Hidden
	@Column(name="idclub",length=11)
	private int oid;

	@Column(name="razonSocial",length=45)
	private String razonSocial;

	@Column(name="logo",length=255)
	@Stereotype("FOTO")
	private byte[] logo;
	

@OneToMany(mappedBy="club")
@CollectionView("VClub")
private Collection<Contacto> listacontactos;

	
	public Collection<Contacto> getListacontactos() {
	return listacontactos;
}

public void setListacontactos(Collection<Contacto> listacontactos) {
	this.listacontactos = listacontactos;
}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	
	
	
}
