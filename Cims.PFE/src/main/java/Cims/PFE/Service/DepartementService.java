package Cims.PFE.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.DepartementRepository;
import Cims.PFE.Entities.Departement;

@Service
public class DepartementService {
	@Autowired
	private DepartementRepository repo;
	
	public List<Departement> listAll(){
		List<Departement> dept = new ArrayList<>();
		repo.findAll().forEach(dept::add);
		return dept;
	}
	public Departement save(Departement d) {
		return repo.save(d);
	}
	public Departement update(Long id,Departement d){
		d.setId_dept(id);
		return repo.findById(id).get();
	}
	public Departement getById(Long id) {
		return repo.findById(id).get();
	}
	public boolean delete(Long id){
		repo.deleteById(id);
		if(repo.existsById(id)==false) {
			return true;
		}
		return false;
	}

}
