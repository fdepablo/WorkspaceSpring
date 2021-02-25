package videojuego;

import java.util.Comparator;

public class OrdenarVideojuegoTitulo implements Comparator <Videojuego> {

	@Override
	public int compare(Videojuego o1, Videojuego o2) {
		return o1.getTitulo().compareTo(o2.getTitulo());
		
	}
	
	
	

}
