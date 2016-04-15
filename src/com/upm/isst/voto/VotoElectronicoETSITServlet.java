package com.upm.isst.voto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.upm.isst.voto.dao.CensoDAO;
import com.upm.isst.voto.dao.CensoDAOImpl;
import com.upm.isst.voto.model.CensoModel;

@SuppressWarnings("serial")
public class VotoElectronicoETSITServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		/*Pruebas de que funciona la BBDD*/
		CensoDAO dao = CensoDAOImpl.getInstance();
		
		List<CensoModel> votantes = dao.read();
		
		req.setAttribute("votantes", new ArrayList<CensoModel>(votantes));
		RequestDispatcher view = req.getRequestDispatcher("Censo.jsp");
		try {
			view.include(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
		/*
		dao.create((long) 22454076, "Rosa", "Acien", "Zuruta", 02462, "Albacete", "Albacete", "mayo", "Española", "Mujer", false );
		dao.create((long) 75215071, "Daniel", "Albusac", "Tamargo", 03170, "Alicante", "Alicante", "abril", "Española", "Hombre", false );
		dao.create((long) 52801993, "Jose", "Alonso", "Becerra", 25489, "Lleida", "Lleida", "febrero", "Española", "Hombre", false );
		
		
		for(CensoModel votantes: dao.read()) {
			resp.getWriter().println(votantes);
		}*/
	}
}