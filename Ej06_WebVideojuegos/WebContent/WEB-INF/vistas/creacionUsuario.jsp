<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center" style="color:blue">Rellene los siguientes campos</h1>
	
	<div align="center">
		<form action="insertarUsuario" method="post" >
			<p>Nombre de usuario</p>
			<input type="text" name="nombre">
			<p>Contraseña</p>
			<input type="password" name="password">
			<p><input type="submit" value="Registrarse"></p>
		</form>
	</div>	
</body>
</html>