package controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import entidades.Pedido;
import entidades.Usuario;
import gestor.GestorOrdenador;
import gestor.GestorPedido;
import gestor.GestorTienda;
import gestor.GestorUsuario;

@Controller
//@Scope ("request")//Porque el pedido tiene un scope sesion. Si el controlador es singlenton falla al ejecutarlo
public class ControladorInicio {
	
	@Autowired
	private GestorUsuario gu;

		
	@GetMapping("home")
	public String paginaPrincipal ()
	{
		System.out.println("Entrando");
		return "index";
	}
	
	@RequestMapping (value="home", method =  RequestMethod.POST)
	public String validar (@RequestParam ("nombre") String nombre, @RequestParam ("password") String password, ModelMap m, HttpSession sesion)
	{
		if (gu.validar(nombre, password))
		{
			Usuario u = new Usuario (nombre, password);
			Pedido p = new Pedido ();
			sesion.setAttribute("usuario", u);
			sesion.setAttribute("pedido", p);
			return "redirect:inventario";
		}else
		{
			
			m.addAttribute("error", "Usuario o contraseña incorrectos");
			return "index";
		}
	}
	
	

	
}
