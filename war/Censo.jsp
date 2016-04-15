<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Censo Electoral</title>
</head>
<body>
Censo Electoral
<c:forEach items="${votantes}" var="votante">
<table>
	<tr>
		<th>DNI</th>
		<th>Nombre</th>
		<th>Apell 1</th>
		<th>Apell 2</th>
		<th>Codigo postal</th>
		<th>Ciudad</th>
		<th>Provincia</th>
		<th>Fecha de nacimiento</th>
		<th>Nacionalidad</th>
		<th>Sexo</th>
		<th>Voto Electronico</th>
	</tr>
	<tr>
		<td><c:out value="${votante.dni}" /></td>
		<td><c:out value="${votante.nombre}" /></td>
		<td><c:out value="${votante.apellido1}" /></td>
		<td><c:out value="${votante.apellido2}" /></td>
		<td><c:out value="${votante.codigoPostal}" /></td>
		<td><c:out value="${votante.ciudad}" /></td>
		<td><c:out value="${votante.provincia}" /></td>
		<td><c:out value="${votante.nacimiento}" /></td>
		<td><c:out value="${votante.nacionalidad}" /></td>
		<td><c:out value="${votante.sexo}" /></td>
		<td><c:out value="${votante.votoElectronico}" /></td>
	</tr>
</table>		
</c:forEach>
					
</body>
</html>