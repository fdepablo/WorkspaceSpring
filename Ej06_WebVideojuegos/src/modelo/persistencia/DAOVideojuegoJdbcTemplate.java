package modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import modelo.entidades.Videojuego;

@Repository("daoVideojuego")
public class DAOVideojuegoJdbcTemplate implements DAOVideojuego {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DAOVideojuegoRowMapper videojuegoMapper;

	@Override
	public void insertar(Videojuego videojuego) {
		jdbcTemplate.execute("SET autocommit = 0");
		String query = "INSERT INTO Videojuegos (titulo, precio, empresa, plataforma, fechaPublic)"
					+ " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(query,
				videojuego.getTitulo(),
				videojuego.getPrecio(),
				videojuego.getEmpresa(),
				videojuego.getPlataforma(),
				videojuego.getFechaPublic());
		jdbcTemplate.execute("COMMIT");
	}

	@Override
	public void modificar(Videojuego videojuego) {
		jdbcTemplate.execute("SET autocommit = 0");
		String query = "UPDATE Videojuegos SET titulo = ?, precio = ?, empresa = ?, plataforma = ?, fechaPublic = ?"
				+ " WHERE id = ?";
		jdbcTemplate.update(query,
				videojuego.getTitulo(),
				videojuego.getPrecio(),
				videojuego.getEmpresa(),
				videojuego.getPlataforma(),
				videojuego.getFechaPublic(),
				videojuego.getId());
		jdbcTemplate.execute("COMMIT");
	}

	@Override
	public void borrar(Videojuego videojuego) {
		jdbcTemplate.execute("SET autocommit = 0");
		String query = "DELETE FROM Videojuegos WHERE id = ?";
		jdbcTemplate.update(query, videojuego.getId());
		jdbcTemplate.execute("COMMIT");
	}

	@Override
	public Videojuego buscar(Integer id) {
		String query = "SELECT sql_no_cache * FROM Videojuegos WHERE id = ?";
		Videojuego videojuego = jdbcTemplate.queryForObject(query, videojuegoMapper, id);
		return videojuego;
	}

	@Override
	public List<Videojuego> listarVideojuegos() {
		String query = "SELECT sql_no_cache * FROM Videojuegos";
		List<Videojuego> listaVideojuegos  = jdbcTemplate.query(query, videojuegoMapper);
		return listaVideojuegos;
	}
}
