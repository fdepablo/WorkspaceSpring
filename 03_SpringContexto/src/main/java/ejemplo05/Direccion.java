package ejemplo05;

public class Direccion {
	private String tipoVia;
	private String nombreVia;
	private String cp;
	private String pais;
	
	public Direccion() {
		
	}
	
	public Direccion(String tipoVia, String nombreVia, String cp, String pais) {
		super();
		this.tipoVia = tipoVia;
		this.nombreVia = nombreVia;
		this.cp = cp;
		this.pais = pais;
	}
	public String getTipoVia() {
		return tipoVia;
	}
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
}
