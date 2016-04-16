package com.upm.isst.voto;

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.http.*;
import javax.servlet.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.upm.isst.voto.dao.CEEDAO;
import com.upm.isst.voto.dao.CEEDAOImpl;
import com.upm.isst.voto.model.CEEModel;

@SuppressWarnings("serial")
public class ControlLoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String user = req.getParameter("usuario");
		String password = req.getParameter("contrasena");
		resp.setContentType("text/plain");

		CEEDAO dao = CEEDAOImpl.getInstance();
		dao.create((long) 51110701, "ana", "martin", "legorburo", "madrid", "cuca");

		if (dao.readDNI(Long.parseLong(user))==null){
			String mensaje = "Usuario o contraseña incorrectos";
			req.setAttribute("mensaje", mensaje);
			try {
				req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		else if(dao.readVoto(Long.parseLong(user))){
			String mensaje = "Usted ya ha votado";
			req.setAttribute("mensaje", mensaje);
			try {
				req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}

		else if (dao.readContrasena(password, Long.parseLong(user))){
			//Ir a otra pagina

			String provincia = dao.readProvincia(Long.parseLong(user));
			//TODO:

			int numeroPoliticos = 5; 
			//TODO:
			//	Aquí acceder a la base de datos de políticos
			//	int = dao.readNumeroPoliticos("provincia");
			req.setAttribute("provincia", provincia);
			req.setAttribute("numeroPoliticos", numeroPoliticos);

				resp.sendRedirect("Votar.jsp");
		
		}else{
			String mensaje = "Usuario o contraseña incorrectos";
			req.setAttribute("mensaje", mensaje);
			try {
				req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
	}
}

