package com.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.modelo.entidades.Pelicula;

@Repository
public class DaoPeliculaMySql implements DaoPelicula {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PeliculaDaoRowMapper rowMapper;

	@Override
	public void insertar(Pelicula p) {
		String query= "insert into peliculas (TITULO,GENERO,YEAR) values (?,?,?)";
		jdbcTemplate.update(query,
				p.getTitulo(),
				p.getGenero(),
				p.getYear());
	}

	@Override
	public void modificar(Pelicula p) {
		String query= "update peliculas set TITULO=?,GENERO=?,YEAR=? where id=? ";
		jdbcTemplate.update(query,
				p.getTitulo(),
				p.getGenero(),
				p.getYear(),
				p.getId());
	}

	@Override
	public void borrar(Pelicula p) {
		String query = "delete from peliculas where id =?";
		jdbcTemplate.update(query,p.getId());

	}

	@Override
	public Pelicula buscar(int id) {
		String query = "select * from peliculas where id =?";
		//queryForObject espera un unico objeto, con lo cual solo vale
		//por busquedas que devuelvan un solo objeto
		Pelicula p = jdbcTemplate.queryForObject(query, rowMapper, id);
		return p;
	}

	@Override
	public List<Pelicula> listar() {
		String query = "select * from peliculas";
		List<Pelicula> listaPeliculas = jdbcTemplate.query(query, rowMapper);
		return listaPeliculas;
	}

}
