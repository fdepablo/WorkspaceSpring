package com.uem.restpersona.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import com.uem.restpersona.modelo.entidad.Persona;

//Con esta clase haremos las conexines a la BBDD de nuestra app
//Hay extender de JpaRepository y parametrizar el tipo de objeto
//que vamos a persistir (Persona) y por otro hay que poner el tipo
//de clave primera que es (en nuestro caso el ID es de tipo "int")

//Por ultimo tenemos que dar de alta un objeto de este tipo en nuestro
//repositorio de Spring, para ello utilizaremos la anotacion siguiente
@Repository
public interface DaoPersona extends JpaRepository<Persona, Integer>{

}