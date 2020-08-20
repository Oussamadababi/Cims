package Cims.PFE.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.DepartementRepository;
import Cims.PFE.Entities.Structure;

@Service
public class DepartementService {
	@Autowired
	private DepartementRepository repo;
	
	public List<Structure> listAll(){
		List<Structure> dept = new ArrayList<>();
		repo.findAll().forEach(dept::add);
		return dept;
	}
	public Structure save(Structure d) {
		return repo.save(d);
	}
	public Structure update(Long id,Structure d){
		d.setId_dept(id);
		return repo.findById(id).get();
	}
	public Structure getById(Long id) {
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
