package modelo.entidades;

public class Pedido {
	
	private Usuario usuario;
	
	private Pizza pizza;
	
	private int precioTotal;
	
	public Pedido() {
		
	}

	public Pedido(Usuario usuario, Pizza pizza, int precioTotal) {
		super();
		this.usuario = usuario;
		this.pizza = pizza;
		this.precioTotal = precioTotal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
}
