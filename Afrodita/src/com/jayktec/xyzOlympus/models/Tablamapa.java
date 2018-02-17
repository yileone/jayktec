package com.jayktec.xyzOlympus.models;

import java.util.Date;
import java.sql.Time;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import org.openxava.annotations.*;



@Entity
@Table(name="fateon_tabla_mapa", schema="fateon")
public class Tablamapa {

	
	@Id
	@GeneratedValue(generator="system-uuid")
	@Hidden
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="tabla_mapa_id",length=32)
	private String oid; 	
	
	
	@Column(name="tabla_mapa_nombre",length=45)
	private String nombre;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
