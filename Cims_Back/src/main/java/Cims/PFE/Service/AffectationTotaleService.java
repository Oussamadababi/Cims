package Cims.PFE.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.AffectationTotaleRepository;
import Cims.PFE.Entities.AffectationTotale;

@Service
public class AffectationTotaleService {
	@Autowired
	private AffectationTotaleRepository repo;

	public List<AffectationTotale> listAll(){
		List<AffectationTotale> affect = new ArrayList<>();
		repo.findAll().forEach(affect::add);
		return affect;
	}
	public AffectationTotale save(AffectationTotale t) {
		return repo.save(t);
	}
	public AffectationTotale update(Long id,AffectationTotale t){
		t.setIdAffectT(id);
		return repo.findById(id).get();
	}
	public AffectationTotale getById(Long id) {
		return repo.findById(id).get();
	}
	public boolean delete(Long id){
		repo.deleteById(id);
		if(repo.existsById(id)==false) {
			return true;
		}else return false;
	}

}
