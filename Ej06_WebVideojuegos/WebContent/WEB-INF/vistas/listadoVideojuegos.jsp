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
	<h1>Bienvenido, ${usuario.nombre}</h1>

	<h2 align="center">
		<font color="blue">
			Listado de Videojuegos
		</font>
	</h2>
	
	<table align="center" border="1">
		<tr>
			<th>Título</th>
			<th>Precio</th>
			<th>Empresa</th>
			<th>Platafomra</th>
			<th>Fecha de publicación</th>
		</tr>
		<c:forEach var="videojuego" items="${listaVideojuegos}">
			<tr>
				<td>
				<!-- Aquí se forma una url como mvc/peliculas/seleccionar?id=id -->
					<c:url var="enlace" value="seleccionar">
						<c:param name="id" value="${videojuego.id}"></c:param>
					</c:url>
					<a href="${enlace}">${videojuego.titulo}</a>
				</td>
				<td>${videojuego.precio}</td>
				<td>${videojuego.empresa}</td>
				<td>${videojuego.plataforma}</td>
				<td>${videojuego.fechaPublic}</td>
			</tr>
		</c:forEach>
	</table>
	
	<p align="center">
		<a href="verFormulario">Ver formulario</a>
	</p>
</body>
</html>