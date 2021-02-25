package com.controlador;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.GrupoOperaciones;
import com.entidades.Operacion;
import com.gestor.GestorOperacion;

@RestController
public class ControladorOperaciones {
	
	@Autowired
	private GestorOperacion go;
	

	@GetMapping (path="operaciones", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<GrupoOperaciones> listar (@RequestParam (name="operacion" , required = false) String operacion)
	{
		
		List <Operacion> listaOperaciones ;
		
		
	
		if (operacion !=null)
		{
			if (operacion.equals(" ")) 
			{
				operacion = "+";
			}
			listaOperaciones = go.listarPorOperacion(operacion);
		}else
		{
			listaOperaciones = go.listar();
		}
		
			
		
		GrupoOperaciones grupo = new GrupoOperaciones ();
		grupo.setOperaciones(listaOperaciones);
		
		return new ResponseEntity<GrupoOperaciones>(grupo, HttpStatus.OK);
	}
	
	
	@PostMapping (path="operaciones", consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Operacion> nuevaOperacion (@RequestBody Operacion o){
		Operacion ofin = go.realizarOperacion(o);
		if (ofin !=null)
		{
			return new ResponseEntity<> (ofin, HttpStatus.CREATED);
		}else
		{
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@DeleteMapping (path="operaciones/{id}")
	public ResponseEntity<Operacion> borrarOperacion (@PathVariable ("id") int id){
		go.borrar(id);
		
			return new ResponseEntity<> (HttpStatus.OK);
		
	}

	
	@PutMapping (path="operaciones/{id}",produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Operacion> modificarOperacion (@PathVariable ("id") int id, @RequestBody Operacion o){
		o.setId(id);
		Operacion omod = go.realizarOperacion(o);
		if (omod !=null)
		{
			return new ResponseEntity<> (omod, HttpStatus.CREATED);
		}else
		{
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
	
}
