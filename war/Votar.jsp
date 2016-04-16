<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.html" %>	
<body>
<%@ include file="nav.html" %> 


<div class="voto">
<form type="post" id="candidatos" action="/enviarVoto">

<h1>Elija un total de <c:out value="${numeroCandidatos}"/> candidatos</br></h1>
<c:forEach items="${candidatos}" var="candidato">
<input name="eleccion" type="checkbox" value=<c:out value="${candidato.codigo}"/>/>
<c:out value="${candidato.nombreCompleto}"/></br>
<c:out value="${candidato.partido}"/></br>
</c:forEach> 
<input type="submit" value="Submit">
</form>
</div>

<script type="text/javascript">
checkboxlimit(document.forms.candidatos.eleccion,${numeroCandidatos});
</script> 



</body>
</html>