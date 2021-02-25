package com.resttemplate.controlador.proxy;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.resttemplate.modelo.entidad.Persona;

@Service
public class ServicioPersonaProxy {

	//Este objeto sera el encargado de hacer las peticiones HTTP
	//Este objeto realizará el balanceo de carga, el objeto RestTemplate no
	//se conecta al eureka para hacer las peticiones, si no que al arrancar
	//esta aplicacion hace una peticion a eureka y se queda con los datos
	//(IP y puerto) de donde estan todos los servicios Rest. De hecho la
	//lista se recarga haciendo peticiones periodicas
	@Autowired
	private RestTemplate restTemplate;
	
	//Constante con la URL del servicio rest al que vamos a acceder
	//Ponemos el nombre del sercicio con el que se registro en eureka
	//En caso de que queramos hacer una peticion a un servidor rest normal en vez de a un eureka
	//debemos de poner aqui la url donde queramos acceder
	public static final String URL_PERSONAS = "http://springrestpersona/personas/";

	public List<Persona> listar(){
		//Hacemos una peticion GET a la url y decimos que nos parsee el json a la un array de personas
		//El metodo getForEntity hace la peticion a la URL y tambien le decimos a que clase me tiene que 
		//convertir el json resultante
		//Si en vez de a un servidor eureka hacemos una conexión a un rest normal, podemmos crear
		//el objeto rest en cada una de las peticiones que hagamos, ya que no necesitamos información
		//adicional
		ResponseEntity<Persona[]> response = restTemplate.getForEntity(URL_PERSONAS, Persona[].class);
		
		//Lo que tiene el body es un array de personas, porque el
		//ResponseEntity es un array de personas
		Persona[] arrayPersonas = response.getBody();
		
		//Convertimos el array de personas a una lista de personas
		List<Persona> lista = Arrays.asList(arrayPersonas); 
		
		return lista;
	}
	
	public Persona obtener(int id) {
		String personaResourceUrl = URL_PERSONAS + id;

		ResponseEntity<Persona> response = restTemplate.getForEntity(personaResourceUrl, Persona.class);
		//response.getStatusCode();
		
		//Esta vez el body solo tendra una persona, no una lista
		return response.getBody();
	}

	public Persona alta(Persona persona) {
		// Crear un objeto HttpEntity que sera el encargado de
		// rellenar en el body del mensaje Http la entidad que le digamos
		// en este caso, una persona
		HttpEntity<Persona> requestBody = new HttpEntity<>(persona);

		// Enviamos la peticion HTTP por POST con el metodo postForObject
		Persona pCreada = restTemplate.postForObject(URL_PERSONAS, requestBody, Persona.class);

		return pCreada;
	}
	
	public Persona modificar(Persona persona) {
		// Crear un objeto HttpEntity que sera el encargado de
		// rellenar en el body del mensaje Http la entidad que le digamos
		// en este caso, una persona
		HttpEntity<Persona> requestBody = new HttpEntity<>(persona);

		// Enviamos la peticion HTTP por PUT con el metodo exchange
		ResponseEntity<Persona> response = 
				restTemplate.exchange(URL_PERSONAS + persona.getId(), 
						HttpMethod.PUT, 
						requestBody, 
						Persona.class);
 
		return response.getBody();
	}
	
	public void borrar(int id) {		 
        // Send request with DELETE method.
        restTemplate.delete(URL_PERSONAS + id);
	}
	

}
