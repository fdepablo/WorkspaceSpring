package es.curso.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.curso.modelo.entidad.Cliente;
import es.curso.modelo.entidad.DatosBancarios;
import es.curso.modelo.entidad.Pedido;


public class PruebasOneToMany {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("AppPU");
			
		EntityManager em = null;

		DatosBancarios db = new DatosBancarios(null, "Htb", 7000, null);
		Cliente c = new Cliente(null, "Bender", "666", db);
		//Si la relaci�n es bidireccional debemos cruzar las referencias:
		db.setCliente(c);
		
		List<Pedido> pedidos = new ArrayList<>();
		Pedido p1 = new Pedido(null,"PED-1",new Date(),c);
		Pedido p2 = new Pedido(null,"PED-2",new Date(),c);
		Pedido p3 = new Pedido(null,"PED-3",new Date(),c);
		Pedido p4 = new Pedido(null,"PED-4",new Date(),c);
		Pedido p5 = new Pedido(null,"PED-5",new Date(),c);
		pedidos.add(p1);
		pedidos.add(p2);
		pedidos.add(p3);
		pedidos.add(p4);
		pedidos.add(p5);
		c.setPedidos(pedidos);		
		
		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Si queremos insertar todos los objetos y no hay cascades hemos
		//de hacerlo por orden
		//em.persist(c);
		//em.persist(p1);
		//em.persist(p2);
		//em.persist(p3);
		//em.persist(p4);
		//em.persist(p5);

		
		//Como tenemos cascades en los dos extremos da igual el objeto
		//que escojamos para hacer el persist...
		
		em.persist(c); //Se insertan tb los pedidos en una especie de proceso batch
		//em.persist(p2); //tambien funcionaria, de hecho al insertar cliente
		//y detectar que tiene 4 pedidos más, tambien se insertarian
		
		em.getTransaction().commit(); 
		em.close();		
		
		System.out.println("Id del cliente:"+c.getId());
		
		
		//Cargas perezosas
		System.out.println("==============================================");
		em = emf.createEntityManager();

		Cliente c2 = em.find(Cliente.class, 1);
		System.out.println(c2.getNombre());
		System.out.println(c2.getDatosBancarios().getBanco());//carga ansiosa

		//tengo que acceder a los pedidos antes de cerrar el entity manager
		//si no daria error si intento acceder a los pedidos
		//ojo solo en hibernate, si se utiliza eclipselink o toplink
		//daria igual
		c2.getPedidos().size();
		
		em.close();
		
		for(Pedido pAux: c2.getPedidos()){
			System.out.println(pAux.getCodigo());
		}
		
		emf.close();
		
	}
	
	
}
