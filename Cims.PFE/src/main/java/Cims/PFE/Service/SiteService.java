package Cims.PFE.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.GouvernoratRepository;
import Cims.PFE.Dao.SiteRepository;
import Cims.PFE.Entities.Affectation;
import Cims.PFE.Entities.AffectationGouv;
import Cims.PFE.Entities.Gouvernorat;

@Service
public class SiteService {
	@Autowired
	private SiteRepository siteRepository;
	@Autowired 
	private GouvernoratRepository Gr;
	
	public List<Affectation> listAll(){
		List<Affectation> sites = new ArrayList<>();
		siteRepository.findAll().forEach(sites::add);
		return sites;
	}
	public Affectation save(Affectation s,long id) {
		Gouvernorat Af = new Gouvernorat();
		 Af =Gr.getOne(id);
		s.setGouvernorat(Af);
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

	public AffectationGouv attributsparaff(Long id_aff){
		
		return siteRepository.getAttributForAffectation2(id_aff);
	}

}
