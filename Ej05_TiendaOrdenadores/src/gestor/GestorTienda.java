package gestor;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.DaoTienda;
import entidades.DiscoDuro;
import entidades.Procesador;
import entidades.RAM;

@Service
public class GestorTienda {

	@Autowired
	private DaoTienda dt;
	
	
	public LinkedList <Procesador> getProcesadores ()
	{
		return dt.getProcesadores();
	}
	
	public LinkedList <DiscoDuro> getDiscoDuro ()
	{
		return dt.getDiscoDuro();
	}
	public LinkedList <RAM> getRAM ()
	{
		return dt.getRAM();
	}
}
