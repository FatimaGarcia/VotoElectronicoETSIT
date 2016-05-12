package com.upm.isst.voto;

import java.io.BufferedInputStream;
import java.io.BufferedReader; 
import java.io.DataInputStream;
import java.io.FileInputStream;  
import java.io.IOException;   
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.OutputStream;

import javax.servlet.RequestDispatcher;






import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;



@SuppressWarnings("serial")
public class comprobarCert extends HttpServlet {

 /* public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,
      IOException {*/
	// public static void main(String[] args) throws UnsupportedEncodingException, IOException, CertificateException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, SignatureException {

		/*
	public static PublicKey getPub()
				    throws Exception {

			 InputStream input = new URL("https://1-dot-evoto-2016.appspot.com/vercertca").openStream();
				   
				    DataInputStream dis = new DataInputStream(input);
				    byte[] keyBytes = new byte[(int)input.available()];
				    dis.readFully(keyBytes);
				    dis.close();
				    System.out.println("1");
				    X509EncodedKeySpec spec =
				      new X509EncodedKeySpec(keyBytes);
				    System.out.println("2");
				    KeyFactory kf = KeyFactory.getInstance("RSA", "BC");
				    System.out.println("3");
				    System.out.println(kf.generatePublic(spec)); 
				    return kf.generatePublic(spec);
		
		
		
				  }*/
	private static RSAPublicKeySpec getPuSpec(){
		RSAPublicKeySpec caPubKeySpec = new RSAPublicKeySpec(
	            new BigInteger("de55a7d04decbfcb33ff62d7973f308661b6500bbf11f72d2076e4d18671412311e496f450b5e8eb6b17a30f0370ea414a5c73e79f8e8c9c3bacc779a33ee448a283b311c5831f26d20c157333938bc7e875b634b5a2aaa746caf7d367c4c1f59e0cc053ffced5d1df9418f1b03f89f1b07eb004cc05c0e95812f81fcbc7a6590ac7c38712ee1885447a64d23488b439f06f84eb52a5c43a8ed6ae986a1f6e9011bcb5c9c3d4bc3637a248abb96ec633719492b2d1a831fa15cbed5cfefd54f71d63b2416e37fe113253ae480046577ac43f8919c99896b18a31e0d774122cff7bbcea05e456e1d3ce9c8e01096e009bcc791fa44258c643a3f767907f6aa589", 16),
	            new BigInteger("10001", 16));
		return caPubKeySpec;
	}	 
	
	
		/* private static RSAPublicKeySpec getPuSpec(){
				RSAPublicKeySpec caPubKeySpec = new RSAPublicKeySpec(
			            new BigInteger("de55a7d04decbfcb33ff62d7973f308661b6500bbf11f72d2076e4d18671412311e496f450b5e8eb6b17a30f0370ea414a5c73e79f8e8c9c3bacc779a33ee448a283b311c5831f26d20c157333938bc7e875b634b5a2aaa746caf7d367c4c1f59e0cc053ffced5d1df9418f1b03f89f1b07eb004cc05c0e95812f81fcbc7a6590ac7c38712ee1885447a64d23488b439f06f84eb52a5c43a8ed6ae986a1f6e9011bcb5c9c3d4bc3637a248abb96ec633719492b2d1a831fa15cbed5cfefd54f71d63b2416e37fe113253ae480046577ac43f8919c99896b18a31e0d774122cff7bbcea05e456e1d3ce9c8e01096e009bcc791fa44258c643a3f767907f6aa589", 16),
			            new BigInteger("10001", 16));
				return caPubKeySpec;
			}
		 private static PublicKey getPuK() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException{
				KeyFactory fact = KeyFactory.getInstance("RSA", "BC");
		        PublicKey caPubKey = fact.generatePublic(getPuSpec());
				return caPubKey;
			}*/
		
		 public static void main(String[] args) throws UnsupportedEncodingException, IOException, CertificateException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, SignatureException, InvalidKeySpecException {
		 
		 
		/*	 File file = new File("/Users/Ana/Documents/AnaMartinLegorburo(51110701D)");
	         FileInputStream in=new FileInputStream(file);
	        
	         CertificateFactory cf = CertificateFactory.getInstance("X.509");
		 
	         try {
	             X509Certificate cert=(X509Certificate)cf.generateCertificate(in);
	             System.out.println("Hola"); 
	             cert.verify(getPub());

	           }catch(Exception e){System.out.println("error");}
	           finally {
	             in.close();
	           }
	           
		 */
			 RSAPublicKeySpec spec = getPuSpec();
			 KeyFactory factory = KeyFactory.getInstance("RSA");
			 PublicKey pub = factory.generatePublic(spec);
			 
			 File signa=new File("/Users/Ana/Documents/pubKsig");
			 FileInputStream sigfis = new FileInputStream(signa);
			 byte[] sigToVerify = new byte[sigfis.available()]; 
			 sigfis.read(sigToVerify);
			 sigfis.close();
			 Signature verifier = Signature.getInstance("SHA256withRSA");
			 verifier.initVerify(pub);
			 
			 
			 File certi=new File("/Users/Ana/Documents/AnaMartinLegorburo(51110701D)");
			 FileInputStream datafis = new FileInputStream(certi);
			 BufferedInputStream bufin = new BufferedInputStream(datafis);

			 byte[] buffer = new byte[1024];
			 int len;
			 while (bufin.available() != 0) {
			     len = bufin.read(buffer);
			     verifier.update(buffer, 0, len);
			 };

			 bufin.close();
			 boolean verifies = verifier.verify(sigToVerify);

			 System.out.println("signature verifies: " + verifies);
		 
		 }
	 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	  
		/* InputStream input = new URL("https://1-dot-evoto-2016.appspot.com/vercertca").openStream();
		 
		 try( BufferedReader br =
		           new BufferedReader( new InputStreamReader(input,"UTF-8")))
		   {
		      StringBuilder sb = new StringBuilder();
		      String line;
		      while(( line = br.readLine()) != null ) {
		         sb.append( line );
		         sb.append( '\n' );}
		      System.out.println(sb.toString());
		      }catch(Exception e){System.out.println("catch 2");}
		 
		 System.out.println("Hasta");
         CertificateFactory cf = CertificateFactory.getInstance("X.509");
         System.out.println("Hasta");
         X509Certificate ca = (X509Certificate) cf.generateCertificate(input);
         input.close();
         System.out.println("Hasta aqui");
         File file = new File("AnaMartinLegorburo(51110701D)");
         FileInputStream in=new FileInputStream(file);
         try( BufferedReader br =
		           new BufferedReader( new InputStreamReader(in,"UTF-8")))
		   {
		      StringBuilder sb = new StringBuilder();
		      String line;
		      while(( line = br.readLine()) != null ) {
		         sb.append( line );
		         sb.append( '\n' );}
		      System.out.println(sb.toString());
		      }catch(Exception e){System.out.println("catch 2");}
		 
         
         
         try {
           X509Certificate cert=(X509Certificate)cf.generateCertificate(in);
           cert.verify(ca.getPublicKey());

         }
         finally {
           in.close();
         }
         
            // cert.verify(ca.getPublicKey());
         
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 */
		 
		 
	   
		 
		 /* PublicKey ckey = null; // Clave pública del cliente
			X509Certificate certificado = null; // Certificado para devolver
			// Intentar decodificar la clave publica recibida en base 64
			try {
				InputStream input = new URL("https://1-dot-evoto-2016.appspot.com/vercertca").openStream();
				byte[] byteKey = Base64.decode(IOUtils.toByteArray(input));
				JcaSignedPublicKeyAndChallenge a = new JcaSignedPublicKeyAndChallenge(byteKey);
				ckey = a.getPublicKey();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error al decodificar la clave");
			}
		 
		 */
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 //File file = new File("/Users/Ana/Documents/pubK");
		
		// File file = new File("https://1-dot-evoto-2016.appspot.com/vercertca");
	  //FileInputStream fis = null;

		/* byte[] encKey = new byte[input.available()];  
		 input.read(encKey);
		 input.close();
		 
		 X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);
		 KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
		 PublicKey pubKey =
				    keyFactory.generatePublic(pubKeySpec);
		 */
		 
	/*	try {
			fis = new FileInputStream(file);
		} catch (IOException e) {
			System.out.println("catch 1");
			e.printStackTrace();
		}*/
		/*	try( BufferedReader br =
			           new BufferedReader( new InputStreamReader(input,"UTF-8")))
			   {
			      StringBuilder sb = new StringBuilder();
			      String line;
			      while(( line = br.readLine()) != null ) {
			         sb.append( line );
			         sb.append( '\n' );}
			      System.out.println(sb.toString());
			      }catch(Exception e){System.out.println("catch 2");}
			      */
			      
			
    /*res.setContentType("text/plain");
    PrintWriter out = res.getWriter();
    String cipherSuite = (String) req.getAttribute("javax.servlet.request.cipher_suite");
    out.println("cipher " + cipherSuite);
    X509Certificate[] certs = (X509Certificate[]) req.getAttribute("javax.servlet.request.X509Certificate");
    out.println("certs " + certs);
    if (certs != null) {
      for (int i = 0; i < certs.length; i++) {
        out.println("Client Certificate [" + i + "] = " + certs[i].toString());
      }
    } else {
      if ("https".equals(req.getScheme())) {
        out.println("This was an HTTPS request, " + "but no client certificate is available");
      } else {
        out.println("This was not an HTTPS request, " + "so no client certificate is available");
      }
    }
  }
}*/
/*
public void testRunning() throws Exception {
HttpClient client = new HttpClient();
setupClientSsl();
// test get
HttpMethod get = new GetMethod("https://127.0.0.1:8443/etomcat_x509");
client.executeMethod(get);
byte[] responseBody = get.getResponseBody();
String content = new String(responseBody, "UTF-8");
assertEquals("Servlet get fail", SecuredService.GREETING, content);
// test assess denied
HttpMethod post = new PostMethod("https://127.0.0.1:8443/etomcat_x509");
client.executeMethod(post);
assertEquals("Method security fail get fail", 403, post.getStatusCode());
}
protected String dirname() {
return "x509dir";
}*/