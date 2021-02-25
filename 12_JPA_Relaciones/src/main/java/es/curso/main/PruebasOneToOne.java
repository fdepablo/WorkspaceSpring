package es.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.curso.modelo.entidad.Cliente;
import es.curso.modelo.entidad.DatosBancarios;

public class PruebasOneToOne {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("AppPU");
			
		EntityManager em = null;

		DatosBancarios db = new DatosBancarios(null, "Htb", 6000, null);
		Cliente c = new Cliente(null, "Montgomery Burns", "555", db);
		//Si la relaci�n es bidireccional debemos cruzar las referencias:
		db.setCliente(c);
				
		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Podemos guardarlos individualmente y en orden
		//o si no existieran los cascades
		//em.persist(c);  //Aqui el cliente no tiene ID 
		//em.persist(db); //Aqui si
		
		//Como hemos definido la relaci�n en las dos clases podriamos, insertando
		//solo un objeto, insertar los dos
		
		em.persist(c); //-> se insertan los DB por el cascade que hay en Cliente
		//este falla ya que no hay cascade en la clase DatosBancarios
		//em.persist(db); //-> se inserta el cliente por el cascade de DatosBancarios
		
		em.getTransaction().commit(); 
		em.close();		
		
		emf.close();		
	}
	
	
}
