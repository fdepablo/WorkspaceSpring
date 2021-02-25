package vista.presentacion.casos;

//import modelo.negocio.GestorCoche;

public class ListarCoches extends Casos {

	@Override
	public void ejecutar() {
		System.out.println(getGc().listar());

	}

}
