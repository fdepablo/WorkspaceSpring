package vista.presentacion.casos;

//import modelo.negocio.GestorCoche;

public class OrdenarMarca extends Casos {

	@Override
	public void ejecutar() {
		System.out.println(getGc().ordenarPorMarca());

	}

}
