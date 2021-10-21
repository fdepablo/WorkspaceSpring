package ejemplo00;

//Spring hace factoria de creacion de objetos por nostros.

//Este es un pequeño ejeplo de creacion de una clase que implemente el patron
//de diseño factoria. Este patron lo que busca es delegar toda la creacion
//de objeto en una sola clase, para reducir el acomplamiento de codigo del resto
//de las clases
public class FactoriaImprimibles {
	public Imprimible crear(String imprimible) {
		switch (imprimible) {
		case "0":
			return new ImprimirFichero();
		case "1":
			return new ImprimirPantalla();
		}
		return null;
	}
}
