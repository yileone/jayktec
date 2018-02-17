package com.jayktec.xyzOlympus.models;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

@Entity
@Table(name="fateon_tabla", schema="fateon")
//@View(members="Ingresar Tabla {# nombre,tablaNemonico;programa,ubicacion;} Gestionar Catalogos {#catalogos}" )
@Views({
	 @View(name="VCatalogo", members="nombre; tablaNemonico; programa;ubicacion" ),
	})
public class Tabla implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@Hidden
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="tabla_id",length=32)
	private String oid; 
	
	@Required
	@Column(name="tabla_nombre",length=45)
	private String nombre;	

	
	@Required
	@Column(name="tabla_nemonico",length=45)
	private String tablaNemonico;
	
	@Column(name="tabla_programa",length=45)
	private String programa;
	

	@Column(name="tabla_ubicacion_programa",length=45)
	private String ubicacion;

	/*@OneToMany(mappedBy="fateon_catalogo")
	@ListProperties("catalogo_nemonico")
	private Collection<fateon_catalogo> catalogo;*/
	
	/*@OneToMany
	@JoinColumn(name="catalogo_id_tabla",insertable=true,updatable=true)
	private Collection<CatalogoBSDS> catalogos;
*/
   /* @OneToMany(targetEntity=com.jayktec.xyzOlympus.models.CatalogoBSDS.class,mappedBy="catalogo_id_tabla",fetch=FetchType.LAZY)
	private Collection<CatalogoBSDS> catalogos;*/

	/* Funciona
	 * @SuppressWarnings("deprecation")
	@OneToMany
	@JoinColumn(name="catalogo_id_tabla",insertable=true,updatable=true)
	@IndexColumn(name="fk_catalogo_tabla_idx")
	private Collection<Catalogo> catalogos;*/
	
	/*@OneToMany(mappedBy="tabla")
	private Collection<Catalogo> catalogos;*/
	

	@CollectionView("VTabla")
	@OneToMany(mappedBy="tabla")
	private Collection<Catalogo> catalogos;



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



	public String getTablaNemonico() {
		return tablaNemonico;
	}

	public void setTablaNemonico(String tablaNemonico) {
		this.tablaNemonico = tablaNemonico;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Collection<Catalogo> getCatalogos() {
		return catalogos;
	}

	public void setCatalogos(Collection<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

/*
	public static Collection findByNombreLike(String nombre) {
		 Query query = XPersistence.getManager().createQuery(
		 "from Cliente as o where o.nombre like :nombre order by o.nombre desc");
		 query.setParameter("nombre", nombre);
		 return query.getResultList();
		}
*/

	
	
	
	

}

