package com.upm.isst.voto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;
import javax.servlet.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class ControlLoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String user = req.getParameter("usuario");
		String password = req.getParameter("contrasena");
		String mensaje = null;
		resp.setContentType("text/plain");
		/*
		PrintWriter out = resp.getWriter();
		out.println(user);
		out.println(password);
		out.close();
		/*
		 	CEEDAO dao = CEEDAOImpl.getInstance();
		 	List<cee> votantes = dao.read();
			for(int i=0; i<votantes.length; i++){
				if(votantes[i].DNI == user && votantes[i].contraseña == password){
					RequestDispatcher view = req.getRequestDispatcher("votacion.jsp");
						try {
							view.forward(req, resp);
						} catch (ServletException e) {
							e.printStackTrace();
						}
				}
			}
		 */
		
		if(user == "" || password == ""){
			mensaje = "Introduzca su usuario y contraseña";
			req.setAttribute("mensaje", mensaje);
			RequestDispatcher view = req.getRequestDispatcher("VotoElectronicoETSIT.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		} else if (user == "1" || password == "1"){
			RequestDispatcher view = req.getRequestDispatcher("votar.html");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		} else {
			mensaje = "Usuario o contraseña incorrectos";
			req.setAttribute("mensaje", mensaje);
			RequestDispatcher view = req.getRequestDispatcher("VotoElectronicoETSIT.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
	}
}

