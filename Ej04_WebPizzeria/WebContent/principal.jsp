<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenido <%= request.getAttribute("nombreUsuario") %>, ya puede realizar su pedido</h1>
	
	<form action="ServletPedido">
	
		<h3>Indicar datos generales</h3>
		<b>Nombre</b> <br>
		<input type="text" value="<%= request.getAttribute("nombreUsuario") %>" name="nombre"> <br><br>
		
		<input type="hidden" value="<%= request.getAttribute("password") %>" name="password">
		
		<b>Telefono</b> <br>
		<input type="tel" name="telefono"> <br><br>
		
		<b>Direccion</b> <br>
		<input type="text" name="direccion">
		
		<h3>Indicar el tamanio de la pizza</h3>
		<select name="tamanioPizza">
			<option value="pequenia">Pequenia (5 euros)</option>
			<option value="mediana">Mediana (10 euros)</option>
			<option value="grande">Grande (15 euros)</option>
		</select>
		
		<h3>Indicar los ingredientes (1 euro extra por cada ingrediente)</h3>
		
        <input type="checkbox" name="ingredientes" value="tomate"> Tomate
        <input type="checkbox" name="ingredientes" value="aceituna" > Aceituna
        <input type="checkbox" name="ingredientes" value="pepino"> Pepino
        <input type="checkbox" name="ingredientes" value="queso"> Queso
		
		<br><br>
		
		<input type="submit" value="Realizar Pedido">
	</form>
	<%
		if(request.getAttribute("error") != null){
	%>
		<h2 style="color:red"><%=request.getAttribute("error").toString() %></h2>
	<%
		}
	%>
</body>
</html>