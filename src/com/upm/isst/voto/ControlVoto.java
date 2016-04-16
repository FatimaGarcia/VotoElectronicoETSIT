package com.upm.isst.voto;



import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.http.*;
import javax.servlet.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.upm.isst.voto.dao.PoliticosDAO;
import com.upm.isst.voto.dao.PoliticosDAOImpl;
import com.upm.isst.voto.model.PoliticosModel;

@SuppressWarnings("serial")
public class ControlVoto extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
		String provincia = req.getParameter("provincia");
		resp.setContentType("text/plain");
		req.setAttribute("provincia", provincia);
		try {
			req.getRequestDispatcher("Votar.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	
	}
}
	