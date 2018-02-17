package com.jayktec.xyzOlympus.models;



import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import com.sun.istack.internal.*;



 import com.jayktec.persistencia.*;
 



/*
id_origen	 int(11)
   nombre	 varchar(45)
   modelo	 varchar(45)
      mac	 varchar(45)
  id_tipo	 int(11)
 id_sistema	 int(11)
 id_sucursal int(11)
 id_oficina	 int(11)
id_municipio int(11)
   id_ciudad int(11)
     id_pais int(11)

*/
@Entity
//@View(members="Orige {#nombre,modelo;mac,ip; sistema,tipo;} DIRECCION {#pais,municipio,sucursal,oficina,ciudad}" )
@Table(name="fateon_origen", schema="fateon")
public class Origen {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@Hidden
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="origen_id",length=32)
	private String oid; 
	
	@Required
	@Column(name="origen_nombre",length=45)
	private String nombre;	
	
	//@Required
	@Column(name="origen_modelo",length=45)
	private String modelo;
	
	//@Required
	@Column(name="origen_mac",length=45)
	private String mac;	
	
	//@Required
	@Column(name="origen_ip",length=15,nullable = true) 
    @Pattern(regexp="^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +// Se valida la direccion IP 
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$",
        message = "Direccion IP Ivalida") 
	private String ip;
	



	//@NoModify
	//@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="origen_id_tipo",insertable=true,updatable=true,table="fateon_origen")
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='Tipo_Sistemas')",
			showReferenceView=false,
			descriptionProperties="valorCadena")  
	@ReferenceView("VVarchar") 
	private Catalogo tipo;
	
	//@NoModify
	//@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="origen_id_sistema",insertable=true,updatable=true,table="fateon_origen")
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='Sistemas')",
			showReferenceView=false,
			descriptionProperties="valorCadena")  
	@ReferenceView("VVarchar") 
	private Catalogo sistema;
	

	//@NoModify
	//@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="origen_id_sucursal",insertable=true,updatable=true)
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='Sucursales')",
			showReferenceView=false,
			descriptionProperties="valorCadena")  
	@ReferenceView("VVarchar") 
	private Catalogo sucursal;
	
	
	//@NoModify
	//@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="origen_id_oficina",insertable=true,updatable=true)
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='Oficinas')",
			showReferenceView=false,
			descriptionProperties="valorCadena")  
	@ReferenceView("VVarchar") 
	private Catalogo oficina;
	
	//@NoModify
	//@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="origen_id_municipio",insertable=true,updatable=true)
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='Municipios')",
			showReferenceView=false,
			descriptionProperties="valorCadena")  
	@ReferenceView("VVarchar") 
	private Catalogo municipio;

	//@NoModify
	//@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="origen_id_pais",insertable=true,updatable=true)
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='Paises')",
			showReferenceView=false,
			descriptionProperties="valorCadena")  
	@ReferenceView("VVarchar") 
	private Catalogo pais;
	
	//@NoModify
	//@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="origen_id_ciudad",insertable=true,updatable=true)
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='Ciudades')",
			showReferenceView=false,
			descriptionProperties="valorCadena")  
	@ReferenceView("VVarchar") 
	private Catalogo ciudad;
	
	
	
	public Catalogo getCiudad() {
		return ciudad;
	}


	public void setCiudad(Catalogo ciudad) {
		this.ciudad = ciudad;
	}


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


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getMac() {
		return mac;
	}


	public void setMac(String mac) {
		this.mac = mac;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}




	public Catalogo getSistema() {
		return sistema;
	}


	public void setSistema(Catalogo sistema) {
		this.sistema = sistema;
	}


	public Catalogo getTipo() {
		return tipo;
	}


	public void setTipo(Catalogo tipo) {
		this.tipo = tipo;
	}


	public Catalogo getSucursal() {
		return sucursal;
	}


	public void setSucursal(Catalogo sucursal) {
		this.sucursal = sucursal;
	}


	public Catalogo getOficina() {
		return oficina;
	}


	public void setOficina(Catalogo oficina) {
		this.oficina = oficina;
	}


	public Catalogo getMunicipio() {
		return municipio;
	}


	public void setMunicipio(Catalogo municipio) {
		this.municipio = municipio;
	}


	public Catalogo getPais() {
		return pais;
	}


	public void setPais(Catalogo pais) {
		this.pais = pais;
	}







	

}

