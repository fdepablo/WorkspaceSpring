package ejemplo09;

public class Arco extends Arma{

	@Override
	public void usar() {
		System.out.println("Como arco de tipo  " + super.getTipo() 
		+ " tenso la cuerda y disparo la flecha");
		
	}

}
