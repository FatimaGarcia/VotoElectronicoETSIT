package com.upm.isst.voto;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.upm.isst.voto.dao.CEEDAO;
import com.upm.isst.voto.dao.CEEDAOImpl;
import com.upm.isst.voto.model.CEEModel;

@SuppressWarnings("serial")
public class confirmacionVoto extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if(req.getParameter("respuesta") == null){
			req.getRequestDispatcher("/VotoElectronicoETSIT.jsp").forward(req, resp);
		} else {
			//Lectura y descifrado del mensaje de confirmacion
			String conf = req.getParameter("respuesta");
			String[] byteValues = conf.substring(1, conf.length() - 1).split(",");
			byte[] bytes = new byte[byteValues.length];
			for (int i=0, len=bytes.length; i<len; i++) {
			   bytes[i] = Byte.parseByte(byteValues[i].trim());     
			}
			byte [] descifrado = null;
			try {
				descifrado = descifrar(bytes);
			} catch (InvalidKeyException | IllegalBlockSizeException
					| BadPaddingException | NoSuchAlgorithmException
					| NoSuchProviderException | NoSuchPaddingException
					| InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String codDescr = new String(descifrado);
			String [] codSep = codDescr.split("-");
			String msjErr = null;
			if(codSep[0].equals("grupo1ISST")){	
				if(codSep[2].equals("0")){
					String usuario = (String) req.getSession().getAttribute("user");
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
					req.setAttribute("texto", textCert);
					req.setAttribute("hash", cod);
					RequestDispatcher rd = req.getRequestDispatcher("/paginaCertificado.jsp");
					rd.forward(req,resp);
				} else {
					msjErr = "Se ha producido un error al procesar su voto";
					req.setAttribute("msjErr", msjErr);
					RequestDispatcher rd = req.getRequestDispatcher("/Votar.jsp");
					rd.forward(req,resp);
				} 
			} else {
				msjErr = "Se ha producido un error al procesar su voto";
				req.setAttribute("msjErr", msjErr);
				RequestDispatcher rd = req.getRequestDispatcher("/Votar.jsp");
				rd.forward(req,resp);
			}
		}
	}
	//Descifrar mensajes de confirmacion
	private byte [] descifrar(byte [] votoCifrado) throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException{
		Security.addProvider(new BouncyCastleProvider()); 
        
	      //Obtener Clave privada del CEE
	      PrivateKey clavePrivada = getPrK();

	      //Crear cifrador RSA
	      Cipher cifrador = Cipher.getInstance("RSA", "BC"); 
	      

	      //Poner cifrador en modo DESCIFRADO 
	      cifrador.init(Cipher.DECRYPT_MODE, clavePrivada); // Descrifra con la clave privada
      
	      byte[] bufferPlano2 = cifrador.doFinal(votoCifrado);
	      return bufferPlano2;
	}
	//Clave privada del CEE para descifrar los mensajes
	private RSAPrivateCrtKeySpec getPrSpec(){
		RSAPrivateCrtKeySpec   caPrivKeySpec = new RSAPrivateCrtKeySpec(
	            new BigInteger("cb9a88d4174a49be59c2ac37f9d05dbaa880fca86b39cf4c5e844349a460a3be41aeeca591c8ecbb0df5a3b4245aa3e950e3c4c3adc976038d79848608de7367452f07af8028ae9025b76edf28b6c4ba0e7da0789a8815c87afbd4cb499dc7167ac5e96566eefcf5d8318a6d05fcfae66f437856b07b95fd3be7cec455fa86c7ede1f44946cbdf9df25e902d46d7b772831471bae8e86c79dd609363b02ee2f231e619f07ccc999ca3c8a10bbcb741b34da8636cadef2296057a7c14a2b8996ed1781bad0d1c565ee937da92691e2803edfc8182891957860f98c0084fc114e9eb4ae78c980eed2d79a7e127523be7f2faba50243473857bb40e84257a2478f7", 16),
	            new BigInteger("10001", 16),
	            new BigInteger("91c1c6b4b71baaa147d712bd5becec3cc586d9d9a4319592e193242ca32dbfeb63505bffc7d7248a60dafa5feb2aac6f4a4654c59533457613a0ebdb9c9bcbd8217222b964313b8edc416e70f9cfa614606d552521d3cc6c6286c876e3f3bce3fdee9340d1a8c39528398714b795bcf49cb09b84cc011d86558d84bb8fa5b33844a820257ae2e9e09eea24b0fcd2d0804d5cde230b33fb1f0cb16099763df50bcec64739170dc5c11d5953eb975aaf6d5b937ac1e105c12231d282894520ca525f737e9a2dde093af5399035a802ec6ea1b2538fa01c306a62d1986620139ec5b4c9db9c87c6c4feca2246701f4cbf94b75f33b2fb826e63d7354efa05724651", 16),
	            new BigInteger("ebeb603ccd3639d73529c2051b22bb36141b026cc027428349b312d985a89adc89202e9091eca3c1543bc140df953d7b1796a5ab37d8079b31c48e6b22c25e57286404e094df6ad6b95516830f6e689d36f18cb0baee750b0e1a9dfab9ac9d63d404a5a92afe86e9458a8ea3bf262f0f376fa46259eadc1e470b8829990d8e39", 16),
	            new BigInteger("dcef017f09cbd6389f25e3b8568d537a80549395efd696f06ae4d9c678babe647bea4c2cea222e4b15df8de177e5e0726777a640ba85829ea995439e61a6a5690cce7f4d64591a1fe542b873f1b32c00d647fad3cddfb6be73a010c1f67991f6c4d5dd04b819755b1be8ce6edfcd9c4a3966feb4818c42078161375228e240af", 16),
	            new BigInteger("dafc6c236414de91bdfe59e36571d2b6fae8ab5288f6a84db77e6a93d0f655713a33ce2551de878e7002db7abd4f097795c8b754fc0c21db53d1f0a4cfe9fdaa078af7e00330733a8763ccf6b0bf3a8a1c3310f6073e4b148cedf610828310c1564f4dfa7e372ec19f5462dcea14a680086430013f17bb64bb6b9fe384f74939", 16),
	            new BigInteger("406cf5ebbcc8931c89d43bb69a8eb5c4283e01979c8be01215a9cc93a2cb1a10254e6a8e426c5b418c0c57cc62f146e535a4df774aacfa2d1858ad9236f9a88c9cae6ed2fbab3c020711d0c606ba6fdf829d14d8c4d532ee10bba1875e3f8f3ffda03bc64f852502bf7dc10cf5f87855f0ad47230e0fff853ec641a294c77d83", 16),
	            new BigInteger("d4aa3aa1a3bdd7bc8066dae8de3a5d0020431dd80c0e56eeafb28dbb194159687c22b24a520eeb8c2c7d086df0f4483c744c32eec35b505d8c7a0488dc17fe0a3bc33976897256d6bc1d571c2879ec0f28c6acded5a5d004e450121369a59616e1539a10d2fe21744162ded43c06edb0721880133b50e62b69f596cfa543a049", 16));
	   return caPrivKeySpec;
	}
	
	private PrivateKey getPrK() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException{
		KeyFactory fact = KeyFactory.getInstance("RSA", "BC");
	    PrivateKey caPrivKey = fact.generatePrivate(getPrSpec());
		return caPrivKey;
	}

}
	
