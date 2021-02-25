package com.uem.restpersona.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uem.restpersona.modelo.entidad.Persona;
import com.uem.restpersona.modelo.persistencia.DaoPersona;

@Service
public class GestorPersona {

	//En esta parte vamos a crear un servicio rest que proporcione
	//un CRUD basico de personas a nuestros posibles clientes
	//(app android, app iOS, app java)
	@Autowired
	private DaoPersona daoPersona;
	
	public List<Persona> listar(){
		//aqui podria poner toda la  logica de negocio de mi app
		//ejempolos:
		//1- puede el usuario consultar las personas
		//2- Tengo que mostrar todas las personas o solo algunas?
		List<Persona> lista = daoPersona.findAll();
		return lista;
	}
	
	/**
	 * Metodo que busca en la bbdd un objeto persona dado un id
	 * 
	 * @param id representa el id a buscar
	 * @return el objeto persona en caso de que exista en la bbdd y null
	 * en caso de que no
	 */
	public Persona obtener(int id) {
		Optional<Persona> opt = daoPersona.findById(id);
		//si no encuentra el objeto el optional estaria vacio
		if(opt.isPresent()) {
			return opt.get();//findById() devuelve un optional
		}else {
			return null;
		}		
	}
	
	/**
	 * Metodo que da de alta una persona en la bbdd, no debemos pasarle
	 * id
	 * @param persona el objeto que vamos a dar de alta en la bbdd
	 * @return la persona dada de alta en la bbdd o null en caso de que 
	 * el nombre de la persona tenga menos de 3 caracteres
	 */
	public Persona alta(Persona persona) {
		//podriamos poner toda la logica de la aplicacion
		//En caso de que tengamos una regla de negocio de que el nombre
		//tenga que tener al menos 3 caracteres, la podriamos aqui
		if(persona.getNombre().length() < 3) {
			return null;
		}

		Persona p = daoPersona.save(persona);
		return p;
	}
	
	public Persona modificar(Persona persona) {
		if(persona.getNombre().length() < 3) {
			return null;
		}
		//si ejecutamos el save con un id, modificamos dicho registro
		//si no le pasamos id, como en el caso de arriba, lo damos de alta
		Persona p = daoPersona.save(persona);
		return p;
	}
	
	/**
	 * Metodo que borra una persona a partir de una id de la bbdd
	 * @param id de la persona a borrar
	 * @return true en caso que la persona exista en la bbdd false
	 * en caso de que no exista
	 */
	public boolean borrar(int id) {
		if(daoPersona.findById(id).isPresent()) {
			daoPersona.deleteById(id);
			return true;
		}else {
			return false;
		}
		
	}
}
