package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Alarma {
	private Integer id;
	private Boolean codigoActivacion;
	private Boolean codigoConfiguracion;
	private String nombre;
	private Set<Usuario> usuariosValidos;
	private Set<Accion> accionesRealizadas;
	
	public Alarma(Integer id, Boolean codigoActivacion, Boolean codigoConfiguracion, String nombre) {
		this.id = id;
		this.codigoActivacion = codigoActivacion;
		this.codigoConfiguracion = codigoConfiguracion;
		this.nombre = nombre;
		this.usuariosValidos= new HashSet<>();
		this.accionesRealizadas= new HashSet<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getCodigoActivacion() {
		return codigoActivacion;
	}

	public void setCodigoActivacion(Boolean codigoActivacion) {
		this.codigoActivacion = codigoActivacion;
	}

	public Boolean getCodigoConfiguracion() {
		return codigoConfiguracion;
	}

	public void setCodigoConfiguracion(Boolean codigoConfiguracion) {
		this.codigoConfiguracion = codigoConfiguracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Usuario> getUsuariosValidos() {
		return usuariosValidos;
	}

	public void setUsuariosValidos(Set<Usuario> usuariosValidos) {
		this.usuariosValidos = usuariosValidos;
	}

	public Set<Accion> getAccionesRealizadas() {
		return accionesRealizadas;
	}

	public void setAccionesRealizadas(Set<Accion> accionesRealizadas) {
		this.accionesRealizadas = accionesRealizadas;
	}
	
	
	
	
	

}
