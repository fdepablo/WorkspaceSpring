# Spring JPA-Data

Spring Data es un proyecto de SpringSource cuyo propósito es unificar y facilitar el acceso a distintos tipos de tecnologías de persistencia, tanto a bases de datos relacionales como a las del tipo NoSQL.

El objetivo de Spring JPA-Data es simplificar la implementación de la capa de acceso a datos, unificando la configuración y creando una jerarquía de excepciones común para todas ellas.

Con cada tipo de tecnología de persistencia los DAOs (Data Access Objects) ofrecen las funcionalidades típicas de un CRUD (Create-Read-Update-Delete ) para objetos de dominio propios, métodos de busqueda, ordenación y paginación. Spring Data proporciona interfaces genéricas para estos aspectos, como <b>JpaRepository</b>

A día de hoy, Spring Data proporciona soporte para las siguientes tecnologías de persistencia:

1. JPA y JDBC
2. Apache Hadoop
3. MongoDB
4. GemFire
5. Redis
6. Neo4j
7. HBase

## Configuracion del ejemplo

Debemos configurar nuestro pom con la siguiente dependencia (a parte de las del otro ejemplo)

	<!-- https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa -->
	<dependency>
	    <groupId>org.springframework.data</groupId>
	    <artifactId>spring-data-jpa</artifactId>
	    <version>2.1.21.RELEASE</version>
	</dependency>

Vamos a partir del ejemplo de JPA para realizarlo. Lo unico que hay que tener en cuenta es que para habilitar repositorios JPA-Data tenemos que habilitarlos mediante la anotacion @EnableJpaRepositories en la clase de configuración.

Tambien el Dao sería diferente.

## Bibliografia

- [https://spring.io/projects/spring-data-jpa](https://spring.io/projects/spring-data-jpa) 
- [https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa](https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa)
