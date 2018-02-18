package com.jayktec.traductor;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.jayktec.xyzOlympus.models.*;
import com.jayktec.controlador.Constantes;
import com.jayktec.persistencia.BdManager;

public class ToJson {

	Sensor sensor;
	Registro registro;
	ArrayList<Registro> listaRegistro;
	ArrayList<Mapa> mapa;
	String origen = "";
	private boolean refrescar;
	BdManager bd = new BdManager();

	public ToJson(ArrayList<Registro> registros, String origen, Sensor sensor) throws SQLException {
		this(origen, sensor);
		this.listaRegistro = registros;

	}

	public ToJson(String origen, Sensor sensor) throws SQLException {
		this.origen = origen;
		this.sensor = sensor;
		mapaParaSensor();
		refrescar = true;
	}

	public void refrescarJson(Object object) throws SQLException, JsonIOException, IOException {

		if (origen.length() > 0) {
			refrescar = true;

			if (object instanceof Sensor) {
				Sensor sensor = (Sensor) object;
				mapaParaSensor(sensor);
				crearJson();

			}
			if (object instanceof Registro) {
				Registro registro = (Registro) object;
				mapaParaSensor(registro);
				crearJson();

			}
		}
	}

	private void crearJson() throws SQLException, JsonIOException, IOException {
		// TODO Auto-generated method stub
		if (refrescar) {
			mapaParaSensor();
			buscarRegistros();
		}

		Gson salida = new GsonBuilder().create();
		String temp = "{";

		for (Registro registro : listaRegistro) {
			temp = temp + "{";
			for (Mapa mapaItem : mapa) {
				String campo = mapaItem.getCampo();
				String valor = "";
				String nombreCampo = mapaItem.getMapaapp();
				if (campo.equals(Constantes.CampoRegistro.DATE1.campoBD)) {
					valor = registro.getRegistroDate1().toString();
				}
				if (campo.equals(Constantes.CampoRegistro.DATE2.campoBD)) {
					valor = registro.getRegistroDate2().toString();
				}
				if (campo.equals(Constantes.CampoRegistro.DATE3.campoBD)) {
					valor = registro.getRegistroDate3().toString();
				}
				if (campo.equals(Constantes.CampoRegistro.DATE4.campoBD)) {
					valor = registro.getRegistroDate4().toString();
				}
				if (campo.equals(Constantes.CampoRegistro.DATE5.campoBD)) {
					valor = registro.getRegistroDate5().toString();
				}

				if (campo.equals(Constantes.CampoRegistro.INT1.campoBD)) {
					valor = String.valueOf(registro.getRegistroInt1());
				}
				if (campo.equals(Constantes.CampoRegistro.INT2.campoBD)) {
					valor = String.valueOf(registro.getRegistroInt2());
				}
				if (campo.equals(Constantes.CampoRegistro.INT3.campoBD)) {
					valor = String.valueOf(registro.getRegistroInt3());
				}
				if (campo.equals(Constantes.CampoRegistro.INT4.campoBD)) {
					valor = String.valueOf(registro.getRegistroInt4());
				}
				if (campo.equals(Constantes.CampoRegistro.INT5.campoBD)) {
					valor = String.valueOf(registro.getRegistroInt5());
				}
				if (campo.equals(Constantes.CampoRegistro.FLOAT1.campoBD)) {
					valor = String.valueOf(registro.getRegistroFloat1());
				}
				if (campo.equals(Constantes.CampoRegistro.FLOAT2.campoBD)) {
					valor = String.valueOf(registro.getRegistroFloat2());
				}
				if (campo.equals(Constantes.CampoRegistro.FLOAT3.campoBD)) {
					valor = String.valueOf(registro.getRegistroFloat3());
				}
				if (campo.equals(Constantes.CampoRegistro.FLOAT4.campoBD)) {
					valor = String.valueOf(registro.getRegistroFloat4());
				}
				if (campo.equals(Constantes.CampoRegistro.FLOAT5.campoBD)) {
					valor = String.valueOf(registro.getRegistroFloat5());
				}

				if (campo.equals(Constantes.CampoRegistro.VARCHAR1.campoBD)) {
					valor = registro.getRegistroVarchar1();
				}
				if (campo.equals(Constantes.CampoRegistro.VARCHAR2.campoBD)) {
					valor = registro.getRegistroVarchar2();
				}
				if (campo.equals(Constantes.CampoRegistro.VARCHAR3.campoBD)) {
					valor = registro.getRegistroVarchar3();
				}
				if (campo.equals(Constantes.CampoRegistro.VARCHAR4.campoBD)) {
					valor = registro.getRegistroVarchar4();
				}
				if (campo.equals(Constantes.CampoRegistro.VARCHAR5.campoBD)) {
					valor = registro.getRegistroVarchar5();
				}

				if (campo.equals(Constantes.CampoRegistro.HORA1.campoBD)) {
					valor = String.valueOf(registro.getRegistrotime1());
				}
				if (campo.equals(Constantes.CampoRegistro.HORA2.campoBD)) {
					valor = String.valueOf(registro.getRegistrotime2());
				}
				if (campo.equals(Constantes.CampoRegistro.HORA3.campoBD)) {
					valor = String.valueOf(registro.getRegistrotime3());
				}
				if (campo.equals(Constantes.CampoRegistro.HORA4.campoBD)) {
					valor = String.valueOf(registro.getRegistrotime4());
				}
				if (campo.equals(Constantes.CampoRegistro.HORA5.campoBD)) {
					valor = String.valueOf(registro.getRegistrotime5());
				}

				temp = temp + '\n' + '\"' + nombreCampo + '\"' + ":" + '\"' + valor + '\"';

			}

			temp = temp + "}" + '\n';

		}
		temp = temp + "}" + '\n';

		FileWriter archivo= new FileWriter(
				"./" + origen + "_" + sensor + Calendar.YEAR + Calendar.MONTH + Calendar.DATE + ".json");
		salida.toJson(temp, archivo);
		archivo.close();
	
	}

	private void buscarRegistros() throws SQLException {
		// TODO Auto-generated method stub
		this.listaRegistro = null;
		this.listaRegistro = bd.consultarRegistro(origen, sensor);

	}

	public void mapaParaSensor() throws SQLException {
		mapa = bd.consultarMapa(sensor);

	}

	public void mapaParaSensor(Sensor sensor) throws SQLException {
		mapa = bd.consultarMapa(sensor);

	}

	public void mapaParaSensor(Registro registro) throws SQLException {
		mapa = bd.consultarMapa(registro);

	}

	/**
	 * @return the sensor
	 */
	public Sensor getSensor() {
		return sensor;
	}

	/**
	 * @param sensor
	 *            the sensor to set
	 */
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	/**
	 * @return the registro
	 */
	public Registro getRegistro() {
		return registro;
	}

	/**
	 * @param registro
	 *            the registro to set
	 */
	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	/**
	 * @return the listaRegistro
	 */
	public ArrayList<Registro> getListaRegistro() {
		return listaRegistro;
	}

	/**
	 * @param listaRegistro
	 *            the listaRegistro to set
	 */
	public void setListaRegistro(ArrayList<Registro> listaRegistro) {
		this.listaRegistro = listaRegistro;
	}

	/**
	 * @return the mapa
	 */
	public ArrayList<Mapa> getMapa() {
		return mapa;
	}

	/**
	 * @param mapa
	 *            the mapa to set
	 */
	public void setMapa(ArrayList<Mapa> mapa) {
		this.mapa = mapa;
	}

}
