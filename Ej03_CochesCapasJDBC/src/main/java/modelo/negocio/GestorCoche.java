package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.entidades.Coche;
import modelo.persistencia.DaoCoches;

@Service
public class GestorCoche {
	
	@Autowired
	private DaoCoches daoCoches;
	
	public int insert(Coche c) {
		if(c.getMatricula().length() != 7) {
			return 0;
		}else if(daoCoches.hayCoche(c)) {
			return -1;
		}else {
			daoCoches.insertar(c);
			return 1;
		}
	}
	
	public int modificar(Coche c) {
		if(c.getMatricula().length() != 7) {
			return 0;
		}else if(daoCoches.hayCoche(c)) {
			return -1;
		}else {
			daoCoches.modificar(c);
			return 1;
		}
	}
	
	public void borrar(Coche c) {
		daoCoches.borrar(c);
	}
	
	public Coche buscar(int id) {
		return daoCoches.buscar(id);
	}
	
	public List<Coche> listar(){
		return daoCoches.listar();
	}

	public List<Coche> ordenarMarca(){
		return daoCoches.ordenarMarca();
	}
	
	public List<Coche> ordenarModelo(){
		return daoCoches.ordenarModelo();
	}
}
