<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css?version=4" />
</head>
<body>
	<h1>Añade titulo, genero y año del juego: </h1>
	<form action="AddGame" method="post">
		Titulo:<input type="text" name="nombre"><br> Genero:<input
			type="text" name="genero"><br> Año:<input type="number"
			name="year"><br> <input type="submit" value="Alta">
	</form>
	<br>
	<a href="toInicio">Volver</a>
</body>
</html>