package vista.presentacion.casos;

public class Menu {
	
	private String cadena;
	private Casos caso;
		
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public Casos getCaso() {
		return caso;
	}

	public void setCaso(Casos caso) {
		this.caso = caso;
	}

	public void printMenu() {
		System.out.println("Menu");
		System.out.println("1 Alta Coche");
		System.out.println("2 Borrar Coche");
		System.out.println("3 Editar Coche");
		System.out.println("4 Listar Coches");
		System.out.println("5 Ordenar por Modelo");
		System.out.println("6 Ordenar por Marca");		
		System.out.println("7 Salir");
	}

	@Override
	public String toString() {
		return cadena + "\n";
	}
	
	

}
