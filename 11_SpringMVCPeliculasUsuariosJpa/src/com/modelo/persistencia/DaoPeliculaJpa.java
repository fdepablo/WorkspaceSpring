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
		em.persist(p);
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
		Pelicula p = buscar(id);
		em.remove(p);
		return p.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pelicula> listar() {
		return em.createQuery("select p from Pelicula p").getResultList();
	}

}
