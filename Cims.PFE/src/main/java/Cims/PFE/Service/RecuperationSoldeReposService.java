package Cims.PFE.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.RecuperationSoldeReposRepository;
import Cims.PFE.Entities.RecuperationSoldeRepos;

@Service
public class RecuperationSoldeReposService {
	
	@Autowired
	RecuperationSoldeReposRepository recuperationSoldeReposRepository;
	
public RecuperationSoldeRepos save(RecuperationSoldeRepos Ac){
		
		return recuperationSoldeReposRepository.save(Ac);
	}
	
	public List<RecuperationSoldeRepos> listAll() {
		List<RecuperationSoldeRepos> ListeRecuperationSoldeR = new ArrayList<>();
		recuperationSoldeReposRepository.findAll().forEach(ListeRecuperationSoldeR::add);
		return ListeRecuperationSoldeR;
	}

}
