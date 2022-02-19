<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/style.css?version=6" />
</head>
<body>
	<h1>Paises con más de ${key} habitantes:</h1>
	<br>
	<!-- este items no tiene que ver con el requestScope items-->
	<c:forEach var="t" items="${requestScope.habitantes}">
		<h2>Pais: ${t.nombre}</h2>
		<h3>Capital: ${t.capital}</h3>
		<h3>Habitantes: ${t.habitantes}</h3>
		<br>
		<hr>
	</c:forEach>
	<br>
	<a href="toInicio" id="return2">Volver</a>
</body>
</html>

