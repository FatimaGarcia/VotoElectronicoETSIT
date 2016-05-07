package com.upm.isst.voto;

import java.io.IOException;   
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.*;
import javax.servlet.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.upm.isst.voto.dao.CEEDAO;
import com.upm.isst.voto.dao.CEEDAOImpl;
import com.upm.isst.voto.dao.ProvinciasDAO;
import com.upm.isst.voto.dao.ProvinciasDAOImpl;
import com.upm.isst.voto.model.CEEModel;

@SuppressWarnings("serial")
public class ControlLoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		
		String userL = req.getParameter("usuario");
		String user = userL.substring(0,8);
		char letra=userL.charAt(8);
		String password = req.getParameter("contrasena");
		int autenticado = 0;
		resp.setContentType("text/plain");

		char[] letrasDNI={'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		int resto =Integer.parseInt(user)%23;
		
		CEEDAO dao = CEEDAOImpl.getInstance();

		ProvinciasDAO prov = ProvinciasDAOImpl.getInstance();
		CEEModel votante = dao.readDNI(Long.parseLong(user));
		
		//Fecha de las elecciones: Año -1900. Mes-1. Dia
		Date fechaInicio = new Date(116, 4, 7, 9, 0);
		Date fechaFin = new Date(116, 4, 7, 20, 0);
		Date hoy = new Date();
		int diaE = fechaInicio.getDate();
		int mesE = fechaInicio.getMonth() + 1;
		int anoE = fechaInicio.getYear() + 1900;
		if(hoy.before(fechaInicio)||hoy.after(fechaFin)){
			String mensaje = "El sistema de votacion se abrira de 8:00 a 20:00 el dia " + diaE + "/" + mesE + "/" + anoE;
			req.setAttribute("mensaje", mensaje);
			req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
			
		}
		else if(letra!=letrasDNI[resto]){
			
			String mensaje = "Datos incorrectos";
			req.setAttribute("mensaje", mensaje);
			req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
			
			
		}
		
		else if (dao.readDNI(Long.parseLong(user))==null){
			String mensaje = "Usuario y contrasena incorrectos";
			req.setAttribute("mensaje", mensaje);
			req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
		}
		else if(votante.getVoto() == true){
			String mensaje = "Usted ya ha votado";
			req.setAttribute("mensaje", mensaje);
			
				req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
	
		}

		else if (dao.readContrasena(password, Long.parseLong(user))){
			//Ir a otra pagina
			autenticado = 1;
			String provincia = dao.readProvincia(Long.parseLong(user));
			int numeroPoliticos = prov.readNumeroCandidatos(provincia); 
			
			req.setAttribute("provincia", provincia);
			req.setAttribute("numeroPoliticos", numeroPoliticos);
			req.setAttribute("autenticado", autenticado);
			req.setAttribute("dni", user);
			RequestDispatcher rd = req.getRequestDispatcher("/controlVoto");
			rd.forward(req,resp);
		
		}else{
			String mensaje = "Usuario o contrasena incorrectos";
			req.setAttribute("mensaje", mensaje);
			req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
		}
	}
}

