package vista.presentacion.casos;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class BuscarCoche extends Casos{

	@Override
	public void ejecutar() {
		System.out.println(getGc().listar());
		System.out.println("Elige un coche para buscar:");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		sc.nextLine();
		System.out.println(getGc().buscar(i));
		
	}

}
