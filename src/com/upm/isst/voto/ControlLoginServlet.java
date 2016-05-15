package com.upm.isst.voto;

import java.io.IOException;   
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.*;
import javax.servlet.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.upm.isst.voto.dao.CEEDAO;
import com.upm.isst.voto.dao.CEEDAOImpl;
import com.upm.isst.voto.dao.PoliticosDAO;
import com.upm.isst.voto.dao.PoliticosDAOImpl;
import com.upm.isst.voto.dao.ProvinciasDAO;
import com.upm.isst.voto.dao.ProvinciasDAOImpl;
import com.upm.isst.voto.model.CEEModel;
import com.upm.isst.voto.model.PoliticosModel;

@SuppressWarnings("serial")
public class ControlLoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String userL = req.getParameter("usuario");
		String user = userL.substring(0,8);
		char letra=userL.charAt(8);
		String password = req.getParameter("contrasena");
		int autenticado = 0;
		req.getSession().setAttribute("aunt", autenticado);
		resp.setContentType("text/plain");

		char[] letrasDNI={'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E','a','b','c','d'
							,'e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int resto =Integer.parseInt(user)%23;
		
		CEEDAO dao = CEEDAOImpl.getInstance();

		ProvinciasDAO prov = ProvinciasDAOImpl.getInstance();
	
		//Fecha de las elecciones: Año -1900. Mes-1. Dia
		Date fechaInicio = new Date(116, 4, 12, 0, 0);
		Date fechaFin = new Date(116, 4, 16, 0, 0);
		Date hoy = new Date();
		int diaE = fechaInicio.getDate();
		int mesE = fechaInicio.getMonth() + 1;
		int anoE = fechaInicio.getYear() + 1900;
		if(hoy.before(fechaInicio)||hoy.after(fechaFin)){
			String mensaje = "El sistema de votacion se abrira de 8:00 a 20:00 el dia " + diaE + "/" + mesE + "/" + anoE;
			req.setAttribute("mensaje", mensaje);
			req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
		}
		else if(letra!=letrasDNI[resto]){
			String mensaje = "DNI introducido no es valido";
			req.setAttribute("mensaje", mensaje);
			req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
		}
		
		else if (dao.readDNI(Long.parseLong(user))==null){
			String mensaje = "Usuario y contrasena incorrectos";
			req.setAttribute("mensaje", mensaje);
			req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
		}
		else if(dao.readDNI(Long.parseLong(user)).getVoto() == true){
			String mensaje = "Usted ya ha votado";
			req.setAttribute("mensaje", mensaje);
			req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
	
		}
		else if (dao.readContrasena(password, Long.parseLong(user))){
			autenticado = 1;
			String provincia = dao.readProvincia(Long.parseLong(user));
			int numeroPoliticos = prov.readNumeroCandidatos(provincia); 
			PoliticosDAO dao1 = PoliticosDAOImpl.getInstance();
			List<PoliticosModel> politicos = dao1.readProvincia(provincia);
			
			req.getSession().setAttribute("candidatos",  new ArrayList<PoliticosModel>(politicos));
			req.getSession().setAttribute("user", user);
			req.getSession().setAttribute("aunt", autenticado);
			req.getSession().setAttribute("provincia", provincia);
			req.getSession().setAttribute("numeroPoliticos", numeroPoliticos);
			RequestDispatcher rd = req.getRequestDispatcher("/Votar.jsp");
			rd.forward(req,resp);	
		}else{
			String mensaje = "Usuario o contrasena incorrectos";
			req.setAttribute("mensaje", mensaje);
			req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
		}
	}
}

