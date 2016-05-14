package com.upm.isst.voto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Base64Encoder;
import org.bouncycastle.util.encoders.Encoder;

import com.upm.isst.voto.dao.CEEDAO;
import com.upm.isst.voto.dao.CEEDAOImpl;
import com.upm.isst.voto.model.CEEModel;
import com.upm.isst.voto.model.VotoModel;

import org.bouncycastle.util.Strings;
public class EnviarVotoServlet extends HttpServlet{
		public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			String [] codigosPoliticos = req.getParameterValues("eleccion");
			String usuario = (String) req.getSession().getAttribute("user");
			CEEDAO dao = CEEDAOImpl.getInstance();
			CEEModel votante = dao.readDNI(Long.parseLong(usuario));
		if(!votante.getVoto()){
			VotoModel voto = new VotoModel();
			String envioVoto = voto.buildVoto(codigosPoliticos);
			byte [] votoCifrado = null;
			try {
				votoCifrado = cifrar(envioVoto);
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchProviderException | InvalidKeySpecException
					| NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException e2) {
				e2.printStackTrace();
			}
			//Conversion del array de bytes cifrado a un String para enviarlo
			String strVoto = Arrays.toString(votoCifrado);
			//Envio al CRV
			//Servlet de mis talleres de TFG paara probar
			resp.sendRedirect("http://1-dot-active-dahlia-127214.appspot.com/aceptarTFG?voto="+strVoto);
			//Servlet del CRV que procesa los votos
			//resp.sendRedirect("http://1-dot-evoto-2016.appspot.com/recibirVoto?voto="+strVoto);
			} else {
				req.getRequestDispatcher("VotoElectronicoETSIT.jsp").forward(req, resp);
			}
		}

		private byte [] cifrar(String envioVoto) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException  {
		      Security.addProvider(new BouncyCastleProvider()); 
		            
		      //Obtener Clave publica del CRV
		      PublicKey clavePublica = getPuK();
		      System.out.println(clavePublica);
		      //Convertir el voto a bytes
		      byte[] voto = null;
		      try {
				voto = envioVoto.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		      //Crear cifrador RSA
		      Cipher cifrador = Cipher.getInstance("RSA", "BC"); 

		      
		      // Poner cifrador en modo CIFRADO 
		      cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);  // Cifra con la clave publica

		      byte[] votoCifrado = cifrador.doFinal(voto);
		      return votoCifrado;
		}
		//Metodos para obtener la clave publica del CRV
		 private RSAPublicKeySpec getPuSpec(){
				RSAPublicKeySpec caPubKeySpec = new RSAPublicKeySpec(
			            new BigInteger("de55a7d04decbfcb33ff62d7973f308661b6500bbf11f72d2076e4d18671412311e496f450b5e8eb6b17a30f0370ea414a5c73e79f8e8c9c3bacc779a33ee448a283b311c5831f26d20c157333938bc7e875b634b5a2aaa746caf7d367c4c1f59e0cc053ffced5d1df9418f1b03f89f1b07eb004cc05c0e95812f81fcbc7a6590ac7c38712ee1885447a64d23488b439f06f84eb52a5c43a8ed6ae986a1f6e9011bcb5c9c3d4bc3637a248abb96ec633719492b2d1a831fa15cbed5cfefd54f71d63b2416e37fe113253ae480046577ac43f8919c99896b18a31e0d774122cff7bbcea05e456e1d3ce9c8e01096e009bcc791fa44258c643a3f767907f6aa589", 16),
			            new BigInteger("10001", 16));
				return caPubKeySpec;
			}
			
		private PublicKey getPuK() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException{
				KeyFactory fact = KeyFactory.getInstance("RSA", "BC");
		        PublicKey caPubKey = fact.generatePublic(getPuSpec());
				return caPubKey;
		}
}

