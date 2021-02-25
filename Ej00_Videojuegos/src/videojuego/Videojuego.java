package videojuego;

import java.util.Comparator;

public class Videojuego{
	
	
	private int id;
	private String titulo;
	private String compania;
	
	
	public Videojuego (int id, String titulo, String compania)
	{
		this.id = id;
		this.titulo = titulo;
		this.compania = compania;
	}
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
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compania == null) ? 0 : compania.hashCode());
		result = prime * result + id;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		if (compania == null) {
			if (other.compania != null)
				return false;
		} else if (!compania.equals(other.compania))
			return false;
		if (id != other.id)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", titulo=" + titulo + ", compania=" + compania + "]";
	}
}
