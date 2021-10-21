package ejemplo09;

public class MainBatallaJava {
	
	public static void main(String[] args) {
		//Con java debemos de instanciar todos los objetos, y ademas
		//hacemos dependiente esta clase con Espada y con arco
		Guerrero guerrero = new Guerrero();
		//guerrero.atacar();
		guerrero.setNombre("Aquiles");
		Arma espada = new Espada();
		espada.setTipo("larga");
		
		//inyectar la dependencia
		Arma arco = new Arco();
		arco.setTipo("largo");
		
		guerrero.setArma(arco);
		guerrero.atacar();
	}
}
