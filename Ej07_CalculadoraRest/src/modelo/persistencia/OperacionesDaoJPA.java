package modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import modelo.entidades.Operacion;

@Repository
public class OperacionesDaoJPA implements OperacionesDAO {

    /*
     * @PersistenceContext es un Autowired para Java EE. Autowired es para spring.
     * Cuando usamos javax.persistence.PersistenceContext tenemos que usar @PersistenceContext.
     * 
     * En conclusión la etiqueta @Autowired para Java EE es @PersistenceContext.
     */
    @PersistenceContext
    EntityManager em;
    
    @Override
    public void insertar(Operacion op) {
        this.em.persist(op);
    }

    @Override
    public void modificar(Operacion op) {
        this.em.merge(op);
    }

    @Override
    public void borrar(Operacion op) {
        this.em.remove(op);
    }

    @Override
    public List<Operacion> buscar(String operador) {
    	if (operador.equals("div")) operador = "/";
    	
    	Query query = this.em.createQuery("select op from Operacion op where op.operador=:operador");
    	
    	query.setParameter("operador", operador);
    	
    	return query.getResultList();
    }

    @Override
    public List<Operacion> listar() {
        // JPQL, no pongo la tabla sino la clase
        return this.em.createQuery("select op from Operacion op").getResultList();
    }
}
