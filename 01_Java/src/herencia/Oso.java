package herencia;

public class Oso extends Animal {

	@Override
	public void comer(Object o) {
		if(o instanceof Pez) {
			Pez a = (Pez)o;
			System.out.println("Soy el oso " + nombre +
					" y me voy a zampar al pez " + a.getNombre());
		}else {
			System.out.println("Puajjjjjjjjjj! no se que es eso pero "
					+ "no me gusta");
		}
	}

}
