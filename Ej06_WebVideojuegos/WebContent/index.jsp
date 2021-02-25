<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center" style="color:blue">Bienvenido a la web Sopra Steria Videojuegos</h1>
	
	<h2 align="center">Para acceder, ingrese su nombre de usuario y contraseña</h2>
	
	<h3 align="center" style="color:red">${error}</h3>
	
	<div align="center">
		<form action="mvc/usuarios/ingresarListadoVideojuegos">
			Nombre de usuario:<input type="text" name="nombre">
			Contraseña:<input type="password" name="password">
			<input type="submit" value="Ingresar">
		</form>
	</div>
	
	<div align="center">
		<p><a href="mvc/usuarios/altaUsuario">¿Nuevo usuario? Crear cuenta</a></p>
	</div>
</body>
</html>