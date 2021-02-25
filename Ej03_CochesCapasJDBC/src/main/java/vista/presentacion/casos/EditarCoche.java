package vista.presentacion.casos;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import modelo.entidades.Coche;
import vista.presentacion.MainCoches;

@Component
public class EditarCoche extends Casos{

	@Override
	public void ejecutar() {
		
		System.out.println(getGc().listar());
		System.out.println("Elige un coche para modificar:");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduce matricula, modelo, marca y kilometros:" );
		String matricula=sc.nextLine();
		String modelo = sc.nextLine();
		String marca = sc.nextLine();
		String km = sc.nextLine();
		
		//GestorCoche gc = MainCoches.context.getBean("gestorCoche", GestorCoche.class); 
		
		Coche coche = MainCoches.context.getBean("coche", Coche.class);
		coche.setId(i);
		coche.setMatricula(matricula);
		coche.setModelo(modelo);
		coche.setMarca(marca);
		coche.setKm(Double.parseDouble(km));
		int correcto = getGc().modificar(coche);
		if(correcto == 0) {
			System.out.println("Matricula incorrecta");
		}else if(correcto == -1) {
			System.out.println("Matricula repetida");
		}else {
			System.out.println("Coche modificado con exito");
		}
		
	}

}
