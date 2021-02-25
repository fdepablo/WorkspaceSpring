<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informática Muñon</title>
</head>
<body>

<center>
	<h1>Informática Muñón</h1>



	<form method="POST" action = "home">
		Nombre <input type="text" name = "nombre" /> Contraseña <input type="password" name="password" /> <input
			type="submit" value = "Ok">
	</form>
	
	
	
	<p style="color:red;">${error}</p>
	

</center>

</body>
</html>