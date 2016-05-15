package com.upm.isst.voto;

import java.io.BufferedInputStream;
import java.io.BufferedReader; 
import java.io.DataInputStream;
import java.io.FileInputStream;  
import java.io.IOException;   
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
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
import java.security.Certificate;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
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
import javax.xml.bind.DatatypeConverter;

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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.io.pem.PemReader;

import com.google.appengine.api.blobstore.*;
import com.upm.isst.voto.dao.CEEDAO;
import com.upm.isst.voto.dao.CEEDAOImpl;
import com.upm.isst.voto.dao.CensoDAO;
import com.upm.isst.voto.dao.CensoDAOImpl;
import com.upm.isst.voto.model.CEEModel;
import com.upm.isst.voto.model.CensoModel;

@SuppressWarnings("serial")
public class comprobarCert extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Map<String, List<BlobKey>> blobs = BlobstoreServiceFactory.getBlobstoreService().getUploads(req);
		List<BlobKey> blobKeys = blobs.get("certi");
	if (blobKeys == null || blobKeys.isEmpty() || blobKeys.get(0) == null) {
			resp.getWriter().println("err");
	} else {
		
		BlobKey blobKey = new BlobKey(blobKeys.get(0).getKeyString());
		BlobstoreInputStream is =new BlobstoreInputStream(blobKey);	
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line = null;
		PrintWriter s = resp.getWriter();
		StringBuilder a = new StringBuilder();
		String cert = null;
		while((line = reader.readLine()) != null) {
			a.append(line);
		}
		reader.close();
		cert = a.toString();

		String modCert = cert.substring(27, cert.length()-25);
		byte [] decodeBase64 = Base64.decode(modCert);
		CertificateFactory certFactory = null;
		try {
			certFactory = CertificateFactory.getInstance("X.509");
		} catch (CertificateException e) {
			e.printStackTrace();
		}
		InputStream in = new ByteArrayInputStream(decodeBase64);
		X509Certificate certificate = null;
		try {
			certificate = (X509Certificate)certFactory.generateCertificate(in);
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String data = certificate.toString();
		//Extraer los datos a comprobar del certificado
		//Comprobar los datos de la entidad expedidora del certificado
		String orgExp = certificate.getIssuerDN().toString();
		String [] orgExpData = orgExp.split(",");
		String msj = null;
		String msjSucc = null;
		if(orgExpData[0].equals("CN=Grupo1")){
			//Comprobamos los datos personales y los del censo
			String [] subject = getSubject(data);
			String user = subject[3];
			user = user.substring(1, user.length()-2);
			Long id = Long.parseLong(user);
			CensoDAO dao = CensoDAOImpl.getInstance();
			List<CensoModel> votante = dao.readDNI(id);
			if(votante.size()>0){
				CensoModel persona = votante.get(0);
				/*Datos asociados a ese DNI*/
				String nombreBBDD = persona.getNombre();
				String apellido1BBDD = persona.getApellido1();
				String apellido2BBDD = persona.getApellido2();
				String provinciaBBDD = persona.getProvincia();
				
				String nombre = subject[0].toLowerCase();
				String apellido1 = subject[1].toLowerCase();
				String apellido2 = subject[2].toLowerCase();
				String provincia = getProvincia(data);
				//Obtenemos los datos de la persona del certificado
				if(nombre.equals(nombreBBDD) && apellido1.equals(apellido1BBDD) && 
						apellido2.equals(apellido2BBDD) && provincia.equals(provinciaBBDD)){
					//Comprobamos que el cert no haya sido validado anteriormente
					CEEDAO dao1 = CEEDAOImpl.getInstance();
					if(dao1.readDNI(id) == null){
						persona.setCert(true);
						dao.update(persona);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						msj = "Certificado validado correctamente";

					} else {
						msj = "Su certificado ya ha sido validado anteriormente";
					}
				} else {
					msj = "Los datos del certificado no estan asociados a ningun persona del Censo Electoral";

				} 
			} else {
				msj = "No existen datos asociados a la persona en el Censo Electoral";
			}
			
		} else {
			msj = "El certificado no es valido. Expida un certificado valido aqui http://1-dot-evoto-2016.appspot.com/ca";
		}
	    resp.sendRedirect("/votoelectronicoetsit?msj="+msj);
	}
		
	}
	private String[] getSubject(String data){
		int inicio = data.indexOf("EMAILADDRESS");
		int fin = data.indexOf("Signature");
		data = data.substring(inicio, fin);
		String [] subject = data.split(",");
		String nombre = subject[1];
		inicio = nombre.indexOf("=");
		nombre = nombre.substring(inicio+1);
		String [] usuario = nombre.split(" ");
		return usuario;
	}
	private String getProvincia(String data){
		String provincia = "";
		int inicio = data.indexOf("EMAILADDRESS");
		int fin = data.indexOf("Signature");
		data = data.substring(inicio, fin);
		String [] subject = data.split(",");
		provincia = subject[2];
		provincia = provincia.substring(3);
		return provincia.toLowerCase();
	}
	
	
}