package com.jayktec.TipoListener;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

import com.jayktec.xyzOlympus.models.*;
import com.jayktec.controlador.*;
import com.jayktec.servicio.*;

public class ListenerSygnalImplementer implements ListenerSygnal {
	public ArrayList<Parametro> parametros;
	Queue<Object> listaDeTramas;
	DatagramPacket inPacket;
	DatagramSocket socket = null;
	private InetAddress receiverAddress;
	protected  Queue<Registro> listaDecodifcada;
	protected LinkedBlockingQueue<Registro> listaDecodificada;

	public ListenerSygnalImplementer() {
		// TODO Auto-generated constructor stub
		listaDeTramas = new LinkedBlockingQueue<>(100);
		listaDecodificada = new LinkedBlockingQueue<Registro>(100);
		parametros = new ArrayList<Parametro>();
	}

	@Override
	public int inicio() {
		cargaParametrosGenerales();
		setEncendido(true);
		procesar();
		// TODO Auto-generated method stub
		return 0;
	}

	private void cargaParametrosGenerales() {
		// TODO Auto-generated method stub
		for (Parametro parametro : parametros) {
			if (parametro.getNombreUnidad().equals(this.getClass().getName())) {
				if (parametro.getCampo().toUpperCase().equals(Constantes.PUERTO)) {
					setPuerto(Integer.valueOf(parametro.getValor()));

				}
				if (parametro.getCampo().toUpperCase().equals(Constantes.IP)) {
					setIP(parametro.getValor());

				}
			}
		}
	}

	@Override
	public boolean getEncendido() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEncendido(boolean interruptor) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getIntervalo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setIntervalo(int intervalo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Protocolo getProtocolo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProtocolo() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getIP() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIP(String ip) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getIp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPuerto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPuerto(int puerto) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InetAddress getReceiverAddress() {
		return receiverAddress;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setReceiverAddress(InetAddress receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	@Override
	public void creaSocket() {

		try {

			setReceiverAddress(InetAddress.getByName(this.getIP()));
			socket = new DatagramSocket(this.getPuerto(), getReceiverAddress());
			setSocketUDP(socket);

			byte[] outBuf = new byte[4096];

			inPacket = new DatagramPacket(outBuf, outBuf.length, getReceiverAddress(), this.getPuerto());

		} catch (UnknownHostException e) {
			Logger.getLogger(getName()).log(Level.SEVERE, "Error UnknownHostException: " + e.getMessage());
		} catch (SocketException e) {

			Logger.getLogger(getName()).log(Level.SEVERE, "Error SocketException: " + e.getMessage());

		}

	}

	private void setSocketUDP(DatagramSocket socket2) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object recepcionTrama() throws Exception {
		try {
			if (getSocketUDP() == null)
				creaSocket();

			byte[] outBuf = new byte[1024];

			if (inPacket == null) {
				inPacket = new DatagramPacket(outBuf, outBuf.length, getReceiverAddress(), this.getPuerto());
			}

			inPacket.setData(outBuf);
			inPacket.setLength(outBuf.length);

			((DatagramSocket) getSocketUDP()).receive(inPacket);

		} catch (IOException e) {

			Logger.getLogger(getName()).log(Level.SEVERE, "Error IOException: " + e.getMessage());
		}

		return inPacket.getData();

	}

	private Object getSocketUDP() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		if (socket != null)
			socket.close();
		super.finalize();
	}

	@Override
	public void procesar() {
		Runnable escuchando = new Runnable() {

			@Override
			public void run() {

				while (true) {
					if (getEncendido()) {
						try {
							Object recibo = recepcionTrama();
							if (recibo != null) {
								listaDeTramas.add(recibo);

							}

							Thread.sleep(100);

						} catch (Exception e) {
							Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
									"Error escuchando: " + e.getMessage());

						}
					} else {

						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {

						}
					}
				}

			}

		};

		Runnable decodificando = new Runnable() {

			@Override
			public void run() {

				while (true) {
					if (getEncendido()) {
						try {
							Object trama = listaDeTramas.poll();
							if (trama != null) {
								Registro decodificado = decodificar(trama);

								if (decodificado != null) {
									listaDecodificada.add(decodificado);
								}

							}

							Thread.sleep(100);

						} catch (Exception e) {
							Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
									"Error decodificando: " + e.getMessage());

						}
					} else {

						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {

						}
					}
				}

			}

		};
		Runnable procesando = new Runnable() {

			@Override
			public void run() {

				while (true) {
					if (getEncendido()) {
						try {
							Registro trama = listaDecodifcada.poll();
							if (trama != null) {
								procesar(trama);

								

							}

							Thread.sleep(100);

						} catch (Exception e) {
							Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
									"Error decodificando: " + e.getMessage());

						}
					} else {

						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {

						}
					}
				}

			}

		};
		 (new Thread(escuchando, "escuchando " + this.getClass().toString())).start();
		 (new Thread(decodificando, "decodificando " + this.getClass().toString())).start();
		 (new Thread(procesando, "procesando " + this.getClass().toString())).start();
			
	
	}

	@Override
	public void procesar(Registro trama) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Registro decodificar(Object trama) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		setEncendido(false);

	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		setEncendido(true);
	}

}
