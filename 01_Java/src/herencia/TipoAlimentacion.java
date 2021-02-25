package herencia;

public enum TipoAlimentacion {
	CARNIVORO,HERBIVORO,OMNIVORO;
	
	private TipoAlimentacion() {
		
	}
	
	public void metodo() {
		System.out.println("Metodo");
	}
}
