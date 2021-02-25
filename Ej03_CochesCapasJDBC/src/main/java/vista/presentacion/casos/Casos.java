package vista.presentacion.casos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import modelo.negocio.GestorCoche;

@Component
public abstract class Casos {
	
	@Autowired
	private GestorCoche gc;
		
	public abstract void ejecutar();

	public GestorCoche getGc() {
		return gc;
	}

	public void setGc(GestorCoche gc) {
		this.gc = gc;
	}
	
}
