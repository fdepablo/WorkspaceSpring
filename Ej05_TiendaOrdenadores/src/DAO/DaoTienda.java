package DAO;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import entidades.DiscoDuro;
import entidades.Procesador;
import entidades.RAM;

@Repository
public class DaoTienda {
	
	@Autowired
	private ApplicationContext context;
	
	public LinkedList <Procesador> getProcesadores ()
	{
		return context.getBean("listaProcesadores", LinkedList.class);
	}
	
	public LinkedList <DiscoDuro> getDiscoDuro ()
	{
		
		return context.getBean("listaDiscosDuros", LinkedList.class);
	}
	public LinkedList <RAM> getRAM ()
	{
		return context.getBean("listaRams", LinkedList.class);
	}

}
