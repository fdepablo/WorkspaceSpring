package vista.presentacion.casos;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class BorrarCoche extends Casos {

	@Override
	public void ejecutar() {
		System.out.println(getGc().listar());
		System.out.println("Elige un coche para borrar:");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		sc.nextLine();
		getGc().borrar(getGc().buscar(i));
	}

}
