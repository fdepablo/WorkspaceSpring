# Spring Boot con Spring JPA Data

## Creacion del proyecto con Spring Boot

Para crear este proyecto debemos de crear un proyecto spring boot normal y añadir dos starter, uno seria el de Spring JPA data y el otro sería la base de datos que vayammos a usar (en este caso hemos elegido H2).

Si elegimos una base de datos ligera, como puede ser H2 o Derby, si no le decimos a spring donde se tiene que contectar, nos levantara automaticamente una base de datos en memoria al arrancar la aplicacion. 

En el caso de Spring Boot no tenemos que configurar nada del data source, nos cojera una configuracion por defecto basandose en los starters. En este ejemplo de aqui no hace falta crear una clase de configuracion.

## Fichero de configuracion de Spring boot

El unico fichero de configuracion de Spring Boot se llama por defecto <b>application.properties</b> que se encutra situado en el paquete "src/main/resources". Cualquier configuracion que queramos darle se pondra en dicho fichero. Por ejemplo 

1. podemos configurar el puerto del tomcat (en caso de un proyecto web)
2. Podemos configurar la URL de nuestra BBDD, con su usuario y su password
3. Podemos configurar nuestro ViewResolver del un proyecto web

Podemos cambiar el starter de H2 a MySql para configurar en este fichero nuestro data source

1- Boton derecho sobre el proyecto | Spring | add Stater

## Poner en marcha la aplicacion

Para arrancar una aplicacion Spring Boot debemos ejecutar el método main de la misma. 

## Establecer banner

Podeis poner un banner personalizado creando un fichero <b>banner.txt</b> en el paquete "src/main/resources"


## Bibliografia:

1. [https://devops.datenkollektiv.de/banner.txt/index.html](Generador de Banners)
