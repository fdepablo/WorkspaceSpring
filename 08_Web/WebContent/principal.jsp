<%@page import="modelo.entidades.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Se ha logado correctamente!!!<%=request.getParameter("nombre") %>
	El mensaje que me llega del controlador es <%=request.getAttribute("respuesta") %>
	
	<%
		Persona p = (Persona)request.getAttribute("persona");
		out.print(p.getNombre());
		for(int i = 0;i<10;i++){
	%>
		<h2><%=i %></h2>
	<%
		}
	%>
	
	<h1><%=p.getNombre() %></h1>
		
	<a href="ServletSegundo">continuar</a>
	
	<!-- Mediante expresiones del lenguaje jsp -->
	<!-- https://www.tutorialspoint.com/jsp/jsp_expression_language.htm -->
	<!-- por defecto podemos acceder a los atributos de los distintios scopes -->
	<h1 style="color:yellow">${respuesta}</h1>
	<h1 style="color:red">${persona.nombre}</h1>
	<!-- Tambien podemos decir explicitamente el scope con sus variables -->
	<h1 style="color:cyan">${requestScope.respuesta}</h1>
	<h1 style="color:blue">${personaSession.nombre}</h1>
	<!-- No da error si accedemos a algo que no existe -->
	<h1 style="color:pink">${personaInventada.nombre}</h1>
</body>
</html>




