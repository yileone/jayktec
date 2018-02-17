/**
 * 
 */
package com.jayktec.controller;

import java.sql.*;
import java.util.logging.*;

/**
 * @author arte
 *
 */
public class Conexion {

	Connection conexion;
	private String url = "jdbc:mysql://localhost:3306/javabase";
	private String username = "root";
	private String password = "123456";

	/**
	 * 
	 */

	public Conexion() {

		try {
			conexion = DriverManager.getConnection(url, username, password);

			System.out.println("Database connected!");
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
					"Cannot connect the database!" + e.getMessage());

		}
	}

	/**
	 * @return the conexion
	 */
	public Connection getConexion() {
		return conexion;
	}

	/**
	 * @param conexion the conexion to set
	 */
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	
	
	
	
}
