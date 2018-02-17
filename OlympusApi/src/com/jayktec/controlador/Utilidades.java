package com.jayktec.controlador;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class Utilidades {

	/**
	 * Retorna Archivo properties del proyecto artycosta.  
	 * 
	 * @return Properties.   
	 */
	public static Properties loadProperties() {

		return loadProperties(Constantes.ARCHIVO_PROPERTIES);
	}

	/**
	 * Retorna Archivo properties del proyecto artycosta.  
	 * 
	 * @return Properties.   
	 */

	
	public static Properties loadProperties(String nombreArchivo) {

		Properties archivo = new Properties();

		try {

			archivo.load(Utilidades.class.getResourceAsStream(nombreArchivo));

		} catch (IOException e) {

			Logger.getLogger(Properties.class.getName()).log(Level.SEVERE,
					"Error fallo Archivo iPropiedades: " + e.getMessage());

		}

		return archivo;
	}
}
