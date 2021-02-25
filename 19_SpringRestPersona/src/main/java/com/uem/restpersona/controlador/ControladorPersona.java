package com.uem.restpersona.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uem.restpersona.modelo.entidad.Persona;
import com.uem.restpersona.modelo.negocio.GestorPersona;
import com.uem.restpersona.modelo.persistencia.DaoPersona;


//Va a dar de alta un objeto de tipo Controlador persona con capacidad
//de recibir peticiones http

//Dentro de un MVC esta capa se encargaría de recibir la informacion de los
//clientes, traducirla y mandarsela a la capa de negocio para consultar
//o precesar la peticion
@RestController
public class ControladorPersona {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private GestorPersona gp;
	
	//ResponseEntity nos permite devolver a parte del objeto, tambien 
	//el codigo de respuesta
	@GetMapping("personas")
	public ResponseEntity<List<Persona>> listar(){
		System.out.println("Entrando por get (listar)");
		List<Persona> lista = gp.listar();
		ResponseEntity<List<Persona>> re = 
				new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
		return re;
	}
	
	//Cuando tenemos parte de la url que es variable, normalmente un id
	//debemos de poner esa parte entre corchetes, y para recuperar
	//dicho valor dentro de los argumentos debemos de usar la anotacion
	//@PathVariable con el nombre de la variable
	@GetMapping("personas/{id}")//personas/1
	public ResponseEntity<Persona> obtener(@PathVariable("id") int id){//1
		System.out.println("Entrando por get (obtener)");
		Persona p = gp.obtener(id);
				
		HttpStatus codigoRespuesta = null;
		
		if(p != null) {
			String serverPort = environment.getProperty("local.server.port");
			p.setNombre(serverPort + ":" + p.getNombre());
			codigoRespuesta = HttpStatus.OK;
		}else {
			codigoRespuesta = HttpStatus.NOT_FOUND;
		}
		
		ResponseEntity<Persona> re = 
				new ResponseEntity<Persona>(p, codigoRespuesta);
		return re;
	}
	
	//Con @RequestBody le decimos a spring que el json que venga en el body
	//de la request http del cliente lo convierta automaticamente a un 
	//objeto de tipo persona
	@PostMapping("personas")
	public ResponseEntity<Persona> alta(@RequestBody Persona persona){
		System.out.println("Entrando por post");
		Persona pAlta = gp.alta(persona);
		HttpStatus codigoRespuesta = null;
		if(pAlta != null) {
			codigoRespuesta = HttpStatus.CREATED;
		}else {
			codigoRespuesta = HttpStatus.BAD_REQUEST;
		}
		
		ResponseEntity<Persona> re = 
				new ResponseEntity<Persona>(pAlta, codigoRespuesta);
		return re;
	}
	
	@PutMapping("personas/{id}")
	public ResponseEntity<Persona> modificar(
					@RequestBody Persona persona,
					@PathVariable("id") int id){
		System.out.println("Entrando por put");
		persona.setId(id);
		
		Persona pModificado = gp.modificar(persona);
		HttpStatus codigoRespuesta = null;
		if(pModificado != null) {
			codigoRespuesta = HttpStatus.OK;
		}else {
			codigoRespuesta = HttpStatus.BAD_REQUEST;
		}
		
		ResponseEntity<Persona> re = 
				new ResponseEntity<Persona>(pModificado, codigoRespuesta);
		return re;
	}
	
	@DeleteMapping("personas/{id}")
	public ResponseEntity<Integer> borrar(@PathVariable("id") int id){
		System.out.println("Entrando por delete");
		boolean borrado = gp.borrar(id);
		HttpStatus codigoRespuesta = null;
		if(borrado) {
			codigoRespuesta = HttpStatus.OK;
		}else {
			codigoRespuesta = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<Integer>(id,codigoRespuesta);
	}
}



