<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function setActionFormulario(accion){
		var formulario = document.getElementById("formulario");	
		formulario.action = accion;
	}
</script>
</head>
<body>
	<h1 align="center">
		<font color="red">Formulario Peliculas</font>
	</h1>
	
	<form:form id="formulario" method="post" modelAttribute="pelicula">
		
		<div align="center">
			<input type="submit" value="Insertar" 
				onclick="setActionFormulario('insertar')">
			<input type="submit" value="Modificar" 
				onclick="setActionFormulario('modificar')">
			<input type="submit" value="Borrar" 
				onclick="setActionFormulario('borrar')">
		</div>
		<br/>
		
		<form:hidden path="id"/>
		
		<table align="center">
			<tr>
				<td>Titulo</td>
				<td><form:input path="titulo" /></td>
				<td style="color:red">${error_titulo}</td>
			</tr>
			<tr>
				<td>Director</td>
				<td><form:input path="director"></form:input></td>
				<td style="color:red">${error_director}</td>
			</tr>
			<tr>
				<td>Genero</td>
				<td><form:input path="genero"></form:input></td>
				<td style="color:red">${error_genero}</td>
			</tr>
			<tr>
				<td>Año</td>
				<td><form:input path="year"></form:input></td>
				<td style="color:red">${error_year}</td>
			</tr>
		</table>
	</form:form>
	
	<h3 style="color:red">${errores}</h3>
	<div align="center">
		<a href="verListado">Ir a listado</a>
	</div>
</body>
</html>