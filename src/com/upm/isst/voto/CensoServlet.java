package com.upm.isst.voto;

import javax.servlet.http.HttpServlet;

import com.upm.isst.voto.dao.CEEDAO;
import com.upm.isst.voto.dao.CEEDAOImpl;
import com.upm.isst.voto.dao.CensoDAO;
import com.upm.isst.voto.dao.CensoDAOImpl;
import com.upm.isst.voto.dao.PoliticosDAO;
import com.upm.isst.voto.dao.PoliticosDAOImpl;

@SuppressWarnings("serial")
public class CensoServlet extends HttpServlet {

	public void init(){
		/*Servlet que inicia las bases de datos del censo y politicos con los elementos de abajo*/
		CensoDAO dao = CensoDAOImpl.getInstance();

		dao.create((long) 22454076, "rosa", "acien", "zuruta", 02462, "albacete", "albacete", "mayo", "espanola", "mujer", false );
		dao.create((long) 75215071, "daniel", "albusac", "tamargo", 03170, "alicante", "alicante", "abril", "espanola", "hombre", false );
		dao.create((long) 52801993, "jose", "alonso", "becerra", 25489, "lleida", "lleida", "febrero", "espanola", "hombre", false );
		dao.create((long) 34784976, "natalia", "benayas", "perez", 28701, "alcobendas", "madrid", "18/12/1949", "espanola", "mujer", false );
		dao.create((long) 74340069, "francisco", "bernabe", "casanova", 03544, "alicante", "alicante", "02/02/1953", "espanola", "hombre", false );
		dao.create((long) 76938954, "monica", "gongora", "rodriguez", 41111, "sevilla", "sevilla", "15/05/1978", "espanola", "mujer", false );
		dao.create((long) 51465990, "beatriz", "garcia", "heras", 07555, "mallorca", "mallorca", "25/06/1991", "espanola", "mujer", false );
		dao.create((long) 50933568, "luis", "garrido", "ruiz", 22532, "huesca", "huesca", "06/12/1994", "espanola", "hombre", false );
		dao.create((long) 43815329, "david", "gonzalez", "ruiz", 51445, "ceuta", "ceuta", "18/08/1983", "espanola", "hombre", false );
		dao.create((long) 22479862, "jorge", "gonzalez", "navas", 05153, "avila", "avila", "20/03/1957",  "espanola", "hombre", false );
		dao.create((long) 15254626, "irene", "amate", "garrido", 16152, "cuenca", "cuenca", "28/02/1971", "espanola", "mujer", false );
		dao.create((long) 22473780, "magdalena", "aparicio", "garcia", 34652, "palencia", "palencia", "15/11/1938", "espanola", "mujer", false );
		dao.create((long) 22, "ana", "martin", "legorburo", 28036, "madrid", "madrid", "15/11/1938", "espanola", "mujer", false);
		
		
		PoliticosDAO dao1 = PoliticosDAOImpl.getInstance();
		dao1.create((long) 1, "Vicente Aroca Sáez", "albacete", "pp");
		dao1.create((long) 2, "Antonio Marcial Marín Hellín", "albacete", "pp");
		dao1.create((long) 3, "María Rosario Rodríguez Rueda", "albacete", "pp");
		dao1.create((long) 4, "Matilde Valentín Navarro", "albacete", "psoe");
		dao1.create((long) 5, "Manuel Martínez Rodríguez", "albacete", "psoe");
		dao1.create((long) 6, "Josefa Moreno Docón", "albacete", "psoe");
		dao1.create((long) 7, "Luis Enrique Minguez Vaquero", "albacete", "ciudadanos");
		dao1.create((long) 8, "María Teresa García Arce", "albacete", "ciudadanos");
		dao1.create((long) 9, "Laureano García Palomares", "albacete", "ciudadanos");
		dao1.create((long) 10, "Juan Miguel González Sánchez", "albacete", "podemos");
		dao1.create((long) 11, "Maria Carmen Fajardo Barba", "albacete", "podemos");
		dao1.create((long) 12, "Roberto Antonio Serrano Gómez", "albacete", "podemos");
		dao1.create((long) 13, "María de los Llanos Soriano García", "albacete", "pacma");
		dao1.create((long) 14, "Joel Gallego Pérez", "albacete", "pacma");
		dao1.create((long) 15, "Bibiana Navarro Argelich", "albacete", "pacma");
		dao1.create((long) 16, "Carmen de la Cuadra Vila", "albacete", "upyd");
		dao1.create((long) 17, "José Ignacio Roldán Cortes", "albacete", "upyd");
		dao1.create((long) 18, "Francisco Cañadas Martínez", "albacete", "upyd");
		dao1.create((long) 20, "Pío García-Escudero Márquez", "madrid", "pp");
		dao1.create((long) 21, "María Rosa Vindel López", "madrid", "pp");
		dao1.create((long) 22, "Carlos Aragonés Mendiguchía", "madrid", "pp");
		dao1.create((long) 23, "María Carlota Merchán Mesón", "madrid", "psoe");
		dao1.create((long) 24, "Doménec Miquel Ruiz Devesa", "madrid", "psoe");
		dao1.create((long) 25, "Lydia Martínez Mora", "madrid", "psoe");
		dao1.create((long) 26, "Ines Cortijo Castilla", "madrid", "podemos");
		dao1.create((long) 27, "Rosa Arauzo Quintero", "madrid", "podemos");
		dao1.create((long) 28, "German Cano Cuenca", "madrid", "podemos");
		dao1.create((long) 29, "Antonio José Pezzi Acosta", "madrid", "ciudadanos");
		dao1.create((long) 30, "Carlos Rodriguez Alemany", "madrid", "ciudadanos");
		dao1.create((long) 31, "Eva Sagardoy Cayetano", "madrid", "ciudadanos");
		dao1.create((long) 32, "Eva Abril Chaigne", "madrid", "iu");
		dao1.create((long) 33, "Jaldia Abuabarka Aueda", "madrid", "iu");
		dao1.create((long) 34, "Alberto Manuel Arregui Álava", "madrid", "iu");
		dao1.create((long) 35, "Fernando Savater", "madrid", "upyd");
		dao1.create((long) 36, "Andrés Trapiello", "madrid", "upyd");
		dao1.create((long) 37, "Magdalena Oliva Díaz", "madrid", "upyd");
		dao1.create((long) 38, "Laura Duarte Domínguez", "madrid", "pacma");
		dao1.create((long) 39, "Luis Víctor Moreno Barbieri", "madrid", "pacma");
		dao1.create((long) 40, "Francisco García Leal", "madrid", "pacma");
		dao1.create((long) 41, "Francisco Javier Ortega Smith-Molina", "madrid", "vox");
		dao1.create((long) 42, "Ivan Espinosa de los Monteros de Simon", "madrid", "vox");
		dao1.create((long) 43, "Carmen Lomana", "madrid", "vox");
	}
}
