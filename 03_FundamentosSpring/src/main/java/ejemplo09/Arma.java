package ejemplo09;

public abstract class Arma {
	private String tipo;
	
	public abstract void usar();

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
