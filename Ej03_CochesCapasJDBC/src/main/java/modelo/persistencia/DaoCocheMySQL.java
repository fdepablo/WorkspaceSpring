package modelo.persistencia;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import modelo.entidades.Coche;
import modelo.negocio.OrdenarCocheMarca;
import modelo.negocio.OrdenarCocheModelo;

@Repository
public class DaoCocheMySQL implements DaoCoches {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private CocheDaoRowMapper rowMapper;

	public void insertar(Coche c) {
		String query = "insert into coches (MATRICULA, MARCA, MODELO, KILOMETROS) values (?,?,?, ?)";
		jdbcTemplate.update(query, c.getMatricula(), c.getMarca(), c.getModelo(), c.getKm());
		
	}

	public void modificar(Coche c) {
		String query = "update coches set MATRICULA=?, MARCA=?, MODELO=?, KILOMETROS=?  where id=?";
		jdbcTemplate.update(query, c.getMatricula(), c.getMarca(), c.getModelo(), c.getKm(), c.getId());
		
	}

	public void borrar(Coche c) {
		String query = "delete from coches where id=?";
		jdbcTemplate.update(query, c.getId());
		
	}

	public Coche buscar(int id) {
		String query = "select * from coches where id=?";
		///queryForObject espera un unico objeto, con lo cual solo vale para busquedas que devuelvan un solo objeto
		Coche c = jdbcTemplate.queryForObject(query, rowMapper, id);
		return c;
	}

	public List<Coche> listar() {
		String query = "select * from coches";
		List<Coche> lc =  jdbcTemplate.query(query,rowMapper);
		return lc;
	}

	@Override
	public boolean hayCoche(Coche c) {
		boolean existe = true;
		String query = "select * from coches where matricula=?";
		///queryForObject espera un unico objeto, con lo cual solo vale para busquedas que devuelvan un solo objeto
		try {
			Coche coche = jdbcTemplate.queryForObject(query, rowMapper, c.getMatricula());
		}catch(Exception e) {
			existe = false;
		}
		return existe;
	}

	@Override
	public List<Coche> ordenarMarca() {
		String query = "select * from coches";
		List<Coche> lc =  jdbcTemplate.query(query,rowMapper);
		Collections.sort(lc, new OrdenarCocheMarca());
		return lc;
	}

	@Override
	public List<Coche> ordenarModelo() {
		String query = "select * from coches";
		List<Coche> lc =  jdbcTemplate.query(query,rowMapper);
		Collections.sort(lc, new OrdenarCocheModelo());
		return lc;
	}
	

}
