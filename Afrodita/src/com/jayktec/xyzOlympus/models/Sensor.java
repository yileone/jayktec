package com.jayktec.xyzOlympus.models;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@Entity
@Table(name="fateon_sensor", schema="fateon")
public class Sensor {
	
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@Hidden
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="sensor_id",length=32)
	private String oid; 
	
	
	
	@Column(name="sensor_nombre",length=45)
	private String nombre;	
	
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="sensor_programa",insertable=true,updatable=true)
	private Programa programa;


	/*@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="sensor_tabla",insertable=true,updatable=true)
	private Tablamapa mapa;*/
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="sensor_tabla",insertable=true,updatable=true)
	@DescriptionsList(condition="e.oid in(SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='MapaTabla')")  
	@ReferenceView("VVarchar") 
	private Catalogo mapa;
	



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Programa getPrograma() {
		return programa;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Catalogo getMapa() {
		return mapa;
	}

	public void setMapa(Catalogo mapa) {
		this.mapa = mapa;
	}















	
	

}
