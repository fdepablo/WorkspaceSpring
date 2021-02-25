package com.entidades;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Historia {

	private String personaje;
	private String mensaje;
	
	
	
	public String getPersonaje() {
		return personaje;
	}
	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
