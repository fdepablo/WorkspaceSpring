<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center" style="color:cyan">
		Listado de Peliculas 
	</h2>
	
	<h3>Usuario: ${usuario.nombre}</h3>
	
	<table align="center" border="1">
		<tr>
			<th>ID</th>
			<th>TITULO</th>
			<th>GENERO</th>
			<th>YEAR</th>
		</tr>
		<!-- JSTL muy util para recorrer un array pasado desde el controlador -->
		<c:forEach items="${listaPeliculas}" var="p">
		<tr>
			<td>
				${p.id}
			</td>
			<td><!--  seleccionar?id=X"-->
				<c:url var="enlace" value="seleccionar">
					<c:param name="id" value="${p.id}"></c:param>
				</c:url>
				<a href="${enlace}">${p.titulo}</a>
			</td>
			<td>${p.genero}</td>
			<td>${p.year}</td>
		</tr>		
		</c:forEach>
	</table>
	<p align="center">
		<a href="verFormulario">Ir al formulario</a>
	</p>
</body>
</html>


