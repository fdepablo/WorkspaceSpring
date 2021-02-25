package controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entidades.Ordenador;
import entidades.Pedido;
import entidades.Usuario;
import gestor.GestorOrdenador;
import gestor.GestorPedido;
import gestor.GestorTienda;

@Controller
@Scope ("request")//Porque el pedido tiene un scope sesion. Si el controlador es singlenton falla al ejecutarlo
public class ControladorInventario {

	private GestorPedido gp;
	private GestorOrdenador go;
	private Pedido pedido;
	private GestorTienda gt;
	
	
	
	
	@Autowired
	public ControladorInventario(GestorPedido gp, GestorOrdenador go, Pedido pedido, GestorTienda gt) {
		super();
		this.gt = gt;
		this.gp = gp;
		this.go = go;
		this.pedido = pedido;
	}


	@RequestMapping (value = "inventario")
	public String formulario (ModelMap m,  HttpSession sesion)
	{
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		//Pedido p = (Pedido) sesion.getAttribute("pedido");
		m.addAttribute("usuario", u);
		m.addAttribute("discosDuros", gt.getDiscoDuro());
		m.addAttribute("procesadores", gt.getProcesadores());
		m.addAttribute("rams", gt.getRAM());
	
		
		
		
		return "inventario";
	}
	
	
	@RequestMapping (value = "inventario", method =  RequestMethod.POST)
	public String aniadirOrdenador (HttpSession sesion, @RequestParam ("procesadorRadio") int p, @RequestParam ("discoDuroRadio") int d,
			@RequestParam ("ramRadio") int r)
	{
		Ordenador o = new Ordenador ();
		
		o.setProcesador(gt.getProcesadores().get(p));
		o.setDiscoDuro(gt.getDiscoDuro().get(d));
		o.setRam(gt.getRAM().get(r));
		go.setPrecioOrdenador(o);
		
		
		
		
		Double precioP = gp.calcularPrecioPedido(o, pedido);
		
		
		pedido.getOrdenadores().add(o);
		pedido.setPrecio(precioP);
		
		
		
		
		return "redirect:inventario";
	}	
	

}
