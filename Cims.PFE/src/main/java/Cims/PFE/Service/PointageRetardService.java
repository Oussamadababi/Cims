package Cims.PFE.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Dao.PointageRetardRepository;
import Cims.PFE.Entities.Personnel;
import Cims.PFE.Entities.PointageRetard;
import Cims.PFE.Entities.PointageRetardPersonnel;
import Cims.PFE.Entities.Retard;

@Service
public class PointageRetardService {
	@Autowired
	PointageRetardRepository pointageRetardRepository;
	@Autowired
	PersonnelRepository personnelRepository;
	@Autowired
	PersonnelService personnelService;
//	
//	public void ajouteAuListeRetard(long personnel_id, Date date,LocalDateTime   heureEntree) {
//		Personnel p = personnelRepository.findById(personnel_id).get();
//		PointageRetard r = pointageRetardRepository.findByDatedujour(date);
//		if (r == null) {
//			PointageRetard pointageRetard = new PointageRetard();
//			pointageRetard.setDatedujour(date);
//			pointageRetard.setHeureEntree(heureEntree);
//
//			if (pointageRetard.getPersonnels() == null) {
//				List<Personnel> personnels = new ArrayList<>();
//				personnels.add(p);
//				pointageRetard.setPersonnels(personnels);
//				pointageRetard.setHeureEntree(heureEntree);
//
//				pointageRetardRepository.save(pointageRetard);
//			}
//		
//		} else {
//			if (r.getPersonnels() == null) {
//
//				List<Personnel> personnels = new ArrayList<>();
//				personnels.add(p);
//				r.setPersonnels(personnels);
//				pointageRetardRepository.save(r);
//
//			} else {
//				r.getPersonnels().add(p);
//				pointageRetardRepository.save(r);
//
//			}
//		}
//
//		
//	}
//	public void supprimerPersonnelDeLaListe(long personnel_id, Date date)
//	{
//		PointageRetard r = pointageRetardRepository.findByDatedujour(date);
//		int nbPersonnel=r.getPersonnels().size();	
//		for(int i = 0; i < nbPersonnel; i++)
//		{
//			if(r.getPersonnels().get(i).getId_personnel() == personnel_id)
//			{
//				r.getPersonnels().remove(i);
//				pointageRetardRepository.save(r);
//				break;
//			}
//			
//		}
//	}
//	public List<Personnel>listNonRetard(Date date){
//		List <Personnel> p = new ArrayList();
//		List <BigInteger> idp=pointageRetardRepository.listNonRetardParJour(date);
//		
//		for(BigInteger i : idp){
//			Personnel p1 = new Personnel ();
//			p1=personnelRepository.getOne(i.longValue());
//			p.add(p1);
//			
//			
//		}
//		return p;
//		
//		
//	}
//	public List<Personnel>listRetardParJour(Date date){
//		List <Personnel> p = new ArrayList();
//		List <BigInteger> idp=pointageRetardRepository.listRetardParJour(date);
//		
//		for(BigInteger i : idp){
//			Personnel p1 = new Personnel ();
//			p1=personnelRepository.getOne(i.longValue());
//			p.add(p1);
//			
//			
//		}
//		return p;
//		
//		
//	}
//	
//	public void calculerRetardPersonnel()
//	{
//		List<Personnel> ListPersonnels=personnelService.listAll();
//		List<Timestamp> ListeHeure= new ArrayList<Timestamp>();
//		
//		for(Personnel p : ListPersonnels){
//			int nbrMinuteRetard =0;
//		
//			ListeHeure=pointageRetardRepository.ListeDesHeuresRetardParPersonnelId(p.getId_personnel());
//			for(Timestamp Time : ListeHeure)
//			{
//				int Minute=Time.getMinutes();
//				int Heure=Time.getHours();
//			
//				if(Heure<12){
//				 nbrMinuteRetard=nbrMinuteRetard+((Heure-8)*60)+Minute-15;
//				 System.out.println("hethaa l sbeh"+nbrMinuteRetard);
//				}
//				else if(12<<Heure<17) {
//				  nbrMinuteRetard=nbrMinuteRetard+((Heure-13)*60)+Minute-15;
//				  System.out.println("hethaa laachya"+nbrMinuteRetard);
//				}
//				else
//					nbrMinuteRetard=0;
//				
//				
//			}
//			p.setNbrMinuteRetard(nbrMinuteRetard);
//			personnelRepository.save(p);
//			
//		}
//		
//		
//		
//	}
///*	public List<BigInteger> listRetardParJour(Date date)
//	{
//		return pointageRetardRepository.listRetardParJour(date);
//	}*/
////	public List<Retard> listRetard(long idpersonnel)
////	{
////		List<Retard> Retards = new ArrayList<>();
////		Personnel p= personnelRepository.getOne(idpersonnel);
////		List<Timestamp> ListeHeure= pointageRetardRepository.ListeDesHeuresRetardParPersonnelId(idpersonnel);
////		Retard r = new Retard();
////		for(Timestamp Time : ListeHeure)
////		{
////			r.setHeureEntree(Time);	
////			r.setNom(p.getNom());
////			r.setPrenom(p.getPrenom());
////			r.setNbrMinuteRetard(p.getNbrMinuteRetard());
////			Retards.add(r);
////			return Retards;
////		}
////		return Retards;
////
////	}

//public List<Retard> list()
//{
//	
//
//	List<Retard> Retards = new ArrayList<>();
//	List<PointageRetard>pointageRetard =	pointageRetardRepository.findAll();
//	for(PointageRetard r : pointageRetard)
//	{
//		Retard re = new Retard();
//		re.setHeureEntree(r.getHeureEntree());
//		List<Personnel> pers=r.getPersonnels();
//		for(Personnel p : pers)
//		{
//			re.setNom(p.getNom());
//			re.setPrenom(p.getPrenom());
//			re.setNbrMinuteRetard(p.getNbrMinuteRetard());
//			Retards.add(re);
//		}
//	}
//	return Retards;
//}
}
