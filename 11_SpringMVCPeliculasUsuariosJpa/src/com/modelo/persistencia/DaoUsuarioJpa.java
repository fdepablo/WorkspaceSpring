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
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		return em.createQuery("select u from Usuario u").getResultList();
	
	}

	@Override
	public Usuario obtenerUsuarioPorUsername(String username) {
		String sQuery = "select u from Usuario u where u.nombre=:nombre";
		Query query = em.createQuery(sQuery);
		query.setParameter("nombre", username);
		Usuario usuario = (Usuario)query.getSingleResult();
		return usuario;
	}

	
}








