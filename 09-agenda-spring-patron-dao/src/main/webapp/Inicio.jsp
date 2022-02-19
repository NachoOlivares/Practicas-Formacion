<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Titulo></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/style.css?version=6" />
</head>

<!-- Si haces copia de projecto cambiar en propiedades>web configuration el nombre del projecto para que coincida -->

<body>
	<h1>Formulario para alta de contacto</h1>
	<form action="AddContact" method="post">
		Nombre:<input type="text" name="nombre"><br> Email:<input
			type="text" name="email"><br> Edad:<input type="number"
			name="edad"><br> <input type="submit" value="Alta">
	</form>
	<br>
	<br>
	<hr>
	<form action="DeleteContact" method=get>
		Email del contacto a eliminar: <input type="text" name="email"><br>
		<br> <input type="submit" value="buscar">
	</form>
	<br>
	<br>
	<hr>
	<form action="SearchContact" method="get">
		Email a buscar: <input type="text" name="clave"><br> <br>
		<input type="submit" value="buscar">
	</form>
	<a href="ListContact">Listar contactos</a>
	<br>
	<br>
	<a href="toInicio">Volver</a>
</body>
</html>