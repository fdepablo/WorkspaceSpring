package com.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.Historia;
import com.gestor.GestorHistoria;
import com.gestor.GestorREST;


@RestController
public class ControladorHistoria {

	@Autowired
	private GestorREST gr;
	
	@Autowired
	private GestorHistoria gt;
	
	@RequestMapping (value="historia", method = RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Historia> obtenerHistoria ()
	{
		Historia h  =gr.getHistoria();
		
		gt.formarHistoria(h);
		
		return new ResponseEntity<Historia>(h, HttpStatus.OK);
	}
}
