<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>Formulario para el alta de contactos</h1>
		<form action="altaAlumno" method="post">
			Nombre:<input type="text" name="nombre"><br> Email:<input
				type="text" name="email"><br> Dni:<input type="text"
				name="dni"><br> Edad:<input type="number" name="edad"><br>
			Curso:<select name="idCurso">
				<c:forEach var="curso" items="${requestScope.cursos}">
					<option value="${curso.idCurso}">${curso.denominacion}</option>
				</c:forEach>
			</select> <input type="submit" value="Alta">
		</form>
</body>
</html>