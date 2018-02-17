package com.jayktec.servicio;
import java.util.*;

public class IniciadorServicios {

	public IniciadorServicios() {
		// TODO Auto-generated constructor stub
	}


    public static void main(String[] args) {
        ServiceLoader<ListenerSygnal> loader = ServiceLoader.load(ListenerSygnal.class);
        Iterator<ListenerSygnal> apit = loader.iterator();
        while (apit.hasNext()){
            System.out.println(apit.next().getName());
        apit.next().inicio();}
    }
    
}