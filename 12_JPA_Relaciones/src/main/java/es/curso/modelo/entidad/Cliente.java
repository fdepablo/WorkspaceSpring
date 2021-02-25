package es.curso.modelo.entidad;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String telefono;

	// Relaci�n de uno a uno con dos tablas
	// @OneToOne en cliente le hacemos Extremo opcional, solo es
	// obligatorio en una de las dos, si lo ponemos en las dos
	// hacemos la relacion bidimensional
	//   CascadeType.ALL, siempre que hagamos cualquier accion
	// sobre un cliente, reaccionamos de igual manera con 
	// sus datos bancarios, por ejemplo si borramos un cliente
	// borramos sus datos bancarios
	//   mappedBy, hay que decirle con cual de todos los
	// posibles atributos de tipo cliente que tiene los 
	// DatosBancarios es el con el que nos estamos relacionando
	// (en este caso solo hay uno)
	@OneToOne(mappedBy = "cliente", cascade=CascadeType.ALL)
	private DatosBancarios datosBancarios;
	
	// Relacion de uno a muchos
	// Extremo opcional
	// Este cascade no seria realmente necesario, ya que lo 
	// suyo sería insertar primero el cliente y luego sus pedidos
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL) 
	private List<Pedido> pedidos;
	
	//Relacion de muchos a muchos
	@ManyToMany(mappedBy="clientes", cascade=CascadeType.ALL) //Este cascade es una aberracion
	private List<Comercial> comerciales;
	

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer id, String nombre, String telefono,
			DatosBancarios datosBancarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.datosBancarios = datosBancarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public DatosBancarios getDatosBancarios() {
		return datosBancarios;
	}

	public void setDatosBancarios(DatosBancarios datosBancarios) {
		this.datosBancarios = datosBancarios;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Comercial> getComerciales() {
		return comerciales;
	}

	public void setComerciales(List<Comercial> comerciales) {
		this.comerciales = comerciales;
	}
	
}
