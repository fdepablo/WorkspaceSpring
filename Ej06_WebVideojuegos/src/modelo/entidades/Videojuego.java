package modelo.entidades;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Videojuego {
	
	private int id;
	@NotBlank
	private String titulo;
	@Positive
	private double precio;
	@NotBlank
	private String empresa;
	@NotBlank
	private String plataforma;
	
	private Date fechaPublic;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public Date getFechaPublic() {
		return fechaPublic;
	}
	public void setFechaPublic(Date fechaPublic) {
		this.fechaPublic = fechaPublic;
	}
	
	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", precio=" + precio + ", empresa=" + empresa + ", plataforma="
				+ plataforma + ", fechaPublic=" + fechaPublic + "]";
	}
	
}
