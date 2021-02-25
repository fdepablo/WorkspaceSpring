package modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import modelo.entidades.Usuario;

@Repository("daoUsuario")
public class DAOUsuarioJdbcTemplate implements DAOUsuario {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DAOUsuarioRowMapper usuarioMapper;
	
	@Override
	public void insertar(Usuario usuario) {
		jdbcTemplate.execute("SET autocommit = 0");
		String query = "INSERT INTO Usuarios (nombre, password)"
					+ " VALUES (?, ?)";
		jdbcTemplate.update(query,
				usuario.getNombre(),
				usuario.getPassword());
		jdbcTemplate.execute("COMMIT");
	}

	@Override
	public void modificar(Usuario usuario) {
		jdbcTemplate.execute("SET autocommit = 0");
		String query = "UPDATE Usuarios SET nombre = ?, password = ?"
				+ " WHERE id = ?";
		jdbcTemplate.update(query,
				usuario.getNombre(),
				usuario.getPassword(),
				usuario.getId());
		jdbcTemplate.execute("COMMIT");
	}

	@Override
	public void borrar(Usuario usuario) {
		jdbcTemplate.execute("SET autocommit = 0");
		String query = "DELETE FROM Usuarios WHERE id = ?";
		jdbcTemplate.update(query, usuario.getId());
		jdbcTemplate.execute("COMMIT");
	}

	@Override
	public Usuario buscar(Integer id) {
		String query = "SELECT sql_no_cache * FROM Usuarios WHERE id = ?";
		Usuario usuario = jdbcTemplate.queryForObject(query, usuarioMapper, id);
		return usuario;
	}
	
	@Override
	public Usuario buscar(String nombre, String password) {
		String query = "SELECT sql_no_cache * FROM Usuarios WHERE nombre = ? AND password = ?";
		Usuario usuario = jdbcTemplate.queryForObject(query, usuarioMapper, nombre, password);
		return usuario;
	}

	@Override
	public List<Usuario> getListaUsuarios() {
		String query = "SELECT sql_no_cache * FROM Usuarios";
		List<Usuario> listaUsuarios  = jdbcTemplate.query(query, usuarioMapper);
		return listaUsuarios;
	}

}
