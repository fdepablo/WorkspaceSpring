package com.modelo.negocio;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelo.entidades.Usuario;
import com.modelo.persistencia.DaoUsuario;

@Service
public class GestorUsuario {
	
	@Autowired
	private DaoUsuario daoUsuario;
	
	public boolean validarUsuario(String username, String password) {
		//comprobaciones del tipo nombre no esta 
		//vacio, etc
		Usuario usuario = daoUsuario.obtenerUsuarioPorUsername(username);
		
		//Simulamos que el usuario no esta registrado un 50% de la veces
		//realmente habria que comparar por el password
		Random random = new Random();
		int numero = random.nextInt(10);//numero entre 0 y n(excluido)
		System.out.println("aleatorio: " + numero);
		if(numero < 5)
			return false;
		else
			return true;
	}
}
