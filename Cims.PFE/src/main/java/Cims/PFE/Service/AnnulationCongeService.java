package Cims.PFE.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.AnnulationCongeRepository;
import Cims.PFE.Dao.CongeRepository;
import Cims.PFE.Entities.AnnulationConge;
import Cims.PFE.Entities.Conge;

@Service
public class AnnulationCongeService {
	
	@Autowired
	AnnulationCongeRepository annulationCongeRepository;
	@Autowired
	CongeRepository cRepository;
	
	public AnnulationConge save(AnnulationConge Ac){
		
		return annulationCongeRepository.save(Ac);
	}
	
	public List<AnnulationConge> listAll() {
		List<AnnulationConge> conges = new ArrayList<>();
		annulationCongeRepository.findAll().forEach(conges::add);
		return conges;
	}
	
	public  AnnulationConge ajouterAConge (AnnulationConge c,Long id_conge){
		Conge ca =cRepository.getOne(id_conge);
		c.setConge(ca);
		c.setDatedemande(java.sql.Date.valueOf(LocalDate.now()));
		return save(c);
		
	}
	public void deleteAnnulationConge(long id) {
		annulationCongeRepository.deleteById(id);
	}

	public AnnulationConge getById(Long id) {
		return annulationCongeRepository.findById(id).get();
	}
	
	

}
