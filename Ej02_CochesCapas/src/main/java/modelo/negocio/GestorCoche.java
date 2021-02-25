package modelo.negocio;

import java.util.Collections;
import java.util.List;

import modelo.entidades.Coche;
import modelo.persistencia.DaoCoche;

public class GestorCoche {

	private DaoCoche daoCoche;
	
	/**
	 * @return 0 si la matricula no tiene 7 caracteres
	 * -1 ya esta repetida la matricula
	 * 1 todo correcto
	 * */
	public int altaCoche(Coche c) {
		if(c.getMatricula().length() != 7) {
			return 0;
		}else if(daoCoche.hayCoche(c)){
			return -1;
		}else {
			daoCoche.altaCoche(c);
			return 1;
		}
	}
	
	public List<Coche> ordenarPorMarca(){
		List<Coche> listaOrdenada = daoCoche.getListaCoches();
		Collections.sort(listaOrdenada, new OrdenarCocheMarca());
		return listaOrdenada;
	}
	
	public List<Coche> ordenarPorModelo(){
		List<Coche> listaOrdenada = daoCoche.getListaCoches();
		Collections.sort(listaOrdenada, new OrdenarCocheModelo());
		return listaOrdenada;
	}
	
	public List<Coche> listar(){
		return daoCoche.listarCoches();
	}

	public DaoCoche getDaoCoche() {
		return daoCoche;
	}

	public void setDaoCoche(DaoCoche daoCoche) {
		this.daoCoche = daoCoche;
	}
	
	
}
