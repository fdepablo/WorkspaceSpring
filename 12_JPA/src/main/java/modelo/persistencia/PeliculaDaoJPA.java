package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import modelo.entidades.Pelicula;

@Repository
public class PeliculaDaoJPA implements PeliculaDAO {

	@PersistenceContext
	EntityManager em;
	
	public int insertar(Pelicula p) {
		em.persist(p);
		//una vez persistido se me actualiza el objeto con su id
		return p.getId();
	}

	public Pelicula modificar(Pelicula p) {
		//merge sincroninza la bd con el objeto
		//tambien puede servir para dar de alta
		return em.merge(p);
	}

	public int borrar(Pelicula p) {
		//JPA a diferencia de hibernate solo trabaja con objetos
		//dentro del contexto de persistencia
		//por lo que no vale con borrarlo directamente
		//primero tenemos que meter el objeto en el contexto
		//de persistencia de jpa y luego ya podemos borrarlo
		//ojo! el objeto pasado y el devuelto no son el mismo 
		//objeto
		Pelicula pAux = buscar(p.getId());
		em.remove(pAux);
		return pAux.getId();
	}
	
	public Pelicula buscar(int id) {
		return em.find(Pelicula.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Pelicula> listar() {
		return em.createQuery("select p from Pelicula p").getResultList();
	}

	
}

