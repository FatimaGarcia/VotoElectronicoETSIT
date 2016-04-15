<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.html" %>	
<body>
<%@ include file="nav.html" %> 
    <div class="inicio">
    	<!-- Formulario de LogIn -->
    	<c:if test="${mensaje != null }">
    		<div id="form1" class="modal fade in" style="display:block;">
		</c:if>
		<c:if test="${mensaje == null}">
			<div class="modal fade" id="form1" tabindex="-5" role="dialog" aria-labelledby="etiqueta" aria-hidden="false">
		</c:if>
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<a href="VotoElectronicoETSIT.jsp"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button></a>
						<h4 class="modal-title" id="etiqueta">Log-In</h4>
					</div>
					<form action="/controlLogin" method="post" acceptcharset="utf-8">
						<div class="modal-body">
							<div class="form-group">
								<div class="input-group">
									<input class="form-control" type="text" name="usuario" placeholder="DNI"/>
									<label for="usuario" class="input-group-addon glyphicon glyphicon-user"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<input class="form-control" type="password" name="contrasena" placeholder="Contraseña"/>
									<label for="contraseña" class="input-group-addon glyphicon glyphicon-lock"></label>
								</div> 
							</div> 
						</div>
						<div class ="modal-footer"> 						
							<input class="form-control btn btn-primary" type="submit" value="Entrar"/>
						</div>
					</form>
					<c:if test="${mensaje != null }">
						<div class="alert alert-danger text-center" role="alert" id="alert"> <c:out value="${mensaje}"/> </div>
					</c:if>
				</div>
			</div>
		</div>
		<!-- Formulario de registro -->
		<div class="modal fade" id="form2" tabindex="-5" role="dialog" aria-labelledby="etiqueta" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="etiqueta">Registro</h4>
					</div>
					<form role="form" action="controlRegistro" method="post">
						<div class="modal-body">
							<div class="input-group registro">
								<label for="nombre"  class="input-group-addon" style="padding-right:78px;" >  Nombre </label>
								<input type="text" class="form-control" name="nombre">  
							</div>
							<div class="input-group registro">
								<label for="apellido1" class="input-group-addon" style="padding-right:33px;"> Primer Apellido</label>
								<input type="text" class="form-control" name="apellido1" > 
							</div>
							<div class="input-group registro">
								<label for="apellido2" class="input-group-addon" style="padding-right:21px;">Segundo Apellido</label>
								<input type="text" class="form-control" name="apellido2">  
							</div>
							<div class="input-group registro">
								<label for="dni" class="input-group-addon" style="padding-right:103px;">DNI</label>
								<input type="text" class="form-control" name="dni">
							</div>
							<span class="help-block" style="font-size:15px;">DNI con Letra</span>
							<div class="input-group registro">
								<label for="mail" class="input-group-addon" style="padding-right:90px;">E-Mail</label>
								<input type="email" class="form-control" name="mail">  
							</div>
							<div class="input-group registro">
									<label for="provincia" class="input-group-addon" style="padding-right:72px;">Provincia</label>
									<input type="text" class="form-control" name="provincia" >  
							</div>
							<div class="input-group registro">
								<label for="contrasenaR" class="input-group-addon" style="padding-right:57px;">Contraseña</label>
								<input type="password" class="form-control" name="contrsenaR">  
							</div>
							<div class="input-group registro">
								<label for="contrasenaRR" class="input-group-addon" >Repetir contraseña</label>
								<input type="password" class="form-control" name="contrasenaRR" > 
							</div> 
						</div>
						<div class="modal-footer">
							<input type="submit" class="form-control btn btn-success" value="Registrarse" />
						</div>
				</form>
			</div>
		</div>		
	</div>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="Bootstrap/js/bootstrap.min.js"></script>
</body>
</html>