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
		 String msj = req.getParameter("msj");
			
		 req.setAttribute("msj", msj);
		 String prueba = null;
		 if(msj != null){
				prueba="si";
			}
		req.setAttribute("prueba", prueba);
		RequestDispatcher view = req.getRequestDispatcher("VotoElectronicoETSIT.jsp");
			try {
				view.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			}
	}
}