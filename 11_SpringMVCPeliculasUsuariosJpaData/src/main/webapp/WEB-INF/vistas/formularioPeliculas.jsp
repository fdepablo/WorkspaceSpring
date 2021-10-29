<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function accionFormulario(accion){
		var formulario = document.getElementById("formulario");
		formulario.action = accion;
	}
</script>
</head>
<body>
	<h1 align="center">
		Formulario Peliculas
	</h1>

	<spring:form id="formulario" method="post" modelAttribute="pelicula">
		<spring:hidden path="id"/>
		<table align="center">
			<tr>
				<td>Titulo</td>
				<td><spring:input path="titulo"></spring:input></td>
				<td>${error_titulo}</td>
			</tr>
			<tr>
				<td>Genero</td>
				<td><spring:input path="genero"></spring:input></td>
				<td>${error_genero}</td>
			</tr>
			<tr>
				<td>Year</td>
				<td><spring:input path="year"></spring:input></td>
				<td>${error_year}</td>
			</tr>
		</table>
		<br/>
		<div align="center">
			<input type="submit" onclick="accionFormulario('insertar')" 
				value="Alta Pelicula">
			<input type="submit" onclick="accionFormulario('modificar')" 
				value="Modificar Pelicula"/>
			<input type="submit" onclick="accionFormulario('borrar')"
				value="Borrar Pelicula"/>
			<input type="submit" onclick="accionFormulario('verListado')"
				value="Volver"/>
		</div>
	</spring:form>

	<h1 style="color:red">${errores}</h1>
</body>
</html>




