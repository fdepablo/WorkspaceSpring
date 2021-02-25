package controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import modelo.entidades.Usuario;
import modelo.entidades.Videojuego;
import modelo.negocio.GestorVideojuegos;

@Controller
@Scope("request")
@RequestMapping("videojuegos")
public class ControladorVideojuegos {
	
	@Autowired
	private GestorVideojuegos gestorVideojuegos;
	
	@Autowired
	private Usuario usuario;
	
	public GestorVideojuegos getGestorPeliculas() {
		return gestorVideojuegos;
	}

	public void setGestorPeliculas(GestorVideojuegos gestorVideojuegos) {
		this.gestorVideojuegos = gestorVideojuegos;
	}

	@RequestMapping("verListado")
	public ModelAndView verListadoVideojuegos() {
		List<Videojuego> listaVideojuegos = gestorVideojuegos.getListaVideojuegos();		
		ModelAndView mav = new ModelAndView("listadoVideojuegos");
		mav.addObject("listaVideojuegos", listaVideojuegos);
		mav.addObject(usuario);
		return mav;
	}
	
	@RequestMapping("verFormulario")
	public ModelAndView verFormulario() {
		ModelAndView mav= new ModelAndView("formularioVideojuegos");
		mav.addObject("videojuego", new Videojuego());
		return mav;
	}

	@RequestMapping(path="insertar", method=RequestMethod.POST)
	public ModelAndView insertarVideojuego(@Valid @ModelAttribute Videojuego videojuego, BindingResult br) {
		if(br.hasErrors()) {
			ModelAndView mav = new ModelAndView("formularioVideojuegos");
			String mensajeError = "";
			for(FieldError error : br.getFieldErrors()) {
				mensajeError += error.getField() + " " + error.getDefaultMessage();
			}
			mav.addObject("errores", mensajeError);
			return mav;
		} else {
			gestorVideojuegos.insertar(videojuego);
			return new ModelAndView("redirect:verListado");
		}
	}
	
	@RequestMapping(path="seleccionar", method=RequestMethod.GET)
	public ModelAndView seleccionarVideojuego(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("formularioVideojuegos");
		Videojuego videojuego = gestorVideojuegos.buscar(id);
		mav.addObject("videojuego", videojuego);
		return mav;
	}
	
	@RequestMapping(path="eliminar", method=RequestMethod.POST)
	public ModelAndView borrarVideojuego(@ModelAttribute Videojuego videojuego) {
		ModelAndView mav = new ModelAndView("redirect:verListado");
		gestorVideojuegos.borrar(videojuego);
		return mav;
	}
	
	@RequestMapping(path="actualizar", method=RequestMethod.POST)
	public ModelAndView actualizarVideojuego(@Valid @ModelAttribute Videojuego videojuego, BindingResult br) {
		if(br.hasErrors()) {
			ModelAndView mav = new ModelAndView("formularioVideojuegos");
			String mensajeError = "";
			for(FieldError error : br.getFieldErrors()) {
				mensajeError += error.getField() + " " + error.getDefaultMessage();
			}
			mav.addObject("errores", mensajeError);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("redirect:verListado");
			gestorVideojuegos.modificar(videojuego);
			return mav;
		}
	}
	
}
