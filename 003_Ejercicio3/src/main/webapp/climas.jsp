<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de climas</title>
<style>
table,th,td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<c:if test="${requestScope.error ne null}">
		<strong style="color: red;"><c:out
				value="${requestScope.error}"></c:out></strong>
	</c:if>
	<c:if test="${requestScope.correcto ne null}">
		<strong style="color: green;"><c:out
				value="${requestScope.correcto}"></c:out></strong>
	</c:if>
	<c:url value="/addClima" var="addURL"></c:url>
	<c:url value="/editClima" var="editURL"></c:url>


	<c:if test="${requestScope.clima ne null}">
		<form action='<c:out value="${editURL}"></c:out>' method="post">
			ID: <input type="text" value="${requestScope.clima.id}"
				readonly="readonly" name="id"><br>
			Población: <input type="text" value="${requestScope.clima.poblacion}" name="poblacion"><br>
			Litros: <input type="text" value="${requestScope.clima.litros}" name="litros"><br>
			Fecha: <input type="text" value="${requestScope.clima.fecha}" name="fecha"><br>
			Temperatura máxima: <input type="text" value="${requestScope.clima.tempmax}" name="tempmax"><br>
			Temperatura mínima: <input type="text" value="${requestScope.clima.tempmin}" name="tempmin"><br>
			<input type="submit" value="Edit Clima">
		</form>
	</c:if>


	<c:if test="${requestScope.clima eq null}">
		<form action='<c:out value="${addURL}"></c:out>' method="post">
			Población: <input type="text" name="poblacion"><br>
			Litros: <input type="text" name="litros"><br>
			Fecha: <input type="text" name="fecha"><br>
			Temperatura máxima: <input type="text" name="tempmax"><br>
			Temperatura mínima: <input type="text" name="tempmin"><br>
			<input type="submit" value="Add Clima">
		</form>
	</c:if>


	<c:if test="${not empty requestScope.climas}">
		<table>
			<tbody>
				<tr>
					<th>ID</th>
					<th>Población</th>
					<th>Litros</th>
					<th>Fecha</th>
					<th>Temperatura máxima</th>
					<th>Temperatura mínima</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${requestScope.climas}" var="clima">
					<c:url value="/editClima" var="editURL">
						<c:param name="id" value="${clima.id}"></c:param>
					</c:url>
					<c:url value="/deleteClima" var="deleteURL">
						<c:param name="id" value="${clima.id}"></c:param>
					</c:url>
					<tr>
						<td><c:out value="${clima.id}"></c:out></td>
						<td><c:out value="${clima.poblacion}"></c:out></td>
						<td><c:out value="${clima.litros}"></c:out></td>
						<td><c:out value="${clima.fecha}"></c:out></td>
						<td><c:out value="${clima.tempmax}"></c:out></td>
						<td><c:out value="${clima.tempmin}"></c:out></td>
						<td><a
							href='<c:out value="${editURL}" escapeXml="true"></c:out>'>Edit</a></td>
						<td><a
							href='<c:out value="${deleteURL}" escapeXml="true"></c:out>'>Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>