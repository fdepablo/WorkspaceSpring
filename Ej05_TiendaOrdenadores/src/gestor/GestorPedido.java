package gestor;

import org.springframework.stereotype.Service;

import entidades.Ordenador;
import entidades.Pedido;

@Service
public class GestorPedido {
	
	public double calcularPrecioPedido (Ordenador o, Pedido p)
	{
		return o.getPrecio() + p.getPrecio();
	}

}
