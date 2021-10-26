package es.curso.main;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.cfg.ConfiguracionJPA;
import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.persistencia.DaoPeliculaJPAData;

public class MainJPAData {

	private static ApplicationContext context;

	public static void main(String[] args) {
		
		context = new AnnotationConfigApplicationContext(ConfiguracionJPA.class);		
		System.out.println("Inicializando BBDD...");
		
		Pelicula p = context.getBean("pelicula",Pelicula.class);
		p.setTitulo("La guerra de las galaxias");
		p.setGenero("Scifi");		
		p.setDirector("George Lucas");
		p.setYear(1975);
		p.setFechaAlta(new Date());
		
		//Para este ejemplo mejor usar directamente el Dao y no el Gestor
		DaoPeliculaJPAData gp = context.getBean(DaoPeliculaJPAData.class);
		System.out.println("**** INSERTANDO PELICULA ****");
		p = gp.save(p);
		System.out.println("id insertado: " + p.getId());
		
		System.out.println("**** BUSCAR PELICULA ****");
		
		System.out.println(gp.findById(p.getId()));
		
		System.out.println("**** MODIFICAR PELICULA ****");
		//Esto para modificar solo los campos que queramos
		p = context.getBean("pelicula",Pelicula.class);
		p.setId(1);
		p.setTitulo("El imperio contra ataca");
		p.setGenero("Scifi");
		p.setDirector("George Lucas");
		p.setYear(1979);
		p.setFechaAlta(new Date());
		//Save sirve tanto para dar de alta como para modificar. 
		//Si NO le pasáis ID, sera alta si le pasais ID sera modificacion
		gp.save(p);
		
		System.out.println("**** BUSCAR PELICULA ****");
		//El metodo FindById me devuelve un optional.
		//Un optional es un tipo de dato que salio en Java8. Este objeto la finalidad
		//es hacer de envoltorio de otros objetos y sirve para prevenir objetos
		//que apunten a null
		//Un optional en este caso nunca va a ser null, puede que dentro del optional apuntemos
		//a null (en caso de que el Id que busquemos NO EXISTA), pero el optional 
		//que nos devuelve el metodo nunca sera nulo
		Optional<Pelicula> optionalPelicula = gp.findById(p.getId());
		//Podemos preguntar si el optional tiene valor
		if(optionalPelicula.isPresent()) {
			//Desenvolvemos el objeto que esta dentro del optional
			Pelicula pAux = optionalPelicula.get();
			System.out.println(pAux);
		}else {
			System.out.println("No se ha encontrado la pelicula con ese ID");
		}		
		
		System.out.println("**** INSERTANDO PELICULA ****");
		Pelicula p2 = new Pelicula();
		p2.setGenero("Accion");
		p2.setTitulo("Die Hard");
		p2.setDirector("Bruce Willis");
		p2.setYear(1991);
		p2.setFechaAlta(new Date());
		
		gp.save(p2);
		
		System.out.println("**** LISTAR PELICULA ****");
		List<Pelicula> lista = gp.findAll();
		//Con una funcion lambda podemos recorrer todas las peliculas
		lista.forEach((v) -> System.out.println(v));
		
		System.out.println("**** BORRAR PELICULA ****");
		gp.deleteById(2);
		//gp.delete(p2);
		
		System.out.println("**** LISTAR PELICULA ****");
		lista = gp.findAll();
		lista.forEach((v) -> System.out.println(v));
		
		System.out.println("**** LISTAR POR DIRECTOR ****");
		p = context.getBean("pelicula",Pelicula.class);
		p.setTitulo("El retorno del yedi");
		p.setGenero("Ciencia Ficcion");		
		p.setDirector("George Lucas");
		p.setYear(1985);
		p.setFechaAlta(new Date());
		gp.save(p);
		
		lista = gp.findByDirector("George Lucas");
		lista.forEach((v) -> System.out.println(v));
		
		System.out.println("**** LISTAR POR DIRECTOR Y GENERO****");
		
		lista = gp.findByDirectorAndGenero("George Lucas", "Scifi");
		lista.forEach((v) -> System.out.println(v));
		
		System.out.println("**** LISTAR POR TITULO ASCENDENTE****");
		
		lista = gp.findAllByOrderByTituloAsc();
		lista.forEach((v) -> System.out.println(v));
		
		System.out.println("**** LISTAR POR TITULO DESCENDENTE****");
		
		lista = gp.findAllByOrderByTituloDesc();
		lista.forEach((v) -> System.out.println(v));
		
		System.out.println("**** LISTAR POR TITULO QUE CONTENGA 'EL'***");
		
		lista = gp.findByTituloContaining("El");
		lista.forEach((v) -> System.out.println(v));
		
	}
}
