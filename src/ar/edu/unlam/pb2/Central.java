package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Central {
	private String nombre;
	private Set<Alarma> alarmas;
	private Set<Alarma> alarmasDesactivadas;

	public Central(String nombre) {
		this.nombre = nombre;
		this.alarmas= new HashSet<>();
		this.alarmasDesactivadas= new HashSet<>();
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

	public Set<Alarma> getAlarmasDesactivadas() {
		return alarmasDesactivadas;
	}

	public void setAlarmasDesactivadas(Set<Alarma> alarmasDesactivadas) {
		this.alarmasDesactivadas = alarmasDesactivadas;
	}
	

	
	

}
