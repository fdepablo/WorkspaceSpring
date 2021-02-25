package modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import modelo.entidades.Pelicula;

@Repository
public class DaoPeliculaJdbcTemplate implements DaoPelicula {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DaoPeliculaRowMapper peliculaRowMapper;

	@Override
	public int insertar(Pelicula p) {
		String query = "insert into peliculas (TITULO, DIRECTOR, GENERO, YEAR) values (?, ?, ?, ?)";
		
		return jdbcTemplate.update(query,
			p.getTitulo(),
			p.getDirector(),
			p.getGenero(),
			p.getYear()
		);
		
	}

	@Override
	public int modificar(Pelicula p) {
		String query = "update peliculas SET TITULO=?, DIRECTOR=?, GENERO=?, YEAR=? where id=?";
		
		return jdbcTemplate.update(query,
			p.getTitulo(),
			p.getDirector(),
			p.getGenero(),
			p.getYear(),
			p.getId()
		);
	}

	@Override
	public int borrar(int id) {
		String query = "delete from peliculas where id=?";
		return jdbcTemplate.update(query, id);
	}

	@Override
	public Pelicula buscar(int id) {
		String query = "select * from peliculas where id=?";
		/*BeanPropertyRowMapper<Pelicula> bean = 
				new BeanPropertyRowMapper<>();*/
		//esto espera solo 1 y SOLO 1 pelicula, si da 0 da error
		return jdbcTemplate.queryForObject
				(query, peliculaRowMapper,id);
	}

	@Override
	public List<Pelicula> listar() {
		String query = "select * from peliculas";
		return jdbcTemplate.query(query, peliculaRowMapper);
	}
	
	public void crearTablaPeliculas() {
		jdbcTemplate.execute("CREATE TABLE peliculas (" + 
				"id int NOT NULL AUTO_INCREMENT," + 
				"titulo varchar(255) NOT NULL," + 
				"director varchar(255)," + 
				"genero varchar(255)," + 
				"year int," + 
				"PRIMARY KEY (id)" + 
				"); ");
	}

}
