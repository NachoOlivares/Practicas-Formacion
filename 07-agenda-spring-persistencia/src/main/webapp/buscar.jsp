<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="toInicio">Volver</a>
	<!-- este items no tiene que ver con el requestScope items-->
	<h2>Nombre: ${contacto.nombre}</h2>
	<h3>Email: ${contacto.email}</h3>
	<h3>Edad: ${contacto.edad}</h3>
	<br>
	<hr>
	<br>
	<a href="toInicio">Volver</a>
</body>
</html>