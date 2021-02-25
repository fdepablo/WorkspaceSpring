package herencia;

public abstract class Pez extends Animal {

	private int numeroAletas;
	
	@Override
	public void comer(Object o) {
		if(o instanceof Placton) {
			System.out.println("Soy un pez de tipo " 
					+ this.getClass().getSimpleName() + ", mi nombre es"
					+ this.nombre + " y me voy a comer el placton");
		}else {
			System.out.println("Soy un pez y solo como placton");
		}
	}

	public int getNumeroAletas() {
		return numeroAletas;
	}

	public void setNumeroAletas(int numeroAletas) {
		this.numeroAletas = numeroAletas;
	}

	
}
