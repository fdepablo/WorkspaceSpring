package entidades;

import java.util.LinkedList;

public class Tienda {
	
	private LinkedList <Procesador> procesadores;
	private LinkedList <DiscoDuro> discosDuros;
	private LinkedList <RAM> rams;
	public LinkedList<Procesador> getProcesadores() {
		return procesadores;
	}
	public void setProcesadores(LinkedList<Procesador> procesadores) {
		this.procesadores = procesadores;
	}
	public LinkedList<DiscoDuro> getDiscosDuros() {
		return discosDuros;
	}
	public void setDiscosDuros(LinkedList<DiscoDuro> discosDuros) {
		this.discosDuros = discosDuros;
	}
	public LinkedList<RAM> getRams() {
		return rams;
	}
	public void setRams(LinkedList<RAM> rams) {
		this.rams = rams;
	}
	
	
	
	

}
