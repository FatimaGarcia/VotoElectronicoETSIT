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
		resp.setContentType("text/plain");

		CEEDAO dao = CEEDAOImpl.getInstance();
		dao.create((long) 44, "ana", "martin", "legorburo", "madrid", "cuca");

		ProvinciasDAO prov = ProvinciasDAOImpl.getInstance();
		prov.create("madrid", 2);
		
		
		if (dao.readDNI(Long.parseLong(user))==null){
			String mensaje = "Introduzca usuario y contrasena";
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

			String provincia = dao.readProvincia(Long.parseLong(user));
			//TODO:

			int numeroPoliticos = prov.readNumeroCandidatos(provincia); 
			//TODO:
			//	Aquí acceder a la base de datos de políticos
			//	int = dao.readNumeroPoliticos("provincia");
			req.setAttribute("provincia", provincia);
			req.setAttribute("numeroPoliticos", numeroPoliticos);

			RequestDispatcher rd = req.getRequestDispatcher("/controlVoto");
			rd.forward(req,resp);
		
		}else{
			String mensaje = "Usuario o contrasena incorrectos";
			req.setAttribute("mensaje", mensaje);
			req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
		}
	}
}

