package com.jayktec.xyzOlympus.models;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import java.util.Date;
import java.sql.Time;

@Entity
@Table(name="fateon_mapa", schema="fateon")
public class Mapa {
	@Id
	@GeneratedValue(generator="system-uuid")
	@Hidden
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="mapa_id",length=32)
	private String oid; 	
	
	/*@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="mapa_tabla",insertable=true,updatable=true)
	private Tablamapa nombre;*/
	
	//@NoModify
	//@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="mapa_tabla",insertable=true,updatable=true)
	@DescriptionsList(condition="e.oid in(SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='MapaTabla')",
			showReferenceView=true,
			descriptionProperties="valorCadena")  
	@ReferenceView("VMapa") 
	private Catalogo mapaTabla;
	
	/*@Column(name="mapa_campo",insertable=true,updatable=true)
	private String mapabd;
	*/
	
	@NoModify
	@NoCreate
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="mapa_campo",insertable=true,updatable=true)
	@DescriptionsList(condition="e.oid in( SELECT c.oid FROM Catalogo c, Tabla t where c.tabla = t.oid and t.nombre ='MapaCampo')",
			showReferenceView=false,
			descriptionProperties="valorCadena")  
	@ReferenceView("VVarchar") 
	private Catalogo mapabd;
	
	@Required
	@Column(name="mapa_nombre_campo",insertable=true,updatable=true)
	private String mapaapp;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}




	public Catalogo getMapabd() {
		return mapabd;
	}

	public void setMapabd(Catalogo mapabd) {
		this.mapabd = mapabd;
	}

	public Catalogo getMapaTabla() {
		return mapaTabla;
	}

	public void setMapaTabla(Catalogo mapaTabla) {
		this.mapaTabla = mapaTabla;
	}

	public String getMapaapp() {
		return mapaapp;
	}

	public void setMapaapp(String mapaapp) {
		this.mapaapp = mapaapp;
	}














	

	
	
	

}
