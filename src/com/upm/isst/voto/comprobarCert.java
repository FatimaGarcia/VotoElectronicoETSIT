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
    X509Certificate[] certs = (X509Certificate[]) req.getAttribute("javax.servlet.request.X509Certificate");
    out.println(req.getAttribute("javax.servlet.request.cipher_suite"));
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
