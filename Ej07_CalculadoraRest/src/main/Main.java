package main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cfg.Configuracion;
import modelo.entidades.Operacion;
import modelo.gestion.GestorOperaciones;

public class Main {
	
	private static ApplicationContext context;
	
	static {
		context = new AnnotationConfigApplicationContext(Configuracion.class);
	}

	public static void main(String[] args) {
		System.out.println("Inicializando BBDD...");
		
		GestorOperaciones gop = context.getBean(GestorOperaciones.class);
		
		List<Operacion> listaOperaciones = gop.buscar("+");
		
		for (Operacion operacion : listaOperaciones) {
			System.out.println(operacion.toString());
		}
	}

}
