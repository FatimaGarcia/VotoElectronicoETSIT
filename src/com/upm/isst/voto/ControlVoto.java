package com.upm.isst.voto;



import java.io.IOException;   

import java.util.List;

import javax.servlet.http.*;
import javax.servlet.*;

import com.upm.isst.voto.dao.PoliticosDAO;
import com.upm.isst.voto.dao.PoliticosDAOImpl;
import com.upm.isst.voto.model.PoliticosModel;

@SuppressWarnings("serial")
public class ControlVoto extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int autenticado = (int) req.getAttribute("autenticado");
		String provincia = (String) req.getAttribute("provincia");
		int numeroPoliticos = (int) req.getAttribute("numeroPoliticos");
		String usuario =  (String) req.getAttribute("dni");
		resp.setContentType("text/plain");

		PoliticosDAO dao = PoliticosDAOImpl.getInstance();
		
		
		List<PoliticosModel> politicos = dao.readProvincia(provincia);
		
			
		req.setAttribute("candidatos", politicos);
		req.setAttribute("numeroCandidatos", numeroPoliticos);
		req.setAttribute("provincia", provincia.toUpperCase());
		req.setAttribute("autenticado", autenticado);
		req.setAttribute("dni", usuario);
		
		RequestDispatcher rd = req.getRequestDispatcher("/Votar.jsp");
		rd.forward(req,resp);	
	
	
	}
}
	