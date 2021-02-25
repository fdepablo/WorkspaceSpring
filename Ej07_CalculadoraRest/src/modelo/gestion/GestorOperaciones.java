package modelo.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidades.Operacion;
import modelo.persistencia.OperacionesDAO;

@Service
public class GestorOperaciones {
    
    @Autowired
    private OperacionesDAO operacionesDao;
    
    @Transactional
    public void insertarOperacion(Operacion op) throws Exception {
    	
    	if (!"".equals(op.getOperador())) {
    		switch (op.getOperador()) {
			case "+":
				op.setRes(op.getNum1() + op.getNum2());
				break;

			case "-":
				op.setRes(op.getNum1() - op.getNum2());
				break;
				
			case "*":
				op.setRes(op.getNum1() * op.getNum2());
				break;
			case "div":
				op.setRes(op.getNum1() / op.getNum2());
				break;
			default:
				throw new Exception("Operador no valido");
			}
    		
    		System.out.println("*********************************" + op.toString());
    	} else {
    		throw new Exception("Operador vacío");
    	}
    	
    	this.operacionesDao.insertar(op);
    }
    
    public List<Operacion> buscar(String operador) {
        return this.operacionesDao.buscar(operador);
    }
    
    public List<Operacion> listar() {
        return this.operacionesDao.listar();
    }
    
    public void modificarOperacion(Operacion op) {
        this.operacionesDao.modificar(op);
    }
    
    public void borrar(int id) {
        Operacion op = new Operacion();
        op.setId(id);
        
        this.operacionesDao.borrar(op);
    }
}
