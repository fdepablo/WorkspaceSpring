package es.curso.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidad.Pelicula;

@Repository
//<bean id="daoPelicula" class="modelo.persistencia.DaoPelicula"/>
public class DaoPelicula {
	//En este caso, estos objetos no podemos darlos de alta en el contexto
	//de Spring mediante anotaciones, ya que no podemos anotar la clase
	//ArrayList, ni la clase Integer
	//Estos objetos los dare de alta mediante XML
	@Autowired
	//Por defecto Spring inyectará un lista con un elemento.
	//Para elegir la lista que queremos podemos usar el @Qualifier
	@Qualifier("listaPeliculas")
	private List<Pelicula> listaPeliculas;
	@Autowired
	private Integer numeroMaximoPeliculas;
	
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
