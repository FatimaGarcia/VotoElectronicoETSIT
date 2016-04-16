package com.upm.isst.voto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
		String dni = req.getParameter("dni");
		Long id = Long.parseLong(dni);
		String mail = req.getParameter("mail");
		String provincia = req.getParameter("provincia");
		String contrasenaR = req.getParameter("contrasenaR");
		String mensajeR = null;
		String mensajeSuccess = null;
		resp.setContentType("text/html");
		
		CensoDAO dao = CensoDAOImpl.getInstance();
		List<CensoModel> votante = dao.readDNI(id);
		if(votante.size() == 0){
			mensajeR = "No existe ninguna persona asociada a ese DNI en el Censo Electoral";
			req.setAttribute("mensajeR", mensajeR);
			RequestDispatcher view = req.getRequestDispatcher("VotoElectronicoETSIT.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		} else {
			CensoModel persona = votante.get(0);
			/*Datos asociados a ese DNI*/
			String nombreBBDD = persona.getNombre();
			String apellido1BBDD = persona.getApellido1();
			String apellido2BBDD = persona.getApellido2();
			String provinciaBBDD = persona.getProvincia();
	
			if(nombre.toLowerCase().equals(nombreBBDD) && apellido1.toLowerCase().equals(apellido1BBDD) && 
				apellido2.toLowerCase().equals(apellido2BBDD) && provincia.toLowerCase().equals(provinciaBBDD)){
				
				if(persona.isVotoElectronico() == false){
					persona.setVotoElectronico(true);
					dao.update(persona);
					
					CEEDAO dao1 = CEEDAOImpl.getInstance();
					dao1.create(id, nombreBBDD, apellido1BBDD, apellido2BBDD, provinciaBBDD, contrasenaR);
					
					mensajeSuccess = "Registro completado con exito";
					req.setAttribute("mensajeSuccess", mensajeSuccess);
					RequestDispatcher view = req.getRequestDispatcher("VotoElectronicoETSIT.jsp");
					try {
						view.forward(req, resp);
					} catch (ServletException e) {
						e.printStackTrace();
					}
				} else {
					mensajeR = "Usted ya se ha registrado en el sistema";
					req.setAttribute("mensajeR", mensajeR);
					RequestDispatcher view = req.getRequestDispatcher("VotoElectronicoETSIT.jsp");
					try {
						view.forward(req, resp);
					} catch (ServletException e) {
						e.printStackTrace();
					}
				}
			} else {
				mensajeR = "Los datos introducidos no se corresponden con los del Censo Electoral";
				req.setAttribute("mensajeR", mensajeR);
				RequestDispatcher view = req.getRequestDispatcher("VotoElectronicoETSIT.jsp");
				try {
					view.forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
			
			PrintWriter out = resp.getWriter();
			out.println(nombre.toLowerCase());
			out.println(apellido1.toLowerCase());
			out.println(apellido2);
			out.println(dni);
			out.println(mail);
			out.println(nombreBBDD);
			out.println(apellido1BBDD);
			out.println(apellido2BBDD);
			out.println(provinciaBBDD);
			out.println(persona);
			out.close();

		}
	}
}


