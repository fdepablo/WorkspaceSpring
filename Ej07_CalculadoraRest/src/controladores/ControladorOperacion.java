package controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import modelo.entidades.GrupoOperaciones;
import modelo.entidades.Operacion;
import modelo.entidades.Pelicula;
import modelo.gestion.GestorOperaciones;

// @Controller
// @ResponseBody

/*
 * RestController = Conteroller + ResponseBody
 * 
 * Con ResponseBody hacemos que el body del http response,
 * va el objeto devuleto por el m�todo.
 */
@RestController
public class ControladorOperacion {
	
	@Autowired
	private GestorOperaciones gop;

	@PostMapping(path="operaciones", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Operacion> insertar(@RequestBody Operacion op) {
		try {
			gop.insertarOperacion(op);
			return new ResponseEntity<Operacion>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Operacion>(op, HttpStatus.BAD_REQUEST);
		}
		
    }
	
//	@GetMapping(path="operaciones/{operador}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Operacion>> buscarPorTipoOperacion(@PathVariable("operador") String operador) {
//		List<Operacion> lop = this.gop.buscar(operador);
//	
//		
//		if (lop == null) {
//			return new ResponseEntity<List<Operacion>>(lop, HttpStatus.BAD_REQUEST);
//		}
//		
//		return new ResponseEntity<List<Operacion>>(lop, HttpStatus.OK);
//	}
	
	@GetMapping(path="operaciones/{operador}", 
			produces = {MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<GrupoOperaciones> buscarPorTipoOperacion(@PathVariable("operador") String operador) {
		List<Operacion> lop = this.gop.buscar(operador);
		GrupoOperaciones grupo = new GrupoOperaciones();

		grupo.setListaOperaciones(lop);
		
		return new ResponseEntity<GrupoOperaciones>(grupo, HttpStatus.OK);
	}
    
    // http://localhost:8080/15_REST/mvc/operaciones
//    @GetMapping(path="operaciones", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public List<Operacion> listar() {
//        return this.gop.listar();
//    }
	
    @GetMapping(path="operaciones", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<GrupoOperaciones> listar() {
    	List<Operacion> lop = this.gop.listar();
    	
    	GrupoOperaciones grupo = new GrupoOperaciones();
    	grupo.setListaOperaciones(lop);
    	
        return new ResponseEntity<GrupoOperaciones>(grupo, HttpStatus.OK);
    }
}
