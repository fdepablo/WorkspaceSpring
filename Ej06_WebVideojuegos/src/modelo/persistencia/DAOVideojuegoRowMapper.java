package modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import modelo.entidades.Videojuego;

@Component
public class DAOVideojuegoRowMapper implements RowMapper<Videojuego> {

	@Override
	public Videojuego mapRow(ResultSet rs, int rowNum) throws SQLException {
		Videojuego videojuego = new Videojuego();
		videojuego.setId(rs.getInt("id"));
		videojuego.setTitulo(rs.getString("titulo"));
		videojuego.setPrecio(rs.getDouble("precio"));
		videojuego.setEmpresa(rs.getString("empresa"));
		videojuego.setPlataforma(rs.getString("plataforma"));
		videojuego.setFechaPublic(rs.getDate("fechaPublic"));
		return videojuego;
	}

}
