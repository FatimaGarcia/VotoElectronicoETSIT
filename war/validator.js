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
						 regexp: /^[0-9]+$/,
						 message: 'El DNI solo puede contener numeros'
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
					 },
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
						 regexp: /^[0-9]+$/,
						 message: 'El DNI solo puede contener numeros'
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
});
