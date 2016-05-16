package com.upm.isst.voto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.*;
import javax.servlet.*;

import com.upm.isst.voto.dao.CEEDAO;
import com.upm.isst.voto.dao.CEEDAOImpl;
import com.upm.isst.voto.dao.CensoDAO;
import com.upm.isst.voto.dao.CensoDAOImpl;
import com.upm.isst.voto.model.CensoModel;

@SuppressWarnings("serial")
public class ControlRegistroServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String nombre = req.getParameter("nombre");
		String apellido1 = req.getParameter("apellido1");
		String apellido2 = req.getParameter("apellido2");
		String dniL = req.getParameter("dni");
		String dni = dniL.substring(0,8);
		Long id = Long.parseLong(dni);
		char letra=dniL.charAt(8);
		String mail = req.getParameter("mail");
		String provincia = req.getParameter("provincia");
		String contrasenaR = req.getParameter("contrasenaR");
		String mensajeR = null;
		String mensajeSuccess = null;
		resp.setContentType("text/html");
		
		
		//Fecha de registro: Año -1900. Mes-1. Dia
		Date fechaInicio = new Date(116, 3, 17, 0, 0);
		Date fechaFin = new Date(116, 4, 19, 0, 0);
		Date hoy = new Date();
		
		char[] letrasDNI={'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		int resto =Integer.parseInt(dni)%23;
		
		CensoDAO dao = CensoDAOImpl.getInstance();
		List<CensoModel> votante = dao.readDNI(id);
		
		if(hoy.after(fechaInicio) && hoy.before(fechaFin)){
			if(votante.size() == 0){
				mensajeR = "No existe ninguna persona asociada a ese DNI en el Censo Electoral";
			} 
			else if(letra!=letrasDNI[resto]){	
				mensajeR = "DNI introducido no es valido";	
			}else {
				CensoModel persona = votante.get(0);
				/*Datos asociados a ese DNI*/
				String nombreBBDD = persona.getNombre();
				String apellido1BBDD = persona.getApellido1();
				String apellido2BBDD = persona.getApellido2();
				String provinciaBBDD = persona.getProvincia();
				boolean cert = persona.certComprobado();

				if(nombre.toLowerCase().equals(nombreBBDD) && apellido1.toLowerCase().equals(apellido1BBDD) && 
					apellido2.toLowerCase().equals(apellido2BBDD) && provincia.toLowerCase().equals(provinciaBBDD)){
					//Comprobamos que la persona no est� autenticada en el sistema
					CEEDAO dao1 = CEEDAOImpl.getInstance();
					
					if(dao1.readDNI(id) == null){
						if(cert){
							persona.setVotoElectronico(true);
							dao.update(persona);
							try {
								Thread.sleep(500);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							dao1.create(id, nombreBBDD, apellido1BBDD, apellido2BBDD, provinciaBBDD, contrasenaR, null);
							
							mensajeSuccess = "Registro completado con exito";
							req.setAttribute("mensajeSuccess", mensajeSuccess);
						} else {
							mensajeR = "Valide su certificado antes de registrarse en el sistema.";
						}
					} else {
						mensajeR = "Usted ya se ha registrado en el sistema";
						persona.setVotoElectronico(true);
						dao.update(persona);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				} else {
					mensajeR = "Los datos introducidos no se corresponden con los del Censo Electoral";
				}
			}
		} else {
			int diaInicio = fechaInicio.getDate();
			int mesInicio = fechaInicio.getMonth() + 1;
			int anoInicio = fechaInicio.getYear() + 1900;
			int diaFin = fechaFin.getDate();
			int mesFin = fechaFin.getMonth() + 1;
			int anoFin = fechaFin.getYear() + 1900;
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("El registro podra hacerse entre el ");
			stringBuilder.append(diaInicio);
			stringBuilder.append("/");
			stringBuilder.append(mesInicio);
			stringBuilder.append("/");
			stringBuilder.append(anoInicio);
			stringBuilder.append(" y ");
			stringBuilder.append(diaFin);
			stringBuilder.append("/");
			stringBuilder.append(mesFin);
			stringBuilder.append("/");
			stringBuilder.append(anoFin);
			mensajeR = stringBuilder.toString();
		}
		
		req.setAttribute("mensajeR", mensajeR);
		String prueba = null;
		if(mensajeR != null){
			prueba="si";
		}
		req.setAttribute("prueba", prueba);
		RequestDispatcher view = req.getRequestDispatcher("VotoElectronicoETSIT.jsp");
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}


