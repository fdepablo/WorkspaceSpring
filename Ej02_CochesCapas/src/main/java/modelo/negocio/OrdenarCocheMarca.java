package modelo.negocio;

import java.util.Comparator;

import modelo.entidades.Coche;

public class OrdenarCocheMarca implements Comparator<Coche> {

	@Override
	public int compare(Coche o1, Coche o2) {
		// TODO Auto-generated method stub
		return o1.getMarca().compareTo(o2.getMarca());
	}

}
