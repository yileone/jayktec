package com.jayktec.controlador;

public class Constantes {

	public static final String ARCHIVO_PROPERTIES = "/config/properties/olympus.properties";
	public static final String IP ="IP";
	public static final String PUERTO ="PORT";
	
	public enum CampoRegistro {

		SENSOR("sensor_id"),
		FECHA_REGISTRO("registro_fecha"),
		ORIGEN("origen_id"),
		ID_("registro_id"),
				
		HORA1("registro_datetime_1"),
		HORA2("registro_datetime_2"),
		HORA3("registro_datetime_3"),
		HORA4("registro_datetime_4"),
		HORA5("registro_datetime_5"),
			
		INT1("registro_int_1"),
		INT2("registro_int_2"),
		INT3("registro_int_3"),
		INT4("registro_int_4"),
		INT5("registro_int_5"),
		
	    FLOAT1("registro_float_1"),
	    FLOAT2("registro_float_2"),
	    FLOAT3("registro_float_3"),
	    FLOAT4("registro_float_4"),
	    FLOAT5("registro_float_5"),
			
	    VARCHAR1("registro_varchar_1"),
	    VARCHAR2("registro_varchar_2"),
	    VARCHAR3("registro_varchar_3"),
	    VARCHAR4("registro_varchar_4"),
	    VARCHAR5("registro_varchar_5"),
	    
	    DATE1("registro_date_1"),
	    DATE2("registro_date_2"),
	    DATE3("registro_date_3"),
	    DATE4("registro_date_4"),
	    DATE5("registro_date_5");
		
		public String campoBD;
		
		private CampoRegistro(String campo) {
			this.campoBD= campo;
			// TODO Auto-generated constructor stub
		}
		
		public String campoBD()
		{
			return campoBD;
		}
	}
}
