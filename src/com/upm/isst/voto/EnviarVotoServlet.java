package com.upm.isst.voto;

import java.io.IOException;

import javax.servlet.http.*;
import javax.servlet.*;


public class EnviarVotoServlet extends HttpServlet{
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			
			String [] codigosPoliticos = req.getParameterValues("eleccion");
			//System.out.println(codigosPoliticos[0].length());
			//System.out.println(codigosPoliticos[1].length());
			//System.out.println(codigosPoliticos[2].length());
			
			//Cifrarlos clave 
			//Enviar a ellos (o copiando codigo aqui o con url google app engine)
			//Generar pdf
			
			
			
			
		}
}
/*import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
public class HolaMundoPDF
{
   public static void main(String[] a3d) throws FileNotFoundException, DocumentException
   {
      FileOutputStream archivo = new FileOutputStream("C:\\hola.pdf");
      Document documento = new Document();
      PdfWriter.getInstance(documento, archivo);
      documento.open();
      documento.add(new Paragraph("Hola Mundo!"));
      documento.add(new Paragraph("SoloInformaticaYAlgoMas.blogspot.com"));
      documento.close();
   }
}*/