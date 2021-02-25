package com.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entidades.Operacion;





public interface OperacionDao extends JpaRepository<Operacion, Integer>{
	
	
	public List <Operacion> findByOperacion (String operacion);
	

}
