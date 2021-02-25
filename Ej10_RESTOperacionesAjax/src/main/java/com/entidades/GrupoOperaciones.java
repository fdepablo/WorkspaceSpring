package com.entidades;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="operaciones")
public class GrupoOperaciones {

	private List <Operacion>  operaciones;

	@XmlElement (name="operacion")
	public List<Operacion> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(List<Operacion> operaciones) {
		this.operaciones = operaciones;
	}
	
	
	
	
}
