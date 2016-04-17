<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="headvoto.html" %>	
<body>
<c:if test="${autenticado != 1}">
<a id="enlace" href="VotoElectronicoETSIT.jsp"><div class="alert alert-warning text-center" id="alerta">Usted no se ha autenticado en el sistema</div></a>
</c:if>
<c:if test="${autenticado == 1}">
<%@ include file="navvoto.html" %> 
<div class="voto">
<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center" >
	<h1>ELECCIONES A CORTES GENERALES 2016 - SENADO - <c:out value="${provincia}"/></h1>
</div>
<form method="post" id="candidatos" action="/enviarVoto">
 	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center" id="subtitulo">
 		<h2>Elija un total de <c:out value="${numeroCandidatos}"/> candidatos</h2>
 	</div>
 	<div class="row">
 		<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"></div>
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center" >
				<div class="table-responsive">
			  		<table class="table" id="tabla1">
			  				<c:forEach items="${candidatos}" var="candidato">
			  					<tr>
			  						<td>
			  							<c:choose>
        										<c:when test="${candidato.codPartido == 1}"><img src="Images/LOGO-PP.png" /></c:when>
        										<c:when test="${candidato.codPartido == 2}"><img src="Images/PSOE.png" /></c:when>
											    <c:when test="${candidato.codPartido == 3}"><img src="Images/ciudadanos-logo.png" /></c:when>
											    <c:when test="${candidato.codPartido == 4}"><img src="Images/podemos.png" /></c:when>
											    <c:when test="${candidato.codPartido == 5}"><img src="Images/logo-pacma.png" /></c:when>
											    <c:when test="${candidato.codPartido == 6}"><img src="Images/logo-upd.png" /></c:when>
											    <c:when test="${candidato.codPartido == 7}"><img src="Images/logo-iu.png" /></c:when>
											    <c:when test="${candidato.codPartido == 8}"><img src="Images/logo-vox.png" /></c:when>
											    <c:otherwise>undefined</c:otherwise>
										</c:choose>
									</td><td>
			  							<c:out value="${candidato.partido}"/>
			  						</td>
  									<td><input name="eleccion" type="checkbox" value=<c:out value="${candidato.codigo}"/>/>
  									<c:out value="${candidato.nombreCompleto}"/></br></td>
  								</tr>
  							</c:forEach>
  							<input name="aunt" type="hidden" value=<c:out value="${autenticado}"/>></input>
  							<input name="dni" type="hidden" value=<c:out value="${dni}"/>></input>
			  		</table>
			  	</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2"></div>
		</div>
		<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
					<input id="btn1" type="submit" class="btn btn-success" value="Enviar mi voto" onClick="return confirm('Confirme la emisión del voto');"/>
					<input id="btn2" type="reset" class="btn btn-warning" value="Reestablecer" />
				</div>
		</div>
  </form>
  
 </div>
 
 <script type="text/javascript">
 checkboxlimit(document.forms.candidatos.eleccion,${numeroCandidatos});
 </script> 
</c:if>
</body>
</html>