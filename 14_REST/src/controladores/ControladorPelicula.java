package controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import modelo.entidades.GrupoPeliculas;
import modelo.entidades.Pelicula;
import modelo.gestion.GestorPelicula;

//@Controller
//@ResponseBody, hacemos que en el body del http response, va el 
//objeto devuelto por el metodo
//RestController es la suma de controller y responsebody
@RestController()
public class ControladorPelicula {
	
	@Autowired
	private GestorPelicula gp;
	
	//http://localhost:8080/14_REST/mvc/peliculas
	//@RequestMapping(path="peliculas",method=RequestMethod.POST)
	@PostMapping(path="peliculas",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pelicula> insertar(
				@RequestBody Pelicula pelicula) {
		try {
			gp.insertar(pelicula);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Pelicula>(pelicula,
					HttpStatus.BAD_REQUEST);
		}
	}
	
	
	//http://localhost:8080/14_REST/mvc/peliculas
	//http://localhost:8080/14_REST/mvc/peliculas?titulo=red&orden=genero
	@GetMapping(path="peliculas",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GrupoPeliculas> listar(
			@RequestParam(name="year",required=false) String year,
			@RequestParam(name="orden",required=false) String orden){
		if(year != null) {
			//deberiamos hacer aqui la busqueda por titulo
		}
		if(orden != null) {
			//Habria que ordenar de forma descendiente
		}
		List<Pelicula> listaPeliculas = gp.listar();
		GrupoPeliculas lp = new GrupoPeliculas();
		
		lp.setListaPeliculas(listaPeliculas);
		return new ResponseEntity<>(lp,HttpStatus.OK);
	}
	
	@GetMapping(path="peliculas/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pelicula> obtenerPelicula(
			@PathVariable("id") int id){
		Pelicula p = gp.getPelicula(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@PutMapping(path="peliculas/{id}")
	public ResponseEntity<Pelicula> modificarPelicula(
			@RequestBody Pelicula pelicula,
			@PathVariable("id") int id){
		pelicula.setId(id);
		gp.modificar(pelicula);
		return new ResponseEntity<Pelicula>(pelicula,HttpStatus.OK);		
	}
	
	@DeleteMapping(path="peliculas/{id}")
	public ResponseEntity<Integer> borrarPelicula(
			@PathVariable int id){
		gp.borrar(id);
		return new ResponseEntity<Integer>(id,HttpStatus.OK); 
	}
}




