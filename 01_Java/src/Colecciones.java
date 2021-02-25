import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Colecciones {

	public static void main(String[] args) {
		List<String> arrayStrings = new ArrayList<>();
		arrayStrings.add("FElix");
		arrayStrings.add("Ana");
		arrayStrings.add("Marcos");
		
		System.out.println(arrayStrings.get(0));
		
		ArrayList<String> lista1 = new ArrayList<>();
		Vector<String> lista2 = new Vector<>();
		LinkedList<String> lista3 = new LinkedList<>();
		
		recorrerArray(lista1);
		recorrerVector(lista2);
		
		recorrer(lista1);
		recorrer(lista3);
		recorrer(lista2);
		
		Map<Integer, String> mapaPersonas = new HashMap<>();
		mapaPersonas.put("Pepe".hashCode(), "Pepe");
		mapaPersonas.put(12345678, "Bud spencer");
		mapaPersonas.put(1111, "Luis Ramon");
		
		System.out.println(mapaPersonas.get(1));
		
		List<Persona> listaPersonas = new ArrayList<>();
		Persona p = new Persona();
		listaPersonas.add(p);
		listaPersonas.get(0).setNombre("Pedro");
		p.setEdad(23);
		p.setApellidos("El cruel");
		p.setPeso(89);
		
		p = new Persona();
		p.setEdad(45);
		p.setApellidos("Gomez");
		p.setPeso(66);
		p.setNombre("Ana");
		
		listaPersonas.add(p);
		
		Persona p2 = new Persona();
		p2.setNombre("Pedro");
		p2.setEdad(23);
		
		System.out.println(listaPersonas.contains(p2));
		
		for(Persona pAux : listaPersonas) {
			System.out.println(pAux);
		}
		
		//Ordenaciones
		Collections.sort(arrayStrings);
		Collections.sort(listaPersonas);
		
		for(Persona pAux : listaPersonas) {
			System.out.println(pAux);
		}
		
		
		Collections.sort(listaPersonas, new CompararPorNombre());
	}
	
	public static void recorrer(List<String> lista) {
		for(String s : lista) {
			//todo....
		}
	}
	
	public static void recorrerArray(ArrayList<String> lista) {
		for(String s : lista) {
			//todo....
		}
	}
	
	public static void recorrerVector(Vector<String> lista) {
		for(String s : lista) {
			//todo....
		}
	}
	
	public static void recorrerLinked(LinkedList<String> lista) {
		for(String s : lista) {
			//todo....
		}
	}

}
