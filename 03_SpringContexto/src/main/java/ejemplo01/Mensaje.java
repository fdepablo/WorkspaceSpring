package ejemplo01;

//Para poder instanciar objetos por defecto en el contexto de spring
//La clase tiene que tener obligatoriamente el contructor sin parametros
public class Mensaje {
	private String cuerpo;
	private String firma;
	
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public String getFirma() {
		return firma;
	}
	public void setFirma(String firma) {
		this.firma = firma;
	}
	
	
	@Override
	public String toString() {
		return "Mensaje [cuerpo=" + cuerpo + ", firma=" + firma + "]";
	}
	
	
}
