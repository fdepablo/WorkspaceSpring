package modelo.entidades;

import modelo.negocio.GestorUsuario;

public class Usuario {
	
	private String nombre;
	
	private String password;
	
	private String direccion;
	
	private String telefono;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}

	public Usuario(String nombre, String password, String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
