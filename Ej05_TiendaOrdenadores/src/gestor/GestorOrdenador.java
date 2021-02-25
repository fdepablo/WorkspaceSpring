package gestor;

import org.springframework.stereotype.Service;

import entidades.Ordenador;

@Service
public class GestorOrdenador {
	
	public void setPrecioOrdenador (Ordenador o)
	{
		double precio = o.getProcesador().getPrecio()+ o.getDiscoDuro().getPrecio()+ o.getRam().getPrecio();
		o.setPrecio(precio);
	}

}
