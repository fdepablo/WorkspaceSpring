package herencia;

public class Tiburon extends Pez {

	@Override
	public void comer(Object o) {
		if(o instanceof Animal) {
			Animal a = (Animal)o;
			System.out.println("Soy el tiburon " + nombre +
					" y me voy a zampar al animal " + a.getNombre());
		}else {
			System.out.println("Puajjjjjjjjjj! no se que es eso pero "
					+ "no me gusta");
		}
	}
	
	
	
}
