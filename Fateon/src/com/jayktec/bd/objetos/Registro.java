package com.jayktec.bd.objetos;

import java.sql.*;

public class Registro {

	int id;
	Timestamp fechaRegistro;
	int sensor;
	int origen;
	/**
	 * @return the sensor
	 */
	public int getSensor() {
		return sensor;
	}
	/**
	 * @param sensor the sensor to set
	 */
	public void setSensor(int sensor) {
		this.sensor = sensor;
	}
	/**
	 * @return the origen
	 */
	public int getOrigen() {
		return origen;
	}
	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(int origen) {
		this.origen = origen;
	}
	String varchar1;
	String varchar2;
	String varchar3;
	String varchar4;
	String varchar5;
	int int1;
	int int2;
	int int3;
	int int4;
	int int5;
	float float1;
	float float2;
	float float3;
	float float4;
	float float5;
	Date date1;
	Date date2;
	Date date3;
	Date date4;
	Date date5;
	Timestamp hora1;
	Timestamp hora2;
	Timestamp hora3;
	Timestamp hora4;
	Timestamp hora5;
	/**
	 * @return the hora1
	 */
	public Timestamp getHora1() {
		return hora1;
	}
	/**
	 * @param hora1 the hora1 to set
	 */
	public void setHora1(Timestamp hora1) {
		this.hora1 = hora1;
	}
	/**
	 * @return the hora2
	 */
	public Timestamp getHora2() {
		return hora2;
	}
	/**
	 * @param hora2 the hora2 to set
	 */
	public void setHora2(Timestamp hora2) {
		this.hora2 = hora2;
	}
	/**
	 * @return the hora3
	 */
	public Timestamp getHora3() {
		return hora3;
	}
	/**
	 * @param hora3 the hora3 to set
	 */
	public void setHora3(Timestamp hora3) {
		this.hora3 = hora3;
	}
	/**
	 * @return the hora4
	 */
	public Timestamp getHora4() {
		return hora4;
	}
	/**
	 * @param hora4 the hora4 to set
	 */
	public void setHora4(Timestamp hora4) {
		this.hora4 = hora4;
	}
	/**
	 * @return the hora5
	 */
	public Timestamp getHora5() {
		return hora5;
	}
	/**
	 * @param hora5 the hora5 to set
	 */
	public void setHora5(Timestamp hora5) {
		this.hora5 = hora5;
	}
	/**
	 * 
	 */
	public Registro() {
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the fechaRegistro
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/**
	 * @return the varchar1
	 */
	public String getVarchar1() {
		return varchar1;
	}
	/**
	 * @param varchar1 the varchar1 to set
	 */
	public void setVarchar1(String varchar1) {
		this.varchar1 = varchar1;
	}
	/**
	 * @return the varchar2
	 */
	public String getVarchar2() {
		return varchar2;
	}
	/**
	 * @param varchar2 the varchar2 to set
	 */
	public void setVarchar2(String varchar2) {
		this.varchar2 = varchar2;
	}
	/**
	 * @return the varchar3
	 */
	public String getVarchar3() {
		return varchar3;
	}
	/**
	 * @param varchar3 the varchar3 to set
	 */
	public void setVarchar3(String varchar3) {
		this.varchar3 = varchar3;
	}
	/**
	 * @return the varchar4
	 */
	public String getVarchar4() {
		return varchar4;
	}
	/**
	 * @param varchar4 the varchar4 to set
	 */
	public void setVarchar4(String varchar4) {
		this.varchar4 = varchar4;
	}
	/**
	 * @return the varchar5
	 */
	public String getVarchar5() {
		return varchar5;
	}
	/**
	 * @param varchar5 the varchar5 to set
	 */
	public void setVarchar5(String varchar5) {
		this.varchar5 = varchar5;
	}
	/**
	 * @return the int1
	 */
	public int getInt1() {
		return int1;
	}
	/**
	 * @param int1 the int1 to set
	 */
	public void setInt1(int int1) {
		this.int1 = int1;
	}
	/**
	 * @return the int2
	 */
	public int getInt2() {
		return int2;
	}
	/**
	 * @param int2 the int2 to set
	 */
	public void setInt2(int int2) {
		this.int2 = int2;
	}
	/**
	 * @return the int3
	 */
	public int getInt3() {
		return int3;
	}
	/**
	 * @param int3 the int3 to set
	 */
	public void setInt3(int int3) {
		this.int3 = int3;
	}
	/**
	 * @return the int4
	 */
	public int getInt4() {
		return int4;
	}
	/**
	 * @param int4 the int4 to set
	 */
	public void setInt4(int int4) {
		this.int4 = int4;
	}
	/**
	 * @return the int5
	 */
	public int getInt5() {
		return int5;
	}
	/**
	 * @param int5 the int5 to set
	 */
	public void setInt5(int int5) {
		this.int5 = int5;
	}
	/**
	 * @return the float1
	 */
	public float getFloat1() {
		return float1;
	}
	/**
	 * @param float1 the float1 to set
	 */
	public void setFloat1(float float1) {
		this.float1 = float1;
	}
	/**
	 * @return the float2
	 */
	public float getFloat2() {
		return float2;
	}
	/**
	 * @param float2 the float2 to set
	 */
	public void setFloat2(float float2) {
		this.float2 = float2;
	}
	/**
	 * @return the float3
	 */
	public float getFloat3() {
		return float3;
	}
	/**
	 * @param float3 the float3 to set
	 */
	public void setFloat3(float float3) {
		this.float3 = float3;
	}
	/**
	 * @return the float4
	 */
	public float getFloat4() {
		return float4;
	}
	/**
	 * @param float4 the float4 to set
	 */
	public void setFloat4(float float4) {
		this.float4 = float4;
	}
	/**
	 * @return the float5
	 */
	public float getFloat5() {
		return float5;
	}
	/**
	 * @param float5 the float5 to set
	 */
	public void setFloat5(float float5) {
		this.float5 = float5;
	}
	/**
	 * @return the date1
	 */
	public Date getDate1() {
		return date1;
	}
	/**
	 * @param date1 the date1 to set
	 */
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	/**
	 * @return the date2
	 */
	public Date getDate2() {
		return date2;
	}
	/**
	 * @param date2 the date2 to set
	 */
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	/**
	 * @return the date3
	 */
	public Date getDate3() {
		return date3;
	}
	/**
	 * @param date3 the date3 to set
	 */
	public void setDate3(Date date3) {
		this.date3 = date3;
	}
	/**
	 * @return the date4
	 */
	public Date getDate4() {
		return date4;
	}
	/**
	 * @param date4 the date4 to set
	 */
	public void setDate4(Date date4) {
		this.date4 = date4;
	}
	/**
	 * @return the date5
	 */
	public Date getDate5() {
		return date5;
	}
	/**
	 * @param date5 the date5 to set
	 */
	public void setDate5(Date date5) {
		this.date5 = date5;
	}
	
	
	
}
