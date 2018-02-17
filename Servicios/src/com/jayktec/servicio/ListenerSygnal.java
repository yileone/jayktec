/**
 * 
 */
package com.jayktec.servicio;

import java.net.*;

import com.jayktec.bd.objetos.*;

/**
 * @author Servicio que implementa la recepción de señal
 *
 */
public interface ListenerSygnal {

	int inicio();

	boolean getEncendido();

	void setEncendido(boolean interruptor);

	int getIntervalo();

	void setIntervalo(int intervalo);

	Protocolo getProtocolo();

	void setProtocolo();

	String getIP();

	void setIP(String ip);

	String getIp();

	int getPuerto();

	void setPuerto(int puerto);

	String getName();

	Object recepcionTrama() throws Exception;

	void creaSocket();

	InetAddress getReceiverAddress();

	void setReceiverAddress(InetAddress receiverAddress);

	void procesar();

	void stop();

	void restart();

	Registro decodificar(Object trama);

	void procesar(Registro trama);

}
