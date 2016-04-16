package com.upm.isst.voto;

import java.io.IOException;  
import java.io.PrintWriter;

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
		String user = req.getParameter("usuario");
		String password = req.getParameter("contrasena");
		int autenticado = 0;
		resp.setContentType("text/plain");

		CEEDAO dao = CEEDAOImpl.getInstance();
		dao.create((long) 44, "ana", "martin", "legorburo", "madrid", "cuca");

		ProvinciasDAO prov = ProvinciasDAOImpl.getInstance();
		/*prov.create("madrid", 3);
		prov.create("albacete", 3);*/
		
		if (dao.readDNI(Long.parseLong(user))==null){
			String mensaje = "Usuario y contrasena incorrectos";
			req.setAttribute("mensaje", mensaje);
			req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
		}
		else if(dao.readVoto(Long.parseLong(user))){
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
			RequestDispatcher rd = req.getRequestDispatcher("/controlVoto");
			rd.forward(req,resp);
		
		}else{
			String mensaje = "Usuario o contrasena incorrectos";
			req.setAttribute("mensaje", mensaje);
			req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
		}
	}
}

