package controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import modelo.entidades.Pelicula;
import modelo.excepciones.CustomException;
import modelo.negocio.GestorPeliculas;

@Controller
@RequestMapping("peliculas")
public class ControladorPeliculas {
	
	@Autowired
	private GestorPeliculas gestorPeliculas;
	
	@RequestMapping(path="modificar",method=RequestMethod.POST)
	public ModelAndView modificarPelicula(@ModelAttribute Pelicula pelicula) {
		gestorPeliculas.modificarPelicula(pelicula);
		return new ModelAndView("redirect:verListado");
	}
	
	@RequestMapping(path="borrar",method=RequestMethod.POST)
	public ModelAndView borrarPelicula(@ModelAttribute Pelicula pelicula) {
		gestorPeliculas.borrarPelicula(pelicula);
		return new ModelAndView("redirect:verListado");
	}
	
	@RequestMapping(path="seleccionar",method=RequestMethod.GET)
	public ModelAndView seleccionarPelicula(
			@RequestParam("id") Integer id) {
		Pelicula pelicula = gestorPeliculas.buscarPelicula(id);
		ModelAndView mav = new ModelAndView("formularioPeliculas");
		mav.addObject("pelicula", pelicula);
		return mav;
	}
	
	
	
	@RequestMapping(path="insertar",method=RequestMethod.POST)
	public ModelAndView insertarPelicula(
			@Valid @ModelAttribute Pelicula pelicula,BindingResult br) {
		System.out.println(br);
		if(br.hasErrors()) {
			ModelAndView mav = new ModelAndView("formularioPeliculas");
			String mensajeError = "";
			for(FieldError fe : br.getFieldErrors()) {
				mensajeError+= fe.getField() + " " + fe.getDefaultMessage();
			}
			System.out.println(mensajeError);
			mav.addObject("errores", mensajeError);
			return mav;
		}
		
		try {
			gestorPeliculas.insertar(pelicula);
		}catch(CustomException e) {//esto asi no, aunque funcione, anotaciones mejor
			ModelAndView mav = new ModelAndView("formularioPeliculas");
			mav.addObject("errorTitulo", e.getMessage() );
			mav.addObject("pelicula", pelicula);
			return mav;			
		}
		
		//siempre que hacemos un insertar SIEMPRE hay que hacer
		//un redirect
		return new ModelAndView("redirect:verListado");
	}
	
	@RequestMapping("verFormulario")
	public ModelAndView verFormulario() {
		ModelAndView mav = new ModelAndView("formularioPeliculas");
		mav.addObject("pelicula", new Pelicula());
		return mav;
	}
	
	@RequestMapping("verListado")
	public ModelAndView verListadoPeliculas() {
		List<Pelicula> listaPeliculas = gestorPeliculas.getListaPeliculas();
		ModelAndView mav = new ModelAndView("listadoPeliculas");
		mav.addObject("listaPeliculas",listaPeliculas);
		return mav;
		
	}

	public GestorPeliculas getGestorPeliculas() {
		return gestorPeliculas;
	}

	public void setGestorPeliculas(GestorPeliculas gestorPeliculas) {
		this.gestorPeliculas = gestorPeliculas;
	}
}
