package com.upm.isst.voto;

import java.io.IOException;

import javax.servlet.http.*;
import javax.servlet.*;

import com.upm.isst.voto.dao.CEEDAO;
import com.upm.isst.voto.dao.CEEDAOImpl;
import com.upm.isst.voto.model.CEEModel;

public class EnviarVotoServlet extends HttpServlet{
		public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			
			String [] codigosPoliticos = req.getParameterValues("eleccion");
			//System.out.println(codigosPoliticos[0].length());
			//System.out.println(codigosPoliticos[1].length());
			//System.out.println(codigosPoliticos[2].length());
			
			//Cifrarlos clave 
			//Enviar a ellos (o copiando codigo aqui o con url google app engine)
			//Generar pdf
			
			String usuario =  (String) req.getParameter("dni");
			String autenticado =  (String) req.getParameter("aunt");
			//String provincia = (String) req.getParameter("provincia");
			
			resp.setContentType("text/plain");

			CEEDAO dao = CEEDAOImpl.getInstance();
			CEEModel votante = dao.readDNI(Long.parseLong(usuario));
			//Marcar en la base de datos que el usuario ya  ha votado
			votante.setVoto(true);
			dao.update(votante);

			
			req.setAttribute("votante", votante);
			req.setAttribute("autenticado", autenticado);
			

			RequestDispatcher rd = req.getRequestDispatcher("/paginaCertificado.jsp");
			rd.forward(req,resp);
			
		}
}
