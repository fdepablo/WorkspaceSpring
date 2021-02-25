package com.modelo.persistencia;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.modelo.entidades.Usuario;

@Repository
public class DaoUsuarioJpa implements DaoUsuario{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Usuario> listar() {
		return em.createQuery("select u from Usuario u").getResultList();
	
	}

	@Override
	public boolean validarUsuario(Usuario u) {
		String sQuery = "select u from Usuario u where u.nombre=:nombre"
				+ " and u.password =:pass";
		Query query = em.createQuery(sQuery);
		query.setParameter("nombre", u.getNombre());
		query.setParameter("pass", u.getPassword());
		List<Usuario> lista = query.getResultList();
		//return !lista.isEmpty();
		Random random = new Random();
		int numero = random.nextInt(10);//numero entre 0 y n(excluido)
		System.out.println("aleatorio: " + numero);
		if(numero < 5)
			return false;
		else
			return true;
	}

	
}








