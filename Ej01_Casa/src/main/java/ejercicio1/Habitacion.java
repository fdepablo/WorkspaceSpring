package ejercicio1;

public class Habitacion {
	private TipoHabitacion tipo;
	private int area;
	private boolean tieneVentana;
	
	
	public TipoHabitacion getTipo() {
		return tipo;
	}
	public void setTipo(TipoHabitacion tipo) {
		this.tipo = tipo;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public boolean isTieneVentana() {
		return tieneVentana;
	}
	public void setTieneVentana(boolean tieneVentana) {
		this.tieneVentana = tieneVentana;
	}
	@Override
	public String toString() {
		return "\n\tHabitacion [tipo=" + tipo + ", area=" + area + ", tieneVentana=" + tieneVentana + "]";
	}
	
	
	
	
	
		
}
