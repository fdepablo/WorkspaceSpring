package modelo.persistencia;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import modelo.entidades.Pelicula;

@Repository
public class DAOPelicula {
	//ojo aqui.
	//Si la referencia es de tipo List y ponemos @Autowire 
	//inyectaria un arrayList generico que no sería el que hemos
	//declarado en el beans.xml con id listaPeliculas. No funcionaria
	//ni siquiera si ponemos un @Qualifier para hacer la busqueda por id
	//ya que el ArrayList generico que inyecta tambien intentaria
	//una pelicula con ese nombre de @Qualifier (la verdad es que es una
	//cosa extraña..., spring inicializa dicho array por defecto
	//con un objeto del tipo de la lista...). Esto se puede solucionar 
	//poniendo la anotacion @Autowire pero la REFERENCIA 
	//DEBE de ser del tipo ArrayList (cambiar List por ArrayList)
	//La otra solución sería poner la etiqueta @Resource, que si
	//que localizaría el recurso bien, SIEMPRE Y CUANDO, la 
	//propiedad se llame IGUAL que el bean declarado en el beans.xml
	//Explicación:
	//https://stackoverflow.com/questions/3364283/autowiring-a-collection-via-the-constructor-with-spring
	//De todas maneras, casi que lo mejor es poner un new y fuera...
	@Resource
	private List<Pelicula> listaPeliculas;
	@Autowired
	private int numeroMaximoPeliculas;
	
	/**
	 * Metodo que inserta una pelicula a la lista
	 * @param p la pelicula a insertar
	 * @return true en caso correcto, false en caso de que el array
	 * este lleno
	 */
	public boolean insertar(Pelicula p) {
		if(listaPeliculas.size() < numeroMaximoPeliculas) {
			listaPeliculas.add(p);
			return true;
		}
		return false;
	}

	public List<Pelicula> listar(){
		return listaPeliculas;
	}
}
