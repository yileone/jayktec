package com.jayktec.servicio;

import com.jayktec.TipoListener.*;
import com.jayktec.controlador.*;

public class NetFlow  extends ListenerUDP{

	Configuracion configuracion;
	public NetFlow() {
		// TODO Auto-generated constructor stub
		configuracion=new Configuracion("NetFlow.properties");
		parametros=configuracion.getParametros();
		
	}

	

}
