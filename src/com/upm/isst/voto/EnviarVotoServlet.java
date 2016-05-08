package com.upm.isst.voto;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			
			//Cifrarlos con la clave publica del CRV
			//Firmarlos con nuestra clave privada
			//Enviar a ellos (o copiando codigo aqui o con url google app engine)
			
			String usuario =  (String) req.getParameter("dni");
			String autenticado =  (String) req.getParameter("aunt");
			//String provincia = (String) req.getParameter("provincia");
			
			resp.setContentType("text/plain");

			CEEDAO dao = CEEDAOImpl.getInstance();
			CEEModel votante = dao.readDNI(Long.parseLong(usuario));
			
			//Marcar en la base de datos que el usuario ya  ha votado
			votante.setVoto(true);
			dao.update(votante);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			//msj del certificado
		 	Date dNow = new Date( );
		   	SimpleDateFormat ft = new SimpleDateFormat ("dd ' DEL ' MM ' DE ' yyyy ' A LAS ' HH:mm:ss");
			String textCert = votante.getNombre().toUpperCase() + " " + votante.getApellido1().toUpperCase() + " " + votante.getApellido2().toUpperCase() + " HA PARTICIPADO EN LAS ELECCIONES AL SENADO DE 2016 \n POR LA PROVINCIA DE " + votante.getProvincia().toUpperCase() + ", \n EL DIA " + ft.format(dNow);
		
			//HASH: nombreapellido1apellido2 para comprobar la autenticidad de los certificados
			String textHash = votante.getNombre() + votante.getApellido1() + votante.getApellido2();
			byte [] textHashB = textHash.getBytes();
			MessageDigest hash = null;
			try {
				 hash  = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			hash.update(textHashB, 0, textHash.length());
			String cod = new BigInteger(1,hash.digest()).toString(16);
			
			//Guardamos el codigo asociado a cada votante
			votante.setCod(cod);
			dao.update(votante);
			
			//Enviar los datos a la pagina de generacion de certificados
			req.setAttribute("votante", votante);
			req.setAttribute("autenticado", autenticado);
			req.setAttribute("texto", textCert);
			req.setAttribute("hash", cod);
			RequestDispatcher rd = req.getRequestDispatcher("/paginaCertificado.jsp");
			rd.forward(req,resp);
			
		}
		
		 
}
