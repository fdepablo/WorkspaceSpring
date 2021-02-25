package com.gestor;

import org.springframework.stereotype.Service;

import com.entidades.Historia;

@Service
public class GestorHistoria {
	
	public void formarHistoria (Historia h)
	{
		String miHistoria=" perdido en el territorio de los muñones se refugió en una cueva";
		h.setMensaje(h.getMensaje() + miHistoria);
	}

}
