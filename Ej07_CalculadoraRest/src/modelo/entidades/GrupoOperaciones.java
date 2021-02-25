package modelo.entidades;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GrupoOperaciones {
	
	private List<Operacion> listaOperaciones;

	@XmlElement(name="operacion")
	public List<Operacion> getListaOperaciones() {
		return listaOperaciones;
	}

	public void setListaOperaciones(List<Operacion> listaOperaciones) {
		this.listaOperaciones = listaOperaciones;
	}
	
	
}
