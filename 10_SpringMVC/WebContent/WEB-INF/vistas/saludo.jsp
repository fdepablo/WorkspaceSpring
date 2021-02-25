<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Saludo</h1>
	
	<h1>${saludo}</h1>
	<h1 style="color:red">${persona.nombre}</h1>
	
	<h1 style="color:blue">${listaSaludos}</h1>
	<!-- Podemos acceder directamente a un objeto de session 
		si hemos declarado la session como @Scope("session")
	-->
	<h1 style="color:blue">${saludos.listaSaludos}</h1>
	<!-- De manera clasica, ya que el nombre incluye un '.' hay que hacerlo
	con corchetes
	-->
	<h1 style="color:blue">${sessionScope["scopedTarget.saludos"].listaSaludos}</h1>
	<a href="verFormularioSaludo">Volver</a>
</body>
</html>