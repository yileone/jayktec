package com.jayktec.TipoListener;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;

import com.jayktec.controlador.*;

public class ListenerUDP extends ListenerSygnalImplementer{
	public ArrayList<Parametro> parametros;

	public ListenerUDP() {
		// TODO Auto-generated constructor stub
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

	
}
