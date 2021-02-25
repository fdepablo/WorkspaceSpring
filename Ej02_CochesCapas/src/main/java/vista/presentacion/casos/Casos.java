package vista.presentacion.casos;

import modelo.negocio.GestorCoche;

public abstract class Casos {
	
	private GestorCoche gc;
		
	public abstract void ejecutar();

	public GestorCoche getGc() {
		return gc;
	}

	public void setGc(GestorCoche gc) {
		this.gc = gc;
	}
	
}
