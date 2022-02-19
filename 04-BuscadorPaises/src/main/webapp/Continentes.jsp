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
	<div id="left">
		<ul>
			<c:forEach var="t" items="${requestScope.continentes}">
				<li>${t}</li>
				<hr>
			</c:forEach>
		</ul>
	</div>
	<img
		src="${pageContext.request.contextPath}/static/images/MapaMundo.jpg?version=2"
		alt="Mapa Continentes" id="pic" />
	<a id="return" href="toInicio">Volver</a>
</body>
</html>