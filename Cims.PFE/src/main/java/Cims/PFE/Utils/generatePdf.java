package Cims.PFE.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Cims.PFE.Entities.Conge;
import Cims.PFE.Entities.Deplacement;
import Cims.PFE.Entities.Hebergement;
import Cims.PFE.Entities.MoyenDeTransport;
import Cims.PFE.Entities.OrdreAffectationP;
import Cims.PFE.Entities.OrdreMission;
import Cims.PFE.Entities.Transport;


public class generatePdf {
	
	public static ByteArrayInputStream listConge(List<Conge> o) throws MalformedURLException, IOException {
		
		Document document = new Document();
		//document.setMargins(60, 60, 60, 60);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			PdfWriter.getInstance(document, out);
			document.open();
			Font f = new Font();
	        f.setStyle(Font.BOLD);
	        f.setSize(15);
			Paragraph p = new Paragraph();
			 p.setFont(f);
			  p.setAlignment(Element.ALIGN_CENTER);
			  Image img = Image.getInstance("cims-logo.png");
		         img.scaleAbsoluteWidth(60);
		         img.scaleAbsoluteHeight(30);
		         img.setAlignment(Element.ALIGN_LEFT);
		         p.add(img);
        p.add("République tunisienne \n Ministère de la santé \n Centre de l'informatique \n\n\n\n\n");
        p.add("Liste Conge \n\n\n\n");
			  PdfPTable headerTable = new PdfPTable(7);
			  document.add(p);
			  Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
			   PdfPCell name = new PdfPCell(new Paragraph("NumConge", tableHeader));
			    name.setBorderColor(BaseColor.BLACK);
			    name.setPaddingLeft(2);
			    name.setHorizontalAlignment(Element.ALIGN_CENTER);
			    name.setVerticalAlignment(Element.ALIGN_CENTER);
			    name.setBackgroundColor(BaseColor.DARK_GRAY);
			    name.setExtraParagraphSpace(10f);
			    headerTable.addCell(name);
			    PdfPCell Type = new PdfPCell(new Paragraph("TypeConge", tableHeader));
			    Type.setBorderColor(BaseColor.BLACK);
			    Type.setPaddingLeft(0);
			    Type.setHorizontalAlignment(Element.ALIGN_CENTER);
			    Type.setVerticalAlignment(Element.ALIGN_CENTER);
			    Type.setBackgroundColor(BaseColor.DARK_GRAY);
			    Type.setExtraParagraphSpace(10f);
			    headerTable.addCell(Type);
			  
			  PdfPCell dateDebut = new PdfPCell(new Paragraph("DateDebut" , tableHeader));
			  dateDebut.setBorderColor(BaseColor.BLACK);
			  dateDebut.setPaddingLeft(0);
			  dateDebut.setHorizontalAlignment(Element.ALIGN_CENTER);
			  dateDebut.setVerticalAlignment(Element.ALIGN_CENTER);
			  dateDebut.setBackgroundColor(BaseColor.DARK_GRAY);
			  dateDebut.setExtraParagraphSpace(10f);
			  headerTable.addCell(dateDebut);
		        
		         
				  PdfPCell datefin = new PdfPCell(new Paragraph("Datefin" , tableHeader));
				  datefin.setBorderColor(BaseColor.BLACK);
				  datefin.setPaddingLeft(0);
				  datefin.setHorizontalAlignment(Element.ALIGN_CENTER);
				  datefin.setVerticalAlignment(Element.ALIGN_CENTER);
				  datefin.setBackgroundColor(BaseColor.DARK_GRAY);
				  datefin.setExtraParagraphSpace(10f);
				  headerTable.addCell(datefin);
				  PdfPCell nombreJour = new PdfPCell(new Paragraph("NombreJour" , tableHeader));
				  nombreJour.setBorderColor(BaseColor.BLACK);
				  nombreJour.setPaddingLeft(0);
				  nombreJour.setHorizontalAlignment(Element.ALIGN_CENTER);
				  nombreJour.setVerticalAlignment(Element.ALIGN_CENTER);
				  nombreJour.setBackgroundColor(BaseColor.DARK_GRAY);
				  nombreJour.setExtraParagraphSpace(10f);
				  headerTable.addCell(nombreJour);
				  PdfPCell nombreMois = new PdfPCell(new Paragraph("NombreMois" , tableHeader));
				  nombreMois.setBorderColor(BaseColor.BLACK);
				  nombreMois.setPaddingLeft(0);
				  nombreMois.setHorizontalAlignment(Element.ALIGN_CENTER);
				  nombreMois.setVerticalAlignment(Element.ALIGN_CENTER);
				  nombreMois.setBackgroundColor(BaseColor.DARK_GRAY);
				  nombreMois.setExtraParagraphSpace(10f);
				  headerTable.addCell(nombreMois);
				  PdfPCell nomPersonnel = new PdfPCell(new Paragraph("NomPersonnel" , tableHeader));
				  nomPersonnel.setBorderColor(BaseColor.BLACK);
				  nomPersonnel.setPaddingLeft(0);
				  nomPersonnel.setHorizontalAlignment(Element.ALIGN_CENTER);
				  nomPersonnel.setVerticalAlignment(Element.ALIGN_CENTER);
				  nomPersonnel.setBackgroundColor(BaseColor.DARK_GRAY);
				  nomPersonnel.setExtraParagraphSpace(10f);
				  headerTable.addCell(nomPersonnel);
				  document.add(headerTable);
				  PdfPTable headerTable2 = new PdfPTable(7);
				  for(Conge c : o)
				  {
					 
					  PdfPCell nameval = new PdfPCell(new Paragraph(c.getId().toString(), tableHeader));
					  nameval.setBorderColor(BaseColor.BLACK);
					  nameval.setPaddingLeft(2);
					  nameval.setHorizontalAlignment(Element.ALIGN_CENTER);
					  nameval.setVerticalAlignment(Element.ALIGN_CENTER);
					  nameval.setBackgroundColor(BaseColor.WHITE);
					  nameval.setExtraParagraphSpace(5f);
				 	   headerTable2.addCell(nameval);
				 	  PdfPCell typeCongeVal = new PdfPCell(new Paragraph(c.getTypedeconge().toString(), tableHeader));
				 	 typeCongeVal.setBorderColor(BaseColor.BLACK);
				 	typeCongeVal.setPaddingLeft(0);
				 	typeCongeVal.setHorizontalAlignment(Element.ALIGN_CENTER);
				 	typeCongeVal.setVerticalAlignment(Element.ALIGN_CENTER);
				 	typeCongeVal.setBackgroundColor(BaseColor.WHITE);
				 	typeCongeVal.setExtraParagraphSpace(5f);
				 	   headerTable2.addCell(typeCongeVal);
				 	  PdfPCell dateDebutval = new PdfPCell(new Paragraph(c.getDatedebut().toString(), tableHeader));
				 	 dateDebutval.setBorderColor(BaseColor.BLACK);
				 	dateDebutval.setPaddingLeft(0);
				 	dateDebutval.setHorizontalAlignment(Element.ALIGN_CENTER);
				 	dateDebutval.setVerticalAlignment(Element.ALIGN_CENTER);
				 	dateDebutval.setBackgroundColor(BaseColor.WHITE);
				 	dateDebutval.setExtraParagraphSpace(5f);
					 	   headerTable2.addCell(dateDebutval);
					 	  PdfPCell dateFinval = new PdfPCell(new Paragraph(c.getDatefin().toString(), tableHeader));
					 	 dateFinval.setBorderColor(BaseColor.BLACK);
					 	dateFinval.setPaddingLeft(0);
					 	dateFinval.setHorizontalAlignment(Element.ALIGN_CENTER);
					 	dateFinval.setVerticalAlignment(Element.ALIGN_CENTER);
					 	dateFinval.setBackgroundColor(BaseColor.WHITE);
					 	dateFinval.setExtraParagraphSpace(5f);
							 	   headerTable2.addCell(dateFinval);
							 	  PdfPCell nombreJourVal= new PdfPCell(new Paragraph(String.valueOf(c.getNumDeJour()) , tableHeader));
							 	 nombreJourVal.setBorderColor(BaseColor.BLACK);
							 	nombreJourVal.setPaddingLeft(0);
							 	nombreJourVal.setHorizontalAlignment(Element.ALIGN_CENTER);
							 	nombreJourVal.setVerticalAlignment(Element.ALIGN_CENTER);
							 	nombreJourVal.setBackgroundColor(BaseColor.WHITE);
							 	nombreJourVal.setExtraParagraphSpace(10f);
								  headerTable2.addCell(nombreJourVal);
								  PdfPCell nombreMoisVal = new PdfPCell(new Paragraph(String.valueOf(c.getNumDeMois()) , tableHeader));
								  nombreMoisVal.setBorderColor(BaseColor.BLACK);
								  nombreMoisVal.setPaddingLeft(0);
								  nombreMoisVal.setHorizontalAlignment(Element.ALIGN_CENTER);
								  nombreMoisVal.setVerticalAlignment(Element.ALIGN_CENTER);
								  nombreMoisVal.setBackgroundColor(BaseColor.WHITE);
								  nombreMoisVal.setExtraParagraphSpace(10f);
								  headerTable2.addCell(nombreMoisVal);
								  PdfPCell nomPersonnelVal = new PdfPCell(new Paragraph(c.getP().getNom()+" "+c.getP().getPrenom(), tableHeader));
								  nomPersonnelVal.setBorderColor(BaseColor.BLACK);
								  nomPersonnelVal.setPaddingLeft(0);
								  nomPersonnelVal.setHorizontalAlignment(Element.ALIGN_CENTER);
								  nomPersonnelVal.setVerticalAlignment(Element.ALIGN_CENTER);
								  nomPersonnelVal.setBackgroundColor(BaseColor.WHITE);
								  nomPersonnelVal.setExtraParagraphSpace(10f);
								  headerTable2.addCell(nomPersonnelVal);
				  }
			         document.add(headerTable2);
			 document.close();
		}
	 catch (DocumentException ex) {

		Logger.getLogger(generatePdf.class.getName()).log(Level.SEVERE, null, ex);
	}

		return new ByteArrayInputStream(out.toByteArray());
	}
	
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
