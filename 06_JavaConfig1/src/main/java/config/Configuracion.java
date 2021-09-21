package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Esta anotacion decimos que esta clase va a llevar la 
//configuración de nuestro proyecto de spring
//como si fuera un bean.xml
@Configuration
@ComponentScan(basePackages = "modelo")
public class Configuracion {
	//Podremos add beans aqui dentro, se vera en siguientes ejemplos
}






