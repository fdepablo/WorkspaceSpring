package com.uem.restpersona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import com.uem.restpersona.modelo.entidad.Persona;
import com.uem.restpersona.modelo.persistencia.DaoPersona;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
	
		DaoPersona dao = context.getBean("daoPersona", DaoPersona.class);
		
		Persona p = new Persona();
		p.setNombre("Tom Sawyer");
		p.setEdad(45);
		p.setPeso(78.5);
		
		//dao.save(p);
	}

}
