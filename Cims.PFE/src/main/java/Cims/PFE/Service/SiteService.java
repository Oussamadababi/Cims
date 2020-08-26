package Cims.PFE.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.SiteRepository;
import Cims.PFE.Entities.Affectation;

@Service
public class SiteService {
	@Autowired
	private SiteRepository siteRepository;
	
	public List<Affectation> listAll(){
		List<Affectation> sites = new ArrayList<>();
		siteRepository.findAll().forEach(sites::add);
		return sites;
	}
	public Affectation save(Affectation s) {
		return siteRepository.save(s);
	}
	public Affectation update(Long id,Affectation s){
		s.setId_affectation(id);
		return siteRepository.findById(id).get();
	}
	public Affectation getById(Long id) {
		return siteRepository.findById(id).get();
	}
	public boolean delete(Long id){
		siteRepository.deleteById(id);
		if(siteRepository.existsById(id)==false) {
			return true;
		}
		return false;
	}

	public List<Object> attributsparaff(Long id_aff){
		
		return siteRepository.getAttributForAffectation(id_aff);
	}

}
