# Spring Boot con Spring MVC y Spring JPA Data

Este proyecto se ha hecho a partir del ejemplo SpringMVCPeliculasUsuariosJpaData pero con Spring Boot

## Creacion del proyecto con Spring Boot

Para crear este ejemplo debemos de crear un proyecto spring boot pero como enpaquetado elegimos <b>war</b> en vez de jar. Luego añadiremos tres starter, uno seria el de Spring JPA data, otro seria Spring Web y el otro sería la base de datos H2.

No hace falta configurar un Tomcat en nuestro proyecto, ni siquiera descargarlo, Spring Boot incluira un servidor Tomcat en nuestro ejecutable.

Hay varios motores de plantillas en una aplicacion Spring Boot (Thymeleaf o JSP, los más famosos). Thymeleaf viene incluido por defecto en spring boot pero JSP no, por lo que debemos de incluirlo en el pom.xml de nuestro proyecto maven.

	<dependency>
		<groupId>org.apache.tomcat.embed</groupId>
		<artifactId>tomcat-embed-jasper</artifactId>
		<scope>provided</scope>
	</dependency>
	
Tambien podemos incluir las librerias JSTL

	<!-- https://mvnrepository.com/artifact/jstl/jstl -->
	<dependency>
	    <groupId>jstl</groupId>
	    <artifactId>jstl</artifactId>
	    <version>1.2</version>
	</dependency>
	
Dentro de la carpeta "webapp" podemos crear nuestra carpeta WEB-INF, y dentro nuestro fichero "web.xml" en caso necesario.

Al estar tomcat embebido en nuestra aplicacion todos los recursos estaran disponibles desde "http://localhost:8080/"

Si por ejemplo creamos un HTML llamado index.html, para acceder a el deberiamos poner "http://localhost:8080/index.html"

## Fichero de configuracion de Spring boot

Podemos configurar nuestro fichero de configuracion en application.properties

Debemos de configurar nuestro ViewResolver de Spring MVC para que sepa donde estan nuestras vistas. Para ello modificaremos el fichero de configuracioni con las siguientes propiedades

	spring.mvc.view.prefix=/WEB-INF/vistas/
	spring.mvc.view.suffix=.jsp

Tambien podemos modificar el puerto de arranque del Tomcat

	server.port=8080
	

## Poner en marcha la aplicacion

Para arrancar una aplicacion Spring Boot debemos ejecutar el método main de la misma. 


## Bibliografia:

