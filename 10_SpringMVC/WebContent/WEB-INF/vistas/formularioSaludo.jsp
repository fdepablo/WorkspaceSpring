
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenidos a nuestra pagina hecha con Spring MVC</h1>
	<h1><font style="color:blue">Formulario Saludo</font></h1>
	<form action="saludo" method="post">
		Nombre: <input type="text" name="nombre"/>
		<input type="submit" value="mandar saludo"/>
	</form>
</body>
</html>