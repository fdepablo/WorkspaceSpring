package es.curso.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Pelicula;

@Repository
public class DaoPeliculaJdbcTemplate implements DaoPelicula {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DaoPeliculaRowMapper peliculaRowMapper;

	//JdbcTemplate trabaja con consultas parametrizadas por defecto, además de que es la manera
	//recomendable
	/**
	 * 
	 * @param la pelicula que queremos dar de alta
	 * @return el id con que se dio de alta en nuestra BBDD
	 */
	@Override
	public int insertar(Pelicula p) {
		String query = "insert into peliculas (TITULO, DIRECTOR, GENERO, YEAR) values (?, ?, ?, ?)";
		
		//Le pasamos la query y los valores de las "?" en orden
		int id = jdbcTemplate.update(query,
				p.getTitulo(),
				p.getDirector(),
				p.getGenero(),
				p.getYear()
			);
		
		return id;		
	}

	/**
	 * 
	 * @param la pelicula que queremos dar de alta
	 * @return el id con que se dio de alta en nuestra BBDD
	 */
	@Override
	public int modificar(Pelicula p) {
		String query = "update peliculas SET TITULO=?, DIRECTOR=?, GENERO=?, YEAR=? where id=?";
		
		//Al final el update sive para modificar la BBDD
		int id = jdbcTemplate.update(query,
				p.getTitulo(),
				p.getDirector(),
				p.getGenero(),
				p.getYear(),
				p.getId()
			);
		
		return id;
	}

	@Override
	public int borrar(int id) {
		String query = "delete from peliculas where id=?";
		return jdbcTemplate.update(query, id);
	}

	@Override
	public Pelicula buscar(int id) {
		String query = "select * from peliculas where id=?";

		//Este metodo espera un unico regitro como resultado
		//Si devuelve más o menos, arrojaria una excepcion
		
		//Al metodo le pasamos ademas de la query y el id que estamos
		//buscando, le pasamos un objeto de tipo RowMapper
		//La funcion de este objeto que hemos creado es que por cada registro
		//que nos devuelva, se ejecutara el metodo mapRow() de la clase
		//DaoPeliculaRowMapper
		
		Pelicula pelicula = null;
		
		try {
			pelicula = jdbcTemplate.queryForObject(query, peliculaRowMapper,id);
		}catch(EmptyResultDataAccessException e) {
			//Este tipo de excepciones ocurren cuando esperamos un objeto y nos devuelve
			//0.
			System.out.println("EmptyResultDataAccessException: " + e.getMessage());
		}
		
		return pelicula;
		
	}

	@Override
	public List<Pelicula> listar() {
		String query = "select * from peliculas";
		//Como son varios elementos ejecutamos el metodo "query"
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
