package com.upm.isst.voto;

import java.io.IOException;

import javax.servlet.http.*;
import javax.servlet.*;

public class EnviarVotoServlet extends HttpServlet{
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			
			String [] codigosPoliticos = req.getParameterValues("eleccion");
			//System.out.println(codigosPoliticos[0].length());
			//System.out.println(codigosPoliticos[1].length());
			//System.out.println(codigosPoliticos[2].length());
			
			//Cifrarlos clave 
			//Enviar a ellos (o copiando codigo aqui o con url google app engine)
			//Generar pdf
			
			
			
		}
}
