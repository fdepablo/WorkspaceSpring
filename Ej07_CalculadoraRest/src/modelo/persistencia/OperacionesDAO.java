package modelo.persistencia;

import java.util.List;

import modelo.entidades.Operacion;

public interface OperacionesDAO {
    
    void insertar(Operacion op);
    
    void modificar(Operacion op);
    
    void borrar(Operacion op);
    
    List<Operacion> buscar(String operacion);
    
    List<Operacion> listar();
}
