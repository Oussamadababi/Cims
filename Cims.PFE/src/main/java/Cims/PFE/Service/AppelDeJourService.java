package Cims.PFE.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Cims.PFE.Dao.AppelDeJourRepository;
import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Entities.AppelDeJour;
import Cims.PFE.Entities.Personnel;


@Service
public class AppelDeJourService {

	@Autowired
	AppelDeJourRepository AppelDeJourRepository;

	@Autowired
	private PersonnelRepository personnelRepository;

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

}
