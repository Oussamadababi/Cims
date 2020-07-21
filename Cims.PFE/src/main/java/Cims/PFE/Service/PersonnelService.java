package Cims.PFE.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Entities.Personnel;


@Service
public class PersonnelService {
	
	@Autowired
	private PersonnelRepository personnelRepository;
	
	public List<Personnel> listAll(){
		List<Personnel> personnels = new ArrayList<>();
		personnelRepository.findAll().forEach(personnels::add);
		return personnelRepository.findAll();
	}
	
	public Personnel save(Personnel p) {
		p.setSoldeRepos(0);
		p.setSoldeExceptionnel(0);
		return personnelRepository.save(p);
	}


	
	public Personnel update(Long id, Personnel p){
		p.setId_personnel(id);
		return personnelRepository.findById(id).get();
	}
	public Personnel getById(Long id) {
		return personnelRepository.findById(id).get();
	}
	public boolean delete(Long id){
		personnelRepository.deleteById(id);
		if(personnelRepository.existsById(id)==false)
		{
			return true;
		}
			return false;
		
	}
	public void updateSoldeexceptionnel(int matricule,int soldeExceptionnel)
	{
		Personnel p=personnelRepository.findByMatricule(matricule);
		p.setSoldeExceptionnel(soldeExceptionnel);
		personnelRepository.save(p);
	}
	/*Ajouter au solde repos chaque 6 jrs 0.5*/
//	@Scheduled(cron = "1 0 0 1 * ?")
//	@Scheduled(fixedRate = 5000L) 518 400
	public void updateAutoSoldeRepos()
	{
		List<Personnel> Listepersonnel = personnelRepository.findAll();
		for(Personnel Personnel1 : Listepersonnel)
		{
			double soldeRepos1 =Personnel1.getSoldeRepos()+0.5;
			Personnel1.setSoldeRepos(soldeRepos1);
			personnelRepository.save(Personnel1);
			
			
		}
		
	}
	
}

