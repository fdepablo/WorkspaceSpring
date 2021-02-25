package modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import modelo.entidades.Coche;

@Component
public class CocheDaoRowMapper implements RowMapper<Coche>{

	public Coche mapRow(ResultSet rs, int rowNum) throws SQLException {
		Coche c = new Coche();
		c.setId(rs.getInt("id"));
		c.setMatricula(rs.getString("matricula"));
		c.setMarca(rs.getString("marca"));
		c.setModelo(rs.getString("modelo"));
		c.setKm(rs.getDouble("kilometros"));
		return c;
	}

}
