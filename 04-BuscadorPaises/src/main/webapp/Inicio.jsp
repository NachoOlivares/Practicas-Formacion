<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css?version=6" />
</head>
<body style="text-align: center">
	<h1>Buscador</h1>

	<form action="MostrarPaises" method="get">
		<label>Elija continente a mostrar datos:</label> <select name="clave">
			<option value="Asia">Asia</option>
			<option value="Europe">Europa</option>
			<option value="Africa">Africa</option>
			<option value="Oceania">Oceania</option>
			<option value="Americas">Americas</option>
			<option value="Polar Antarctic">Círculo Polar</option>
			<option value="Ocean Antarctic">Océano Antártico</option>
		</select> <br> <br> <input type="submit" value="buscar">
	</form>
	<br>
	<br>
	<hr>
	<form action="MasHabitantes" method="get">
		Población a superar: <input type="text" name="clave"><br>
		<br> <input type="submit" value="buscar">
	</form>
	<br>
	<br>
	<hr>
	<a href="MostrarContinentes">Mostrar continentes</a>

</body>
</html>