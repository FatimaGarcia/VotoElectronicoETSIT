package com.upm.isst.voto;

import java.io.FileInputStream; 
import java.io.IOException;   

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.PrintWriter;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class comprobarCert extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,
      IOException {
    res.setContentType("text/plain");
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
}
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