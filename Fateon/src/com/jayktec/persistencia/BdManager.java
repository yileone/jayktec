package com.jayktec.persistencia;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import com.jayktec.bd.objetos.*;
import com.jayktec.controlador.Constantes;
import com.jayktec.controller.*;

public class BdManager {
	Connection connection;

	/**
	 * 
	 */
	public BdManager() {
		Conexion conexion = new Conexion();
		connection = conexion.getConexion();

	}

	public Object search(Object object) throws SQLException {
		if (object instanceof Registro) {
			return consultarRegistro((Registro) object);
		}
		return null;
	}

	public ArrayList<Registro> consultarRegistro(String origen, Sensor sensor) throws SQLException {

		String sql = "select * from fateon_registro where sensor_id=" + sensor.getId()+
				" origen_id="+origen;
		return consultarRegistro(sql);

	}

	public ArrayList<Registro> consultarRegistro(Registro object) throws SQLException {
		String sql = "select * from fateon_registro where sensor_id=" + object.getSensor();
		return consultarRegistro(sql);

	}

	public int save(Object object) throws SQLException {
		if (object instanceof Registro) {
			salvarRegistro((Registro) object);
		}
		return -1;
	}

	public int delete(Object object) throws SQLException {
		if (object instanceof Registro) {
			borrarRegistro((Registro) object);
		}

		return -1;
	}

	public ArrayList<Mapa> consultarMapa(Registro registro) throws SQLException {

		String sql = "select a.* from fateon_mapa a" + " fateon_sensor b  where  " + "a.mapa_id= b.sensor_mapa and"
				+ "a.mapa_id =" + registro.getSensor();
		return consultarMapa(sql);
		// TODO Auto-generated method stub

	}

	public ArrayList<Mapa> consultarMapa(Sensor sensor) throws SQLException {

		String sql = "select a.* from fateon_mapa a where  " + "a.mapa_id =" + sensor.getMapa();
		return consultarMapa(sql);
		// TODO Auto-generated method stub

	}

	public ArrayList<Mapa> consultarMapa(String sql) throws SQLException {

		PreparedStatement pst = connection.prepareStatement(sql);

		ResultSet rs = consultarSql(pst);

		ArrayList<Mapa> respuesta = new ArrayList<Mapa>();
		while (rs.next()) {

			Mapa temp = new Mapa();
			temp.setCampo(rs.getString(("mapa_campo")));
			temp.setFecha(rs.getDate(("mapa_fecha")));
			temp.setId(rs.getString(("mapa_id")));
			temp.setCatalogo(rs.getString(("mapa_catalogo")));
			respuesta.add(temp);

		}

		return respuesta;
		// TODO Auto-generated method stub

	}

	public ArrayList<Registro> consultarRegistro (String sql) throws SQLException {

		PreparedStatement pst = connection.prepareStatement(sql);

		ResultSet rs = consultarSql(pst);

		ArrayList<Registro> respuesta = new ArrayList<Registro>();
		while (rs.next()) {

			Registro temp = new Registro();
			temp.setDate1(rs.getDate(Constantes.CampoRegistro.DATE1.campoBD()));
			temp.setDate2(rs.getDate("registro_date_2"));
			temp.setDate3(rs.getDate("registro_date_3"));
			temp.setDate4(rs.getDate("registro_date_4"));
			temp.setDate5(rs.getDate("registro_date_5"));
			temp.setFloat1(rs.getFloat("registro_float_1"));
			temp.setFloat2(rs.getFloat("registro_float_2"));
			temp.setFloat3(rs.getFloat("registro_float_3"));
			temp.setFloat4(rs.getFloat("registro_float_4"));
			temp.setFloat5(rs.getFloat("registro_float_5"));
			temp.setInt1(rs.getInt("registro_int_1"));
			temp.setInt2(rs.getInt("registro_int_2"));
			temp.setInt3(rs.getInt("registro_int_3"));
			temp.setInt4(rs.getInt("registro_int_4"));
			temp.setInt5(rs.getInt("registro_int_5"));
			temp.setVarchar1(rs.getString("registro_varchar_1"));
			temp.setVarchar2(rs.getString("registro_varchar_2"));
			temp.setVarchar3(rs.getString("registro_varchar_3"));
			temp.setVarchar4(rs.getString("registro_varchar_4"));
			temp.setVarchar5(rs.getString("registro_varchar_5"));
			temp.setHora1(rs.getTimestamp("registro_datetime_1"));
			temp.setHora2(rs.getTimestamp("registro_datetime_2"));
			temp.setHora3(rs.getTimestamp("registro_datetime_3"));
			temp.setHora4(rs.getTimestamp("registro_datetime_4"));
			temp.setHora5(rs.getTimestamp("registro_datetime_5"));
			temp.setSensor(rs.getInt("sensor_id"));
			temp.setOrigen(rs.getInt("origen_id"));
			temp.setId(rs.getInt("registro_id"));
			temp.setFechaRegistro(rs.getTimestamp("registro_fecha"));
			respuesta.add(temp);

		}

		return respuesta;
		// TODO Auto-generated method stub

	}

	public int borrarRegistro(Registro object) throws SQLException {
		// TODO Auto-generated method stub
		String sql = null;
		PreparedStatement pst = connection.prepareStatement(sql);
		return ejecutarSql(pst);
	}

	public int salvarRegistro(Registro object) throws SQLException {
		// TODO Auto-generated method stub
		String sql = null;
		PreparedStatement pst = connection.prepareStatement(sql);
		return ejecutarSql(pst);

	}

	public ResultSet consultarSql(PreparedStatement pst) {
		try {
			ResultSet rs = null;

			// int registros = 0;
			rs = pst.executeQuery();

			pst.close();
			return rs;

		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
					"Error in insert in the bd:" + e.getMessage());

			return null;

		}

	}

	public int ejecutarSql(PreparedStatement pst) {
		try {
			ResultSet rs = null;

			// int registros = 0;
			rs = pst.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();

			while (rs.next()) {
				for (int i = 1; i <= rsm.getColumnCount(); i++) {

				}
				// registros++;
			}

			rs.close();
			pst.close();

		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
					"Error in insert in the bd:" + e.getMessage());

			return -1;

		}
		return 0;

	}

}
