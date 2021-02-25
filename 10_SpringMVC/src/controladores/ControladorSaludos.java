package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import entidades.Persona;
import entidades.Saludos;

@Controller
//@Scope("request")
public class ControladorSaludos {
	
	@Autowired
	private Saludos saludoSession;
	
	//Aqui no hacemos distinción según el verbo
	@RequestMapping("verFormularioSaludo")
	public ModelAndView verFormulario() {
		ModelAndView mav = new ModelAndView("formularioSaludo");
		return mav;
	}
	
	//Estos metodos estan muy sobrecargados en spring (realmente no es sobrecarga, se
	//hace por reflectacion), por lo que podemos inyectar muchos tipos de objetos
	//en el metodo
	@RequestMapping(path="saludo",method=RequestMethod.POST)
	public ModelAndView metodoSaludo(@RequestParam("nombre") String nombre,
			HttpServletRequest request, 
			HttpSession session,
			ModelAndView mav){//tambien podemos decir que nos cree un ModelAndView
		String saludo = "Yo te saludo: " + nombre; 
		String nombreAux = request.getParameter("nombre");
		//System.out.println(nombreAux);
		//System.out.println(nombre);
		//llamadas a los servicios..
		Persona p = new Persona();
		p.setNombre(nombre);
		//podriamos acceder así a la lista, siempre y cuando 
		//hayamos creado la sesion como @Scope("session") NO como @SessionScope
		//((Saludos)session.getAttribute("saludos")).getListaSaludos().add(saludo);
		//pero es mas comodo si lo inyectamos con @Autowired
		saludoSession.getListaSaludos().add(saludo);
		
		System.out.println("Saludo session autowired " + saludoSession.getListaSaludos());
		System.out.println("Saludo session de toda la vida " + ((Saludos)session.getAttribute("scopedTarget.saludos")).getListaSaludos());
		
		//ModelAndView mav = new ModelAndView("redirect:verSaludos");
		mav.setViewName("redirect:verSaludos");
		//ya que estamos haciendo un redirect, el nombre que metemos
		//en el objeto mav se va a mandar como parametro
		//de la request. Si no hicieramos un redirect, el nombre se guardaria en el 
		//objeto request
		//La regla suele ser que siempre que hacemos un post se hace un redirect
		mav.addObject("nombre",saludo);
		return mav;
	}
	
	//podemos simplificar un 
	@GetMapping("verSaludos")
	public ModelAndView mostrarSaludos(@RequestParam("nombre") String nombre) {
		ModelAndView mav = new ModelAndView("saludo");
		//Como pasar datos del controlador a la vista
		Persona p = new Persona();
		p.setNombre(nombre);
		
		mav.addObject("persona", p);
		mav.addObject("listaSaludos", saludoSession.getListaSaludos());
		mav.addObject("saludo", nombre);
		return mav;
	}
}
