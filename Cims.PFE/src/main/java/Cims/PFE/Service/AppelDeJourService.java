package Cims.PFE.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void save(AppelDeJour a){
		
		List<Personnel> Listepersonnel = personnelRepository.findAll();
		for(Personnel Personnel1 : Listepersonnel)
		{
			a.setDatedujour(java.sql.Date.valueOf(LocalDate.now()));
			a.setEtat("P");
		//	a.setPersonnels(Personnel1.getId_personnel());
			
		}
	     AppelDeJourRepository.save(a);
		
	}
	
}
