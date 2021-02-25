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
	<h2 align="center">
		<font color="red">
			<u>Listado Peliculas</u>
		</font>
	</h2>

	<table align="center" border="1">
		<tr>
			<th>Titulo</th>
			<th>Director</th>
			<th>Genero</th>
			<th>Año</th>
		</tr>
		<c:forEach items="${listaPeliculas}" var="p">
			<tr>
				<td>
					<!-- mvc/peliculas/seleccionar?id=1 -->
					<c:url var="enlace" value="seleccionar">
						<c:param name="id" value="${p.id}"/>
					</c:url>
					<a href="${enlace}">${p.titulo}</a>
				</td>
				<td>${p.director}</td>
				<td>${p.genero}</td>
				<td>${p.year}</td>
			</tr>
		</c:forEach>
	</table>
	<p align="center">
		<a href="verFormulario">Ir a Formulario</a>
	</p>
</body>
</html>