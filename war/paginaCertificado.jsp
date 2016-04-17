<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="headvoto.html" %>	
<body>
<c:if test="${autenticado != 1}">
<a id="enlace" href="VotoElectronicoETSIT.jsp"><div class="alert alert-warning text-center" id="alerta">Usted no se ha autenticado en el sistema</div></a>
</c:if>
<c:if test="${autenticado == 1}">
<%@ include file="navvoto.html" %> 
<div class="voto">
<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center" >
	<h1>ELECCIONES A CORTES GENERALES 2016 - SENADO - <c:out value="${votante.provincia}"/></h1>
</div>

<p><c:out value="${votante.nombre}"/> <c:out value="${votante.apellido1}"/> <c:out value="${votante.apellido2}"/> 
ha participado en las elecciones al senado de 2016 por la provincia de <c:out value="${votante.provincia}"/>,
el día <%
   Date dNow = new Date( );
   SimpleDateFormat ft = new SimpleDateFormat ("dd ' de ' MM ' de ' yyyy ' a las ' HH:mm:ss");
	out.print(ft.format(dNow));
%>
</p>
  
 </div>
 
</c:if>
</body>
</html>