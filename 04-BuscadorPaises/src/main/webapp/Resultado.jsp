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
	<h1>Formulario alta alumno</h1>
	<form action="AddAlumno" method="post">
	Nombre: <input type="text" name="nombre"><br>
	Email: <input type="text" name="email"><br>
	DNI: <input type="text" name="dni"><br>
	Edad: <input type="text" name="edad"><br>
	Curso: <select name="idCurso">
	<c:forEach var="curso" items="${requestScope.cursos}">
		<option value="${curso.idCurso}">${curso.denominacion}</option>
	</c:forEach>
	</select>
	<input type="submit" value="Alta">
	</form>
	<a href="toInicio" id="return2">Volver</a>
</body>
</html>