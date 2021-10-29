<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Pagina de los Saludos</h1>
	
	<h2 style="color:green">Atributo saludo: ${saludo}</h2>
	<h2 style="color:red">Nombre del objeto persona: ${persona.nombre}</h2>	
	<h2 style="color:blue">Lista de saludos: ${listaSaludos}</h2>
	
	<a href="verFormularioSaludo">Volver</a>
</body> 
</html>