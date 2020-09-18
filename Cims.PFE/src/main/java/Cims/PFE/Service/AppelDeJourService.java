package Cims.PFE.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.AppelDeJourRepository;
import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Dao.Pesonnel_Absent_SJRepository;
import Cims.PFE.Entities.AppelDeJour;
import Cims.PFE.Entities.Personnel;
import Cims.PFE.Entities.Pesonnel_Absent_SJ;


@Service
public class AppelDeJourService {

	@Autowired
	AppelDeJourRepository AppelDeJourRepository;

	@Autowired
	private PersonnelRepository personnelRepository;
	
//	@Autowired
//    private Pesonnel_Absent_SJRepository PASJ;

	// public void save(AppelDeJour a){
	//
	// List<Personnel> Listepersonnel = personnelRepository.findAll();
	// for(Personnel Personnel1 : Listepersonnel)
	// {
	// a.setDatedujour(java.sql.Date.valueOf(LocalDate.now()));
	// a.setEtat("P");
	//// a.setPersonnels(Personnel1.);
	//
	// }
	// AppelDeJourRepository.save(a);
	//
	// }

	public void ajouteAuListeAbsence(long personnel_id, Date date) {
		Personnel p = personnelRepository.findById(personnel_id).get();
		AppelDeJour a = AppelDeJourRepository.findByDatedujour(date);
		if (a == null) {
			AppelDeJour newAppel = new AppelDeJour();
			newAppel.setDatedujour(date);

			if (newAppel.getPersonnels() == null) {
				List<Personnel> personnels = new ArrayList<>();
				personnels.add(p);
				newAppel.setPersonnels(personnels);
				newAppel.setEtat("Sansjusitf");
				AppelDeJourRepository.save(newAppel);
			}
			// else {
			// newAppel.getPersonnels().add(p);
			//
			//
			// }
		} else {
			if (a.getPersonnels() == null) {

				List<Personnel> personnels = new ArrayList<>();
				personnels.add(p);
				a.setPersonnels(personnels);
				AppelDeJourRepository.save(a);

			} else {
				a.getPersonnels().add(p);
				AppelDeJourRepository.save(a);

			}
		}

		// return a.getPersonnels();
	}
	
	public void supprimerPersonnelDeLaListe(long personnel_id, Date date)
	{
		AppelDeJour a = AppelDeJourRepository.findByDatedujour(date);
		int nbPersonnel=a.getPersonnels().size();	
		for(int i = 0; i < nbPersonnel; i++)
		{
			if(a.getPersonnels().get(i).getId_personnel() == personnel_id)
			{
				a.getPersonnels().remove(i);
				AppelDeJourRepository.save(a);
				break;
			}
			
		}
	}
/*	public List<Pesonnel_Absent_SJ>listAllAbsent(){
		//List <Pesonnel_Absent_SJ> idp=PASJ.ListeAbsenceSansJustifiaction();
		
//		for(Pesonnel_Absent_SJ i : idp){
//			Personnel p1 = new Personnel ();
//			p1=personnelRepository.getOne(i.getId_personnel());
//			i.setMatricule(p1.getMatricule());
//			i.setNom(p1.getNom());
//			i.setPrenom(p1.getPrenom());
//			i.setNom_AR(p1.getNom_AR());
//			i.setPrenom_AR(p1.getPrenom_AR());
//			
//			
//		}
		return idp;
		
		
	}*/
	public List<Personnel>listnonAbsent(Date date){
		List <Personnel> p = new ArrayList();
		List <BigInteger> idp=personnelRepository.listNonAbsenceParJour(date);
		
		for(BigInteger i : idp){
			Personnel p1 = new Personnel ();
			p1=personnelRepository.getOne(i.longValue());
			p.add(p1);
			
			
		}
		return p;
		
		
	}

	public List<Object>listAllAbsent(){
		return AppelDeJourRepository.ListeAbsenceSansJustifiaction2();
	}
	

}