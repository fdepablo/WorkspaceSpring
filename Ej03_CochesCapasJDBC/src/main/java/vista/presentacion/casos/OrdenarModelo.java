package vista.presentacion.casos;

import org.springframework.stereotype.Component;

//import modelo.negocio.GestorCoche;

@Component
public class OrdenarModelo extends Casos {

	@Override
	public void ejecutar() {
		System.out.println(getGc().ordenarModelo());
	}

}
