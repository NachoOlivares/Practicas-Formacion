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
<body>
	<c:forEach var="t" items="${requestScope.contactos}">
		<h2>Nombre: ${t.nombre}</h2>
		<h3>Email: ${t.email}</h3>
		<h3>Edad: ${t.edad}</h3>
		<h3>Id: ${t.idContacto}</h3>
		<a href="DeleteContact?email=${t.email}">Eliminar</a>
		<br>
		<hr>
	</c:forEach>
	<a href="toInicio">Volver</a>
</body>
</html>