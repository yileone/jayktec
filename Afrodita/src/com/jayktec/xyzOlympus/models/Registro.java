package com.jayktec.xyzOlympus.models;

import java.util.Date;
import java.sql.Time;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;



@Entity
@Table(name="fateon_registro", schema="fateon")
@View(name="Simple",members="registroFloat1,registroFloat2,registroDate1")
public class Registro {

	
	@Id
	@GeneratedValue(generator="system-uuid")
	@Hidden
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="registro_id",length=32)
	private String oid; 	
	
	@Hidden
	@Column(name="registro_fecha",length=45)
	private String registroFecha;
	
	
	@Column(name="registro_float_1",length=45)
	private Float registroFloat1;
	
	@Column(name="registro_float_2",length=45)
	private Float registroFloat2;	


	
	@Column(name="registro_date_1",length=10)
	@DefaultValueCalculator(CurrentDateCalculator.class)
	private Date registroDate1;
	
	
	@Column(name="registro_time_1",length=9)
	@Stereotype("HORA_MINUTO")
	private Time registrotime1;
	


	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name="origen_id",insertable=true,updatable=true)
	private Origen origen;
	

	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name="sensor_id",insertable=true,updatable=true)
	private Sensor sensor;
	
	


	public Origen getOrigen() {
		return origen;
	}

	public void setOrigen(Origen origen) {
		this.origen = origen;
		
		
	}	

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getRegistroFecha() {
		return registroFecha;
	}

	public void setRegistroFecha(String registroFecha) {
		this.registroFecha = registroFecha;
	}

	public Float getRegistroFloat1() {
		return registroFloat1;
	}

	public void setRegistroFloat1(Float registroFloat1) {
		this.registroFloat1 = registroFloat1;
	}

	public Float getRegistroFloat2() {
		return registroFloat2;
	}

	public void setRegistroFloat2(Float registroFloat2) {
		this.registroFloat2 = registroFloat2;
	}

	public Date getRegistroDate1() {
		return registroDate1;
	}

	public void setRegistroDate1(Date registroDate1) {
		this.registroDate1 = registroDate1;
	}

	public Time getRegistrotime1() {
		return registrotime1;
	}

	public void setRegistrotime1(Time registrotime1) {
		this.registrotime1 = registrotime1;
	}

	
	
}
