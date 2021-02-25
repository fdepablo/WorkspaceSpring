package modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Operacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private double num1;
	
	private double num2;
	
	private String operador;
	
	private double res;

	public Operacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Operacion(double num1, double num2, String operador) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.operador = operador;
		this.res = 0;
	}

	public Operacion(int id, double num1, double num2, String operador) {
		super();
		this.id = id;
		this.num1 = num1;
		this.num2 = num2;
		this.operador = operador;
		this.res = 0;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public double getRes() {
		return res;
	}

	public void setRes(double res) {
		this.res = res;
	}

	@Override
	public String toString() {
		return "Operacion [id=" + id + ", num1=" + num1 + ", num2=" + num2 + ", operador=" + operador + ", res=" + res
				+ "]";
	}
}
