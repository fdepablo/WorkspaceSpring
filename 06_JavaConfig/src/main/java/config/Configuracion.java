package config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import modelo.entidades.Director;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPeliculas;
import modelo.persistencia.DAOPelicula;

//Esta anotacion decimos que esta clase va a llevar la 
//configuración de nuestro proyecto de spring
//como si fuera un bean.xml
@Configuration
public class Configuracion {
	
	//Con esta anotación damos de alta un bean en el contexto de spring
	@Bean("directorBean")
	@Scope("prototype")
	public Director getDirector() {//por defecto el nombre del bean es el del metodo
		Director director = new Director();
		return director;
	}
	
	//Aqui siempre se intentará hacer una inyección a los argumentos
	//de entrada de algun bean que exista en el contenedor de spring
	//es decir, un autowire.
	//Si no pondemos @Qualifer, el autowire sera por tipo, en caso
	//contrario el autowire sera por nombre o id
	@Bean("pelicula")
	@Scope("prototype")
	public Pelicula pelicula(@Qualifier("directorBean") Director director){
		Pelicula pelicula = new Pelicula();
		//podemos hacerlo así
		//pelicula.setDirector(getDirector());
		pelicula.setDirector(director);
		return pelicula;
	}
	
	@Bean("listaPeliculas")
	public List<Pelicula> listaPeliculas(){
		List<Pelicula> arrayPeliculas = new ArrayList<>();
		return arrayPeliculas;
	}
	
	//Si aqui no ponemos @Qualifier, inyectará un ArrayList
	//(hara un autowire por tipo)
	//que no sera el arrayList de la lista de peliculas, sera
	//otro objeto ArrayList. Además, por defecto, tambien
	//meterá un bean pelicula en el array (se puede ver en la
	//documentacion de la etiqueta @Autowire)
	@Bean("daoPelicula")
	public DAOPelicula getDaoPelicula(@Qualifier("listaPeliculas") 
										List<Pelicula> listaPeliculas) {
		DAOPelicula dao = new DAOPelicula();
		dao.setListaPelicula(listaPeliculas);
		dao.setNumeroMaximoPeliculas(2);
		System.out.println(listaPeliculas.size());
		return dao;
	}
	
	@Bean("gestorPeliculas")
	public GestorPeliculas getGestorPeliculas(DAOPelicula dao) {
		GestorPeliculas gp = new GestorPeliculas();
		gp.setDaoPelicula(dao);
		return gp;
	}
}






