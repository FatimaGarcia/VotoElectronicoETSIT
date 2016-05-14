
$(document).ready(function() {
	$('#loginForm').bootstrapValidator({
		 feedbackIcons: {
			 valid: 'glyphicon glyphicon-ok',
			 invalid: 'glyphicon glyphicon-remove',
			 validating: 'glyphicon glyphicon-refresh'
		 },
		 fields: {
			 usuario: {
				 validators: {
					 notEmpty: {
						 message: 'Campo obligatorio'
					 },
					 regexp: {
						 regexp: /^\d{8}[a-zA-Z]{1}$/,
						 message: '8 digitos + Letra'
					 }
				 }
			 },
			 contrasena: {
				 validators: {
					 notEmpty: {
						 message: 'Campo obligatorio'
					 }
				 }
			 }
		 }
	});
	$('#registrationForm').bootstrapValidator({
		 feedbackIcons: {
			 valid: 'glyphicon glyphicon-ok',
			 invalid: 'glyphicon glyphicon-remove',
			 validating: 'glyphicon glyphicon-refresh'
		 },
		 fields: {
			 nombre: {
				 validators: {
					 notEmpty: {
						 message: 'Campo obligatorio'
					 }
				 }
			 },
			 apellido1: {
				 validators: {
					 notEmpty: {
						 message: 'Campo obligatorio'
					 }
				 }
			 },
			 apellido2: {
				 validators: {
					 notEmpty: {
						 message: 'Campo obligatorio'
					 }
				 }
			 },
			 dni: {
				 validators: {
					 notEmpty: {
						 message: 'Campo obligatorio'
					 },
					 regexp: {
						 regexp: /^\d{8}[a-zA-Z]{1}$/,
						 message: '8 digitos + Letra'
					 }
				 }
			 },
			 mail: {
				 validators: {
					 notEmpty: {
						 message: 'Campo obligatorio'
					 },
					 emailAddress: {
						 message: 'El correo electronico no es valido'
					 }
				 }
			 },
			 provincia: {
				 validators: {
					 notEmpty: {
						 message: 'Campo obligatorio'
					 }
				 }
			 },
			 contrasenaR: {
				 validators: {
					 notEmpty: {
						 message: 'Campo obligatorio'
					 },
					 stringLength: {
						 min: 6,
						 max: 10,
						 message: 'Longitud: 6-10 caracteres'
					 }
				 }
			 }
		 }
	});
	$('#certificadoForm').bootstrapValidator({
		 feedbackIcons: {
			 valid: 'glyphicon glyphicon-ok',
			 invalid: 'glyphicon glyphicon-remove',
			 validating: 'glyphicon glyphicon-refresh'
		 },
		 fields: {
			 certi: {
				 validators: {
					 notEmpty: {
						 message: 'Campo obligatorio'
					 },
					 file:{
						 	extension: 'crt',
	                        type: 'application/x-x509-user-cert, application/x-x509-ca-cert ',
	                        message: 'El archivo seleccionado no es valido. Extension permitida: .crt'
					 }
					 
				 }
			 }
		 }
	});
});
