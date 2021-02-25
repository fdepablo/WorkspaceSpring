package vista.presentacion.casos;

//import modelo.negocio.GestorCoche;

public class OrdenarModelo extends Casos {

	@Override
	public void ejecutar() {
		System.out.println(getGc().ordenarPorModelo());
	}

}
