# Spring Boot

Si bien es cierto que Spring Framework es muy potente, la configuración inicial y la preparación de las aplicaciones para producción son tareas bastante tediosas. Spring Boot simplifica el proceso al máximo gracias a sus dos principales mecanismos:

1. <b>Starters</b> Spring Boot nos proporciona una serie de dependencias, llamadas starters, que podemos añadir a nuestro proyecto dependiendo de lo que necesitemos: crear un controlador REST, acceder a una base de datos usando JDBC, conectar con una cola de mensajes Apache ActiveMQ, etc. Una vez añadimos un starter, éste nos proporciona todas las dependencias que necesitamos, tanto de Spring como de terceros. Además, los starters vienen configurados con valores por defecto, que pretenden minimizar la necesidad de configuración a la hora de desarrollar. Cualquier configuración puede ser modificada de ser necesario: desde el puerto en el que la aplicación escucha peticiones, hasta el banner que sale por consola al arrancar la aplicación.

2. <b>Contenedor de aplicaciones integrado</b> Spring Boot permite compilar nuestras aplicaciones Web como un archivo .jar (pero NO es obligatorio) que podemos ejecutar como una aplicación Java normal (como alternativa a un archivo .war, que desplegaríamos en un servidor de aplicaciones como Tomcat). Esto lo consigue integrando el servidor de aplicaciones en el propio .jar y levantándolo cuando arrancamos la aplicación. De esta forma, podemos distribuir nuestras aplicaciones de una forma mucho más sencilla, al poder configurar el servidor junto con la aplicación. Esto también es muy útil en arquitecturas de microservicios, puesto que permite distribuir nuestras aplicaciones como imágenes Docker que podemos escalar horizontalmente (algo muy complicado con un .war).


## Instalacion de plugins de Spring
Este ejemplo esta hecho con Eclipse, por lo que se necesita tener algun plugin que nos facilite la creacion y el manejo de proyectos Spring. Podemos instalar plugins desde el marketplace de Eclipse.

1. Pulsamos en -> Help | Eclipse Marketplace
2. Buscamos el plugin <b>Spring Tools 4</b> y lo instalamos (o uno superior)
3. Dejamos que se instale y reiniciamos Eclipse.

## Creacion del proyecto con Spring Boot

Para crear este proyecto debemos de crear un proyecto spring boot con algunos starters concretos. Hay muchas maneras de crear un proyecto Spring Boot, pero si tenemos instalado el plugin de eclipse podemos hacerlo de la siguiente manera:

1. Pulsamos -> File | new | Spring starter proyect
2. En la opciones debemos de elegir la siguiente configuracion y pulsar next:
    - El nombre del proyecto
    - Elegir la version java que queramos (este caso 11)
    - Si vamos a desplegar el proyecto en un servidor de aplicaciones, debemos de empaquetar el proyecto en formato WAR
    - Podemos cambiar el paquete por defecto
	
3. Aceptamos y finalizamos.

Tambien podriamos hacer estos pasos desde la pagina web oficial de creacion de proyectos [Spring IO](https://start.spring.io/) y luego importar el proyecto en eclipse.

<b>NOTA IMPORTANTE</b> Para que Spring Boot detecte correctamente todas las anotaciones y de de alta adecuadamente los objetos en el contexto de Spring, todas nuestras clases deben estar en el mismo paquete o en un paquete hijo del paquete raiz de la aplicacion. Se puede seguir este proyecto para ver como estan organizadas las clases con sus paquetes.

Para hacer esta aplicacion no se ha elegido ningun stater especial.

Podemos ver en las dependencias de maven todas las librerías que se han incluido

## Poner en marcha la aplicacion

Para arrancar una aplicacion Spring Boot debemos ejecutar el método main de la misma. 

## Establecer un fichero applicationContext.xml

Podemos poner un fichero xml para dar de alta objetos en el contexto de spring en el paquete "src/main/resources" y luego importandolo con la anotacion <b>@ImportResource({"classpath:applicationContext.xml"})</b> en el main de nuestra aplicacion

## Bibliografia:
