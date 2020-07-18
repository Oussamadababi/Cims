package Cims.PFE.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Cims.PFE.Entities.Deplacement;
import Cims.PFE.Entities.Hebergement;
import Cims.PFE.Entities.MoyenDeTransport;
import Cims.PFE.Entities.OrdreAffectationP;
import Cims.PFE.Entities.OrdreMission;
import Cims.PFE.Entities.Transport;

public class generatePdf {
	
	//creation de forme de  pdf par id d'affectation
	public static ByteArrayInputStream Report(OrdreAffectationP o) throws MalformedURLException, IOException {

		Document document = new Document();
		document.setMargins(60, 60, 60, 60);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfWriter.getInstance(document, out);
			document.open();
			 Font f = new Font();
	            f.setStyle(Font.BOLD);
	            f.setSize(15);
	            
	            Font f2 = new Font();
	            f2.setSize(15);
	            
	            Font f3 = new Font();
	            f3.setStyle(Font.BOLD);
	            f3.setSize(13);
	            
	            Font f4 = new Font();
	            f4.setSize(13);
	            
	            Font f5 = new Font();
	            f5.setStyle(Font.BOLD);
	            f5.setSize(14);
	            
			Paragraph p = new Paragraph();
			 p.setFont(f);
         p.add("République tunisienne \n Ministère de la santé \n Centre de l'informatique \n");
         p.setAlignment(Element.ALIGN_CENTER);
         
			
         Paragraph p4 = new Paragraph();
         p4.setFont(f2);
         p4.add("\n \n \n Au directeur régional de "+o.getAffectationPartielle().getSite().getGouvernorat().getNomGouv()+"  \n \n");
         p4.setAlignment(Element.ALIGN_CENTER);
         
         Paragraph p5 = new Paragraph();
         p5.setFont(f3);
         p5.add(" Sujet : ");
         p5.setFont(f4);
         p5.setLeading(35);
         p5.add(o.getAffectationPartielle().getSujet()+"\n"
         		+ " Nous avons l'honneur de vous informer que le Centre d'Informatique du Ministère de la Santé a chargé M./Mme ");
         p5.setFont(f3);
         p5.add(o.getAffectationPartielle().getPersonnel().getNom().toUpperCase()+" "+o.getAffectationPartielle().getPersonnel().getPrenom().toUpperCase());
         p5.setFont(f4);
         p5.add(" en affectation partielle à   ");
         p5.setFont(f3);
         p5.add(o.getAffectationPartielle().getSite().getNomSite());
         p5.setFont(f4);
         p5.add(" pour le suivi des applications informatiques de votre organisation chaque ");
         p5.setFont(f3);
         for(int i=0;i<o.getAffectationPartielle().getJour().size();i++) {
        	 p5.add(o.getAffectationPartielle().getJour().get(i)+", ");
         }
        
         p5.setFont(f4);
         p5.add(" à partir de  ");
         p5.setFont(f3);
         p5.add(o.getAffectationPartielle().getDateDebut()+"");
         p5.add(" au "+o.getAffectationPartielle().getDatefin()+".\n");
         p5.setAlignment(Element.ALIGN_LEFT);
         
         Paragraph p6 = new Paragraph();
         p6.setFont(f5);
         p6.add(" \n \n \n \n  Signature  ");
         p6.setAlignment(Element.ALIGN_CENTER);
         
         Image img = Image.getInstance("C:\\Users\\Admin\\Desktop\\Back\\v3\\spring-boot-spring-security-jwt-authentication-master\\cims-logo.png");
         img.scaleAbsoluteWidth(60);
         img.scaleAbsoluteHeight(30);
         img.setAlignment(Element.ALIGN_LEFT);
         PdfPCell leftCell = new PdfPCell();
         leftCell.addElement(img);
         leftCell.setBorder(Rectangle.NO_BORDER);

         PdfPTable headerTable = new PdfPTable(2);
         headerTable.setWidthPercentage(100f);
         headerTable.addCell(leftCell);

         PdfPCell rightCell = new PdfPCell();
         rightCell .addElement(p);

         rightCell .setBorder(Rectangle.NO_BORDER);
         rightCell .setPaddingLeft(-390);
         headerTable.addCell(rightCell);
         PdfPCell cell = new PdfPCell();
         cell.setBorder(Rectangle.NO_BORDER);
         cell.addElement(headerTable);
         
        document.add(headerTable);	
			document.add(p4);
			document.add(p5);
			document.add(p6);
			
			document.close();

		} catch (DocumentException ex) {

			Logger.getLogger(generatePdf.class.getName()).log(Level.SEVERE, null, ex);
		}

		return new ByteArrayInputStream(out.toByteArray());
	}
	
	
	// pdf mission
	public static ByteArrayInputStream ReportMission(OrdreMission m) throws MalformedURLException, IOException {

		Document document = new Document();
		document.setMargins(60, 60, 60, 60);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

		
			PdfWriter.getInstance(document, out);
			document.open();
			 Font f = new Font();
	            f.setStyle(Font.BOLD);
	            f.setSize(15);
	            
	            Font f2 = new Font();
	            f2.setSize(15);
	            
	            Font f3 = new Font();
	            f3.setStyle(Font.BOLD);
	            f3.setSize(13);
	            
	            Font f4 = new Font();
	            f4.setSize(13);
	            
	            Font f5 = new Font();
	            f5.setStyle(Font.BOLD);
	            f5.setSize(14);
	            
			Paragraph p = new Paragraph();
			 p.setFont(f);
      p.add("République tunisienne \n Ministère de la santé \n Centre de l'informatique \n");
      p.setAlignment(Element.ALIGN_CENTER);
      
  
			
      Paragraph p4 = new Paragraph();
      p4.setFont(f2);
      p4.add("\n \n \n Mission à  "+m.getMission().getAffectationPartielle().getSite().getGouvernorat().getNomGouv()+"  \n \n");
      p4.setAlignment(Element.ALIGN_CENTER);
      
      Paragraph p5 = new Paragraph();
      p5.setFont(f3);
      p5.add(" Sujet : ");
      p5.setFont(f4);
      p5.setLeading(35);
      p5.add(m.getMission().getAffectationPartielle().getSujet()+"\n"
      		+ " Le Centre d'Informatique du Ministère de la Santé a chargé M./Mme ");
      p5.setFont(f3);
      p5.add(m.getMission().getAffectationPartielle().getPersonnel().getNom().toUpperCase()+" "+m.getMission().getAffectationPartielle().getPersonnel().getPrenom().toUpperCase());
      p5.setFont(f4);
      p5.add(" en mission  pour le suivi des applications informatiques  ");
      p5.add(" de ");
      p5.setFont(f3);
      p5.add(m.getMission().getAffectationPartielle().getSite().getNomSite());
     
      p5.setFont(f4);
      p5.add(" le  ");
      p5.setFont(f3);
      p5.add(m.getMission().getDate()+".");
      p5.setFont(f4);
      p5.setAlignment(Element.ALIGN_LEFT);
      
      Paragraph p7 = new Paragraph();
      p7.setFont(f4);
      p7.setLeading(35);
      p7.add(" Heure de depart: ");
      p7.setFont(f3);
      p7.add(m.getMission().getHeureDepart());
      p7.setFont(f4);
      p7.add("\n Heure d'arrivée: ");
      p7.setFont(f3);
      p7.add(m.getMission().getHeureArrivee());
      
      // TRANSPORT
      p7.setFont(f4);
      p7.add("\n Frais de transport à la charge de: ");
      p7.setFont(f3);
      if(m.getTransport()==Transport.CIMS) {
    	  p7.add(" CIMS");
      }else if(m.getTransport()==Transport.MISSIONNAIRE) {
    	  p7.add(" MISSIONNAIRE");
    	  p7.setFont(f4);
          p7.add("\n le moyen de transport : ");
          p7.setFont(f3);
    	  if(m.getMoyenDeTransport()==MoyenDeTransport.PERSONNELLE) {
    		  p7.add(" PERSONNELLE");
    	  }else if(m.getMoyenDeTransport()==MoyenDeTransport.PUBLIC){
    		  p7.add(" PUBLIC");
    	  }
      }
      else if(m.getTransport()==Transport.ORAGANISME_DACCUEIL) {
    	  p7.add("L'ORAGANISME D'ACCUEIL");
      }
      //DEPLACEMENT
      p7.setFont(f4);
      p7.add("\n frais de déplacement (repas) à la charge de: ");
      p7.setFont(f3);
      if(m.getDeplacement()==Deplacement.CIMS) {
    	  p7.add(" CIMS");
      }else if(m.getDeplacement()==Deplacement.MISSIONNAIRE) {
    	  p7.add(" MISSIONNAIRE");
      }
      else if (m.getDeplacement()==Deplacement.ORAGANISME_DACCUEIL) {
    	  p7.add("L'ORAGANISME D'ACCUEIL");
      }
      
      // HEBERGEMENT
      p7.setFont(f4);
      p7.add("\n Frais d’hébergement à la charge de: ");
      p7.setFont(f3);
      if(m.getHebergement()==Hebergement.CIMS) {
    	  p7.add(" CIMS");
      }else if(m.getHebergement()==Hebergement.MISSIONNAIRE) {
    	  p7.add(" MISSIONNAIRE");
      }
      else if(m.getHebergement()==Hebergement.NON) {
    	  p7.add("PAS D'HEBERGEMENT");
      }else if(m.getHebergement()==Hebergement.ORAGANISME_DACCUEIL) {
    	  p7.add("L'ORAGANISME D'ACCUEIL");
      }
      
      Paragraph p6 = new Paragraph();
      p6.setFont(f5);
      p6.add(" \n \n \n \n  Signature  ");
      p6.setAlignment(Element.ALIGN_CENTER);
      
      Image img = Image.getInstance("C:\\Users\\Admin\\Desktop\\Back\\v3\\spring-boot-spring-security-jwt-authentication-master\\cims-logo.png");
      img.scaleAbsoluteWidth(60);
      img.scaleAbsoluteHeight(30);
      img.setAlignment(Element.ALIGN_LEFT);
      PdfPCell leftCell = new PdfPCell();
      leftCell.addElement(img);
      leftCell.setBorder(Rectangle.NO_BORDER);

      PdfPTable headerTable = new PdfPTable(2);
      headerTable.setWidthPercentage(100f);
      headerTable.addCell(leftCell);

      PdfPCell rightCell = new PdfPCell();
      rightCell .addElement(p);

      rightCell .setBorder(Rectangle.NO_BORDER);
      rightCell .setPaddingLeft(-390);
      headerTable.addCell(rightCell);
      PdfPCell cell = new PdfPCell();
      cell.setBorder(Rectangle.NO_BORDER);
      cell.addElement(headerTable);
      
     document.add(headerTable);	
			document.add(p4);
			document.add(p5);
			document.add(p7);
			document.add(p6);
			
			document.close();

		} catch (DocumentException ex) {

			Logger.getLogger(generatePdf.class.getName()).log(Level.SEVERE, null, ex);
		}

		return new ByteArrayInputStream(out.toByteArray());
	}
}
