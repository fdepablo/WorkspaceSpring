<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>Elija su pedido</h1>

<h2>Usuario: ${usuario.usuario}</h2>



<form method="post">
<div>
<b>Procesadores</b>

<br>
  <c:forEach items="${procesadores}" var="p">
       
           <input type="radio" name="procesadorRadio" value="${p.id}">${p.marca} ${p.nombre} ${p.frecuencia}Hz ${p.precio} Eur<br>
  
  </c:forEach>
</div>    
    
    
<div>
<b>Discos duros</b>
<br>
 <c:forEach items="${discosDuros}" var="dd">
       
           <input type="radio" name="discoDuroRadio" value="${dd.id}">${dd.marca} ${dd.nombre} ${dd.capacidad}GB ${dd.precio} Eur<br>
  
  </c:forEach>
</div>
 
 
  <div>
 <b>RAMS</b>
 
<br>
 <c:forEach items="${rams}" var="r">
       
           <input type="radio" name="ramRadio" value="${r.id}">${r.marca} ${r.nombre} ${r.capacidad}GB ${r.precio} Eur<br>
  
 </c:forEach>
 </div>
 
 <input type="submit" value="Añadir ordenador">
 
 </form>
 
 <br>
 <br>
 
 <b>Ordenadores añadidos</b>
 
 <table border="1">
 
 		<tr>
			
			<td>Procesador</td>
			<td>Disco duro</td>
			<td>RAM</td>
			<td>Precio</td>
		</tr>
 <c:forEach items="${pedido.ordenadores}" var="ordenador">
       
          
	
		<tr>
			<td>${ordenador.procesador.marca} ${ordenador.procesador.nombre} ${ordenador.procesador.frecuencia}Ghz ${ordenador.procesador.precio}Eur</td>
			<td>${ordenador.discoDuro.marca} ${ordenador.discoDuro.nombre} ${ordenador.discoDuro.capacidad}Gb ${ordenador.discoDuro.precio}Eur</td>
			<td>${ordenador.ram.marca} ${ordenador.ram.nombre} ${ordenador.ram.capacidad}Gb ${ordenador.ram.precio}Eur</td>
			<td>${ordenador.precio}Eur</td>
		</tr>

  
 </c:forEach>
 
 </table>
 
 <h3>Precio total del pedido: ${pedido.precio} Eur</h3>



</body>
</html>