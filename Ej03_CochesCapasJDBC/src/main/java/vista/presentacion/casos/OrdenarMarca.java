package vista.presentacion.casos;

import org.springframework.stereotype.Component;

//import modelo.negocio.GestorCoche;

@Component
public class OrdenarMarca extends Casos {

	@Override
	public void ejecutar() {
		System.out.println(getGc().ordenarMarca());

	}

}
