<%@page import="modelo.entidades.Pedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Detalles del pedido</h1>
	
 	<% 
		Pedido pedido = (Pedido)request.getAttribute("pedido");
	%>
	
	
	
	<b>Nombre:</b> <%= pedido.getUsuario().getNombre() %> <br><br>
	<b>Telefono:</b> <%= pedido.getUsuario().getTelefono() %> <br><br>
	<b>Direccion:</b> <%= pedido.getUsuario().getDireccion() %> <br><br>
	<b>Tamanio de la pizza:</b> <%= pedido.getPizza().getTam() %> <br><br>
	<b>Lista de ingredientes:</b> <br>
	
	<ul>
	<%
		for(int i = 0; i < pedido.getPizza().getListaIngredientes().size(); i++) {
			String ingrediente = pedido.getPizza().getListaIngredientes().get(i);
	%>
		<li><%= ingrediente %></li>
	<%
		}
	%>
	</ul>
	
	<b>PRECIO TOTAL:</b> <%= pedido.getPrecioTotal() %> EUROS<br>
	
</body>
</html>