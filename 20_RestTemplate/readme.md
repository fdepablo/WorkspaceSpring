# Ejemplo RestTemplate

Este ejemplo se trata de consumir mediante Java-Spring el servicio rest que hemos creado en el ejercicio 19_SpringRestPersona

Para ello vamos a usar las librerias estandares de Spring que son RestTemplate.

Para hacer este proyecto:

1. Crear un proyecto Spring boot
2. Ojo! Elegir war en vez de jar
3. Elegir los siguientes starters
	- Spring Web
	- Eureka Discovery Client
4. Ojo, este es un proyecto que se levanta en u servidor Tomcat en el puerto 8081	
5. La clase Persona se ha copiado del ejercio 19_SpringRestPersona
6. La clase encargada de hacer la peticiones HTTP al ejercicio 04 es la clase PersonaProxy, que va dentro del modelo
7. Hay que anotar la clase Aplication con @EnableDiscoveryClient
8. Crear la clase Configuracion para dar de alta un RestTemplate e inyectarsela al ServicioPersonaProxy

Proxy -> Un proxy, o servidor proxy, en una red informática, es un servidor —programa o dispositivo—, que hace de intermediario en las peticiones de recursos que realiza un cliente a otro servidor.

Nota: Es importante entender que el balanceamiento de carga se hace en los clientes, no en el servidor eureka, por lo que no podemos acceder directamente al servidor eureka desde un navegador o desde un postman, y que sea este el que nos redirija a los otros servicios rest. Lo que si que podemos hacer es acceder a los servicios rest directamente de manera normal, mediante un postman o un navegador web