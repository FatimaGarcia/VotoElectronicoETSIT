package com.upm.isst.voto;



import java.io.IOException;  
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.*;
import javax.servlet.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.upm.isst.voto.dao.CEEDAO;
import com.upm.isst.voto.dao.CEEDAOImpl;
import com.upm.isst.voto.dao.PoliticosDAO;
import com.upm.isst.voto.dao.PoliticosDAOImpl;
import com.upm.isst.voto.model.PoliticosModel;

@SuppressWarnings("serial")
public class ControlVoto extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
		String provincia = (String) req.getAttribute("provincia");
		int numeroPoliticos = (int) req.getAttribute("numeroPoliticos");
		resp.setContentType("text/plain");

		PoliticosDAO dao = PoliticosDAOImpl.getInstance();
		dao.create((long) 5555, "Pablo Iglesias", (long) 5555, "Madrid", "Podemos");
		dao.create((long) 6666, "Rajoy", (long) 6666, "Salamanca", "PP");
		dao.create((long) 7777, "Sanchez", (long) 7777, "Madrid", "PSOE");
		dao.create((long) 8888, "Albert Rivera", (long) 8888, "Madrid", "Ciudadanos");
		
		List<PoliticosModel> politicos = dao.readProvincia(provincia);
		
		//resp.setContentType("text/plain");
		//req.setAttribute("provincia", provincia);
		//resp.sendRedirect("votar.jsp");
	
	}
}
	