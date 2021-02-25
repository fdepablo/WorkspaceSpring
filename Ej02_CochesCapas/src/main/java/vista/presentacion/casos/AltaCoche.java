package vista.presentacion.casos;

import java.util.Scanner;

import modelo.entidades.Coche;
//import modelo.negocio.GestorCoche;
import vista.presentacion.MainCoche;

public class AltaCoche extends Casos {

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce matricula, modelo, marca y kilometros:" );
		String matricula=sc.nextLine();
		String modelo = sc.nextLine();
		String marca = sc.nextLine();
		String km = sc.nextLine();
		
		Coche coche = MainCoche.context.getBean("coche", Coche.class);
		coche.setMatricula(matricula);
		coche.setModelo(modelo);
		coche.setMarca(marca);
		coche.setKm(Double.parseDouble(km));
		int correcto = getGc().altaCoche(coche);
		if(correcto == 0) {
			System.out.println("Matricula incorrecta");
		}else if(correcto == -1) {
			System.out.println("Matricula repetida");
		}else {
			System.out.println("Coche dado de alta");
		}
	}


}
