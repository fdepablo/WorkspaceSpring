package modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import modelo.entidades.Usuario;

@Component
public class DAOUsuarioRowMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt("id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setPassword(rs.getString("password"));
		return usuario;
	}

}
