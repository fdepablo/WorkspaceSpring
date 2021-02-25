package com.gestor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entidades.Operacion;
import com.persistencia.OperacionDao;

@Service
public class GestorOperacion {

	@Autowired
	private OperacionDao oDao;

	@Transactional
	public void insertar(Operacion o) {
		oDao.save(o);
	}

	@Transactional
	public Operacion modificar(Operacion o) {
		return oDao.save(o);
	}

	@Transactional
	public void borrar(int id) {
		oDao.deleteById(id);
	}

	public Optional <Operacion> buscar(int id) {
		return oDao.findById(id);
	}

	public List<Operacion> listar() {
		return oDao.findAll();
	}
	
	public List<Operacion> listarPorOperacion (String operacion) {
		return oDao.findByOperacion(operacion);
	}

	public Operacion realizarOperacion (Operacion o) 
	{
		try {
		switch (o.getOperacion()) {
		case "+":
			o.setResultado(o.getOperador1() + o.getOperador2());
			this.insertar(o);
			return o;
		
		case "-":
			o.setResultado(o.getOperador1() - o.getOperador2());
			this.insertar(o);
			return o;
		case "*":
			o.setResultado(o.getOperador1() * o.getOperador2());
			this.insertar(o);
			return o;
		case "/":
			o.setResultado(o.getOperador1() / o.getOperador2());
			if (o.getOperador2()==0)
			{
				return null;
			}
			else
			{
			this.insertar(o);
			}
			return o;
		default:
			return null;
		}
			
		}catch (Exception e) {
			 return null;
		}
		
	}

}
