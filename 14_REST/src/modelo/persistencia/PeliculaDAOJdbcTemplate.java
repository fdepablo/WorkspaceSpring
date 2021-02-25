package modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import modelo.entidades.Pelicula;

@Repository
public class PeliculaDAOJdbcTemplate implements PeliculaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PeliculaDAORowMapper peliculaRowMapper;

	@Override
	public void insertar(Pelicula p) {
		String query = "insert into peliculas (TITULO, DIRECTOR, GENERO, YEAR) values (?, ?, ?, ?)";
		
		jdbcTemplate.update(query,
			p.getTitulo(),
			p.getDirector(),
			p.getGenero(),
			p.getYear()
		);
		
	}

	@Override
	public void modificar(Pelicula p) {
		String query = "update peliculas SET TITULO=?, DIRECTOR=?, GENERO=?, YEAR=? where id=?";
		
		jdbcTemplate.update(query,
			p.getTitulo(),
			p.getDirector(),
			p.getGenero(),
			p.getYear(),
			p.getId()
		);
	}

	@Override
	public void borrar(Pelicula p) {
		String query = "delete from peliculas where id=?";
		jdbcTemplate.update(query, p.getId());
	}

	@Override
	public Pelicula buscar(int id) {
		String query = "select * from peliculas where id=?";
		/*BeanPropertyRowMapper<Pelicula> bean = 
				new BeanPropertyRowMapper<>();*/
		return jdbcTemplate.queryForObject
				(query, peliculaRowMapper,id);
	}

	@Override
	public List<Pelicula> listar() {
		String query = "select * from peliculas";
		return jdbcTemplate.query(query, peliculaRowMapper);
	}

}
