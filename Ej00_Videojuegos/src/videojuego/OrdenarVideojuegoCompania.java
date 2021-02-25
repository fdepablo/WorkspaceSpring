package videojuego;

import java.util.Comparator;

public class OrdenarVideojuegoCompania implements Comparator <Videojuego> {

	
	@Override
	public int compare(Videojuego o1, Videojuego o2) {
		return o1.getCompania().compareTo(o2.getCompania());
		
	}
	
}
