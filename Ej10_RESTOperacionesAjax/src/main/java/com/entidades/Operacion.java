package com.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="operacion")

@Entity
public class Operacion {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private double operador1;
	private double operador2;
	private String operacion;
	private double resultado;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getOperador1() {
		return operador1;
	}
	public void setOperador1(double operador1) {
		this.operador1 = operador1;
	}
	public double getOperador2() {
		return operador2;
	}
	public void setOperador2(double operador2) {
		this.operador2 = operador2;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
	
	

}
