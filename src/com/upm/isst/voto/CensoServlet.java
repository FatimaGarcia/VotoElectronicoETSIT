package com.upm.isst.voto;

import javax.servlet.http.HttpServlet;

import com.upm.isst.voto.dao.CEEDAO;
import com.upm.isst.voto.dao.CEEDAOImpl;
import com.upm.isst.voto.dao.CensoDAO;
import com.upm.isst.voto.dao.CensoDAOImpl;
import com.upm.isst.voto.dao.PoliticosDAO;
import com.upm.isst.voto.dao.PoliticosDAOImpl;
import com.upm.isst.voto.dao.ProvinciasDAO;
import com.upm.isst.voto.dao.ProvinciasDAOImpl;

@SuppressWarnings("serial")
public class CensoServlet extends HttpServlet {

	public void init(){
		
		/*Servlet que inicia las bases de datos del censo y politicos con los elementos de abajo*/
		CensoDAO dao = CensoDAOImpl.getInstance();
		dao.create((long) 22454076, "rosa", "acien", "zuruta", 02462, "albacete", "albacete", "02/02/1953", "espanola", "mujer", false, false  );
		dao.create((long) 75215071, "daniel", "albusac", "tamargo", 02354, "albacete", "albacete", "02/02/1953", "espanola", "hombre", false, false );
		dao.create((long) 52801993, "jose", "alonso", "becerra", 02544, "albacete", "albacete", "02/02/1953", "espanola", "hombre", false, false );
		dao.create((long) 34784976, "natalia", "benayas", "perez", 28701, "alcobendas", "madrid", "18/12/1949", "espanola", "mujer", false, false );
		dao.create((long) 74340069, "francisco", "bernabe", "casanova", 28458, "madrid", "madrid", "02/02/1953", "espanola", "hombre", false, false );
		dao.create((long) 76938954, "monica", "gongora", "rodriguez", 28700, "madrid", "madrid", "15/05/1978", "espanola", "mujer", false , false);
		dao.create((long) 51465990, "beatriz", "garcia", "heras", 28965, "pozuelo de alarcon", "madrid", "25/06/1991", "espanola", "mujer", false, false );
		dao.create((long) 50933568, "luis", "garrido", "ruiz", 02363, "albacete", "albacete", "06/12/1994", "espanola", "hombre", false , false);
		dao.create((long) 43815329, "david", "gonzalez", "ruiz", 02114, "madrid", "madrid", "18/08/1983", "espanola", "hombre", false , false);
		dao.create((long) 22479862, "jorge", "gonzalez", "navas", 02633, "las rozas", "madrid", "20/03/1957",  "espanola", "hombre", false, false );
		dao.create((long) 15254626, "irene", "amate", "garrido", 28114, "majadahonda", "madrid", "28/02/1971", "espanola", "mujer", false, false );
		dao.create((long) 22473780, "magdalena", "aparicio", "garcia", 28485, "parla", "madrid", "15/11/1938", "espanola", "mujer", false , false);
		dao.create((long) 53749704, "fatima", "garcia", "corrochano", 28701, "alcobendas", "madrid", "09/05/1994", "espanola", "mujer", false, false);
		dao.create((long) 53749703, "carlos", "garcia", "corrochano", 28701, "alcobendas", "madrid", "06/06/1996", "espanola", "hombre", false, false);
		dao.create((long) 88756320, "maria", "lopez", "vaquero", 28444, "alcala de henares", "madrid", "08/08/1988", "espanola", "mujer", false, false);
		dao.create((long) 22854763, "manuel", "martin", "martinez", 28222, "mostoles", "madrid", "10/05/1992", "espanola", "hombre", false, false);
		dao.create((long) 38740234, "marta", "hoyuelos", "vergara", 28021, "madrid", "madrid", "24/01/1994", "espanola", "mujer", false, false);
		dao.create((long) 51110701, "ana", "martin", "legorburo", 28036, "madrid", "madrid", "06/05/1994", "espanola", "mujer", false, false);
		
		
		PoliticosDAO dao1 = PoliticosDAOImpl.getInstance();
		
				dao1.create((long) 1, "Vicente Aroca Sáez", "albacete", "PP",1);
				    dao1.create((long) 2, "Antonio Marcial Marín Hellín", "albacete", "PP", 1);
				    dao1.create((long) 3, "María Rosario Rodríguez Rueda", "albacete", "PP", 1);
				    dao1.create((long) 4, "Matilde Valentín Navarro", "albacete", "PSOE", 2);
				    dao1.create((long) 5, "Manuel Martínez Rodríguez", "albacete", "PSOE", 2);
				    dao1.create((long) 6, "Josefa Moreno Docón", "albacete", "PSOE", 2);
				    dao1.create((long) 7, "Luis Enrique Minguez Vaquero", "albacete", "Ciudadanos", 3);
				    dao1.create((long) 8, "María Teresa García Arce", "albacete", "Ciudadanos", 3);
				    dao1.create((long) 9, "Laureano García Palomares", "albacete", "Ciudadanos", 3);
				    dao1.create((long) 10, "Juan Miguel González Sánchez", "albacete", "Ppodemos", 4);
				    dao1.create((long) 11, "Maria Carmen Fajardo Barba", "albacete", "Podemos", 4);
				    dao1.create((long) 12, "Roberto Antonio Serrano Gómez", "albacete", "Podemos", 4);
				    dao1.create((long) 13, "María de los Llanos Soriano García", "albacete", "PACMA",5);
				    dao1.create((long) 14, "Joel Gallego Pérez", "albacete", "PACMA", 5);
				    dao1.create((long) 15, "Bibiana Navarro Argelich", "albacete", "PACMA", 5);
				    dao1.create((long) 16, "Carmen de la Cuadra Vila", "albacete", "UPyD", 6);
				    dao1.create((long) 17, "José Ignacio Roldán Cortes", "albacete", "UPyD", 6);
				    dao1.create((long) 18, "Francisco Cañadas Martínez", "albacete", "UPyD", 6);
				    dao1.create((long) 20, "Pío García-Escudero Márquez", "madrid", "PP", 1);
				    dao1.create((long) 21, "María Rosa Vindel López", "madrid", "PP", 1);
				    dao1.create((long) 22, "Carlos Aragonés Mendiguchía", "madrid", "PP", 1);
				    dao1.create((long) 23, "María Carlota Merchán Mesón", "madrid", "PSOE", 2);
				    dao1.create((long) 24, "Doménec Miquel Ruiz Devesa", "madrid", "PSOE", 2);
				    dao1.create((long) 25, "Lydia Martínez Mora", "madrid", "PSOE", 2);
				    dao1.create((long) 26, "Ines Cortijo Castilla", "madrid", "Podemos", 4);
				    dao1.create((long) 27, "Rosa Arauzo Quintero", "madrid", "Podemos", 4);
				    dao1.create((long) 28, "German Cano Cuenca", "madrid", "Podemos", 4);
				    dao1.create((long) 29, "Antonio José Pezzi Acosta", "madrid", "Ciudadanos", 3);
				    dao1.create((long) 30, "Carlos Rodriguez Alemany", "madrid", "Ciudadanos", 3);
				    dao1.create((long) 31, "Eva Sagardoy Cayetano", "madrid", "Ciudadanos", 3);
				    dao1.create((long) 32, "Eva Abril Chaigne", "madrid", "IU", 7);
				    dao1.create((long) 33, "Jaldia Abuabarka Aueda", "madrid", "IU", 7);
				    dao1.create((long) 34, "Alberto Manuel Arregui Álava", "madrid", "IU", 7);
				    dao1.create((long) 35, "Fernando Savater", "madrid", "UPyD",6);
				    dao1.create((long) 36, "Andrés Trapiello", "madrid", "UPyD", 6);
				    dao1.create((long) 37, "Magdalena Oliva Díaz", "madrid", "UPyD", 6);
				    dao1.create((long) 38, "Laura Duarte Domínguez", "madrid", "PACMA", 5);
				    dao1.create((long) 39, "Luis Víctor Moreno Barbieri", "madrid", "PACMA", 5);
				    dao1.create((long) 40, "Francisco García Leal", "madrid", "PACMA", 5);
				    dao1.create((long) 41, "Francisco Javier Ortega Smith-Molina", "madrid", "VOX", 8);
				    dao1.create((long) 42, "Ivan Espinosa de los Monteros de Simon", "madrid", "VOX", 8);
				    dao1.create((long) 43, "Carmen Lomana", "madrid", "VOX", 8);
		ProvinciasDAO prov = ProvinciasDAOImpl.getInstance();
		prov.create("madrid", 3);
		prov.create("albacete", 3);
	}
}
