package herencia;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Animal animal = new Tiburon();
		Tiburon tiburon = (Tiburon)animal;
		tiburon.setNombre("Tiburcio");
		tiburon.setNumeroAletas(4);
		tiburon.setEdad(5);
		tiburon.setId(1);
		
		Trucha trucha = new Trucha();
		trucha.setNombre("Robustiana");
		trucha.setNumeroAletas(2);
		trucha.setEdad(1);
		trucha.setId(2);
		
		Oso oso = new Oso();
		oso.setNombre("Yogui");
		oso.setEdad(8);
		oso.setId(3);
		
		List<Animal> listaAnimales = new ArrayList<>();
		listaAnimales.add(tiburon);
		listaAnimales.add(trucha);
		listaAnimales.add(oso);
		
		Animal comida = new Oso();
		comida.setNombre("Plactonidus");
		
		for(Animal a : listaAnimales) {
			a.comer(comida);
		}

	}

}
