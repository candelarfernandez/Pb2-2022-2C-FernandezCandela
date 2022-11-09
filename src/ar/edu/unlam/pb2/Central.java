package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Central {
	private String nombre;
	private Set<Alarma> alarmas;

	public Central(String nombre) {
		this.nombre = nombre;
		this.alarmas= new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Alarma> getAlarmas() {
		return alarmas;
	}
	public void setAlarmas(Set<Alarma> alarmas) {
		this.alarmas = alarmas;
	}

	
	

}
