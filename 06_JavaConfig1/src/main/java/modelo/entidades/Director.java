package modelo.entidades;

//Las anotaciones simplifican el bean xml pero por contra
//no podemos cambiar los objetos sin tocar codigo
//y además solo podemos dar el objeto de alta de una manera
//en el contenedor de spring (aunque odemos seguir usando xml)
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Tenemos 4 estereotipos de anotaciones
//@Component
//@Controller
//@Service
//@Repository
//https://stackoverflow.com/questions/6827752/whats-the-difference-between-component-repository-service-annotations-in?rq=1

//id, si no lo ponemos cogemos el de la clase
@Component(value="directorBean")
@Scope(value="prototype")//scope
public class Director {
	private int id;
	private String nombre = "George Lucas";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Director [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
