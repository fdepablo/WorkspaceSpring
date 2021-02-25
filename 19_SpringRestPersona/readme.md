Springboot con Microservicios
-
Para hacer este ejemplo hay que hacer un proyecto Spring boot con los siguientes
starters:

	1) Spring web
	2) Spring JPA-Data
	3) MySQL
	4) Eureka Discovery Client
	

1. Ponemos la anotacion @EnableDiscoveryClient en Application.java
2. Configuramos el application.properties
3. Arrancamos y vamos al Eureka para ver si se ha dado de alta http://localhost:8084/

Puede que nos de un warning pero sin problemas porque estamos en desarrollo
EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.