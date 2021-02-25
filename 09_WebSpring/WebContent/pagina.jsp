<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">
		<font color="red">
			Scopes de Spring en una app web
		</font>
	</h1>
	
	<p align="center">
		<a href="ServletPrueba">Actualizar</a>
	</p>
	<table>
		<tr>
			<td>Prototype 1</td>
			<td>${mp1}</td>
		</tr>
		<tr>
			<td>Prototype 2</td>
			<td>${mp2}</td>
		</tr>
		<tr>
			<td>Request 1</td>
			<td>${mr1}</td>
		</tr>
		<tr>
			<td>Request 2</td>
			<td>${mr2}</td>
		</tr>
		<tr>
			<td>Session</td>
			<td>${msession}</td>
		</tr>
		<tr>
			<td>Singleton</td>
			<td>${ms}</td>
		</tr>
	</table>
</body>
</html>