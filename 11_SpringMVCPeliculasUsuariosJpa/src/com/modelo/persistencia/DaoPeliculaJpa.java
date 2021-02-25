package com.modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.modelo.entidades.Pelicula;


@Repository
public class DaoPeliculaJpa implements DaoPelicula{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int insertar(Pelicula p) {
		System.out.println(p.getId());
		em.persist(p);
		System.out.println(p.getId());
		return p.getId();
	}

	@Override
	public Pelicula modificar(Pelicula p) {
		//se encarga de sincronizar la bd con el objeto
		Pelicula p2 = em.merge(p);
		return p2;
	}

	@Override
	public Pelicula buscar(int id) {
		Pelicula p = em.find(Pelicula.class, id);
		return p;
	}

	@Override
	public int borrar(int id) {
		//con hiberante puro podemos borrar directamente el objeto pasado a la base de datos
		//pero jpa solo trabaja con objetos que que esten dentro de contexto jpa
		//por lo que tenemos que meter el objeto que queremos borrar primero en la cache
		
		Pelicula p = buscar(id);
		em.remove(p);
		return p.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pelicula> listar() {
		//para buscar una lista de peliculas tenemos que utilizar un lenguaje
		//que se llama JPQL que es una mezcla de POO y SQL
		return em.createQuery("select p from Pelicula p").getResultList();
	}

}
