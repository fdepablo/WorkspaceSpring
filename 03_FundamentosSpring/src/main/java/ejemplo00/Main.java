package ejemplo00;

public class Main {
	public static void main(String[] args) throws Exception, IllegalAccessException, ClassNotFoundException {
		/*
		String opcion = args[0];
		Imprimible f = new FactoriaImprimibles().crear(opcion);
		f.imprimir("ola ke ase");*/
		//ejemplo0.ImprimirPantalla
		Imprimible f = (Imprimible) 
				Class.forName(args[0]).newInstance();
		f.imprimir("ola ke ase");
	}
}
