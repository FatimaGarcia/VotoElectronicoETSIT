<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.html" %>	
<body>
<%@ include file="nav.html" %> 
	<c:if test="${mensajeSuccess != null }">
		<div class="alert alert-success text-center" id="success" role="alert"> <c:out value="${mensajeSuccess}"/> </div>
	</c:if>
    <!-- Formulario de LogIn -->
    <c:if test="${mensaje != null }">
    	<div id="form1" class="modal fade in" style="display:block;">
	</c:if>
	<c:if test="${mensaje == null}">
		<div class="modal fade" id="form1" tabindex="-5" role="dialog" aria-labelledby="etiqueta" aria-hidden="false">
	</c:if>
  			<div class="modal-dialog" id="dialogLogin">
				<div class="modal-content">
					<div class="modal-header" id="headerLogin">
						<a href="VotoElectronicoETSIT.jsp"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button></a>
						<h4 class="modal-title" id="etiqueta">Log-In - Elecciones Senado 2020</h4>
					</div>
					<form action="/controlLogin" method="post" acceptcharset="utf-8" id="loginForm">
						<div class="modal-body" id="bodyLogin">
							<div class="form-group">
								<div class="input-group">
									<label for="usuario" class="input-group-addon glyphicon glyphicon-user"></label>
									<input class="form-control" type="text" name="usuario" required placeholder="DNI"/>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">									
									<label for="contraseña" class="input-group-addon glyphicon glyphicon-lock"></label>
									<input class="form-control" type="password" name="contrasena" required placeholder="Contraseña"/>
								</div> 
							</div> 
						</div>
						<c:if test="${mensaje != null }">
							<div class="alert alert-danger text-center" role="alert" id="alertaL"> ${mensaje}</div>
						</c:if>
						<div class ="modal-footer" id="footerLogin"> 	
							<input class="form-control btn btn-primary" id="btnLogin" type="submit" value="Entrar"/>
						</div>
					</form>
				
				</div>
			</div>
		</div>
	<!-- Formulario de registro -->
	<c:if test="${mensajeR != null }">
    	<div id="form2" class="modal fade in" style="display:block;">
	</c:if>
	<c:if test="${mensajeR == null}">
		<div class="modal fade" id="form2" tabindex="-5" role="dialog" aria-labelledby="etiqueta" aria-hidden="true">
	</c:if>
			<div class="modal-dialog" id="dialogRegister">
				<div class="modal-content">
					<div class="modal-header" id="headerRegister">
						<a href="VotoElectronicoETSIT.jsp"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button></a>
						<h4 class="modal-title" id="etiqueta">Registro - Elecciones Senado 2020</h4>
					</div>
					<form id="certificadoForm" enctype="multipart/form-data" method="post" action="comprobarCert">
					<input type="file" name="certi">
					<img src="Images/info.png" title="Para exportar su certificado, el cual debe haber sido previamente instalado en su navegador firefox, vaya a Preferencias -> avanzado -> certificados -> ver certificados. Seleccionelo y ver -> detalles ->exportar"/>
					<button type="submit" class="btn btn-info text-center">Validar Certificado</button>
					</form>
					<form id="registrationForm" method="post" action="controlRegistro">
						<div class="modal-body" id="bodyRegister">
							<div class="form-group" style="margin-bottom:7px;">
								<div class="input-group registro">
									<label for="nombre"  class="input-group-addon" style="padding-right:78px;" >Nombre</label>
									<input type="text" class="form-control" name="nombre" > 
								</div>
							</div>
							<div class="form-group" style="margin-bottom:7px;">
								<div class="input-group registro">
									<label for="apellido1" class="input-group-addon" style="padding-right:33px;">Primer Apellido</label>
									<input type="text" class="form-control" name="apellido1"  >
								</div>
							</div>
							<div class="form-group" style="margin-bottom:7px;">
								<div class="input-group registro">
									<label for="apellido2" class="input-group-addon" style="padding-right:21px;">Segundo Apellido</label>
									<input type="text" class="form-control" name="apellido2" >  
								</div>
							</div>
							<div class="form-group" style="margin-bottom:0px;">
								<div class="input-group registro">
									<label for="dni" class="input-group-addon" style="padding-right:103px;">DNI</label>
									<input type="text" class="form-control" name="dni">
								</div>
							</div>
							<span class="help-block" style="font-size:13px; margin-bottom:5px; margin-left:10px;">DNI con Letra</span>
							<div class="form-group">
								<div class="input-group registro">
									<label for="mail" class="input-group-addon" style="padding-right:90px;">E-Mail</label>
									<input type="email" class="form-control" name="mail" >  
							</div>	
							</div>
							<div class="form-group" style="margin-bottom:7px;">
								<div class="input-group registro">
									<label for="provincia" class="input-group-addon" style="padding-right:72px;">Provincia</label>
									<input type="text" class="form-control" name="provincia" >  
								</div>
							</div>
							<div class="form-group" style="margin-bottom:0px;">
								<div class="input-group registro">
									<label for="contrasenaR" class="input-group-addon" style="padding-right:57px;">Contraseña</label>
									<input type="password" class="form-control" name="contrasenaR"> 
								</div>
							</div>
							<span class="help-block" style="font-size:13px; margin-left:10px;">6-10 caracteres</span>
						</div>
						<div class="modal-footer" id="footerRegister">
							<input type="submit" class="form-control btn btn-success" value="Registrarse" />
						</div>
					</form>
					<c:if test="${mensajeR != null }">
						<div id ="alertaR" class="alert alert-danger text-center" role="alert"> <c:out value="${mensajeR}"/> </div>
					</c:if>
				</div>
			</div>		
	<script type="text/javascript" src="validator.js"> </script>

</body>
</html>