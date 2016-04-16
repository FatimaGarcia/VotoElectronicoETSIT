package com.upm.isst.voto;

import javax.servlet.http.HttpServlet;

import com.upm.isst.voto.dao.CEEDAO;
import com.upm.isst.voto.dao.CEEDAOImpl;
import com.upm.isst.voto.dao.CensoDAO;
import com.upm.isst.voto.dao.CensoDAOImpl;

@SuppressWarnings("serial")
public class CensoServlet extends HttpServlet {

	public void init(){
		/*Servlet que inicia la base de datos del censo con los elementos de abajo*/
		CensoDAO dao = CensoDAOImpl.getInstance();

		dao.create((long) 22454076, "rosa", "acien", "zuruta", 02462, "albacete", "albacete", "mayo", "espa�ola", "mujer", false );
		dao.create((long) 75215071, "daniel", "albusac", "tamargo", 03170, "alicante", "alicante", "abril", "espa�ola", "hombre", false );
		dao.create((long) 52801993, "jose", "alonso", "becerra", 25489, "lleida", "lleida", "febrero", "espa�ola", "hombre", false );
		dao.create((long) 34784976, "natalia", "benayas", "perez", 28701, "alcobendas", "madrid", "18/12/1949", "espa�ola", "mujer", false );
		dao.create((long) 74340069, "francisco", "bernabe", "casanova", 03544, "alicante", "alicante", "02/02/1953", "espa�ola", "hombre", false );
		dao.create((long) 76938954, "monica", "gongora", "rodriguez", 41111, "sevilla", "sevilla", "15/05/1978", "espa�ola", "mujer", false );
		dao.create((long) 51465990, "beatriz", "garcia", "heras", 07555, "mallorca", "mallorca", "25/06/1991", "espa�ola", "mujer", false );
		dao.create((long) 50933568, "luis", "garrido", "ruiz", 22532, "huesca", "huesca", "06/12/1994", "espa�ola", "hombre", false );
		dao.create((long) 43815329, "david", "gonzalez", "ruiz", 51445, "ceuta", "ceuta", "18/08/1983", "espa�ola", "hombre", false );
		dao.create((long) 22479862, "jorge", "gonzalez", "navas", 05153, "avila", "avila", "20/03/1957",  "espa�ola", "hombre", false );
		dao.create((long) 15254626, "irene", "amate", "garrido", 16152, "cuenca", "cuenca", "28/02/1971", "espa�ola", "mujer", false );
		dao.create((long) 22473780, "magdalena", "aparicio", "garcia", 34652, "palencia", "palencia", "15/11/1938", "espa�ola", "mujer", false );
		dao.create((long) 22, "ana", "martin", "legorburo", 28036, "madrid", "madrid", "15/11/1938", "espanola", "mujer", false);
	}
}
