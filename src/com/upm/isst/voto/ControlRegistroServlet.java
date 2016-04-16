package com.upm.isst.voto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;
import javax.servlet.*;

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
			String apellido2BBDD = persona.getApellido1();
			String provinciaBBDD = persona.getProvincia();
		
		}
		
		PrintWriter out = resp.getWriter();
		out.println(nombre);
		out.println(apellido1);
		out.println(apellido1);
		out.println(apellido2);
		out.println(dni);
		out.println(mail);
		out.println(votante);
		out.close();
		
	
	}
}


