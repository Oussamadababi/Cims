package Cims.PFE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cims.PFE.Dao.DepartementRepository;
import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Entities.Structure;
import Cims.PFE.Entities.Personnel;
import Cims.PFE.Service.DepartementService;
import Cims.PFE.payload.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DepartementController {
	@Autowired
	private DepartementService DepartementService;

	@Autowired
	private PersonnelRepository personnelRepository;
	@Autowired
	private DepartementRepository deptRepository;

	@GetMapping(value="/listDepartements")
	public List<Structure> listDepartements(){
		return DepartementService.listAll();
	}
	
	@PostMapping(value="/addDepartement")
	public ResponseEntity<?> save(@RequestBody Structure d) {
		List<Structure> list=deptRepository.getDept(d.getNom_dept());
		if(list.isEmpty()) {
			 DepartementService.save(d);
				return ResponseEntity.ok(new MessageResponse("Département ajouter"));
		}else return ResponseEntity.badRequest().body(new MessageResponse("Departement existe déja !!!"));
		
	}
	
	@PutMapping(value="/updateDepartement/{id}")
	public  ResponseEntity<?> update(@PathVariable(name="id") Long id,@RequestBody Structure d){
		Structure dept=DepartementService.getById(id);
		List<Structure> list=deptRepository.getDept(d.getNom_dept());
		if(list.isEmpty()) {
			dept.setNom_dept(d.getNom_dept());
			Structure updatedDepartement=DepartementService.save(dept);
			return ResponseEntity.ok(new MessageResponse("Département modifier"));
		}else return ResponseEntity.badRequest().body(new MessageResponse("Departement existe déja !!!"));
		
	}
	
	@GetMapping(value="/getDepartement/{id}")
	public Structure get(@PathVariable(name="id") Long id) {
		return DepartementService.getById(id);
	}
	
	@DeleteMapping(value="/deleteDepartement/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
		List<Personnel> list =personnelRepository.getDept(id);
		if(list.isEmpty()) {
			if(DepartementService.delete(id)) {
				return ResponseEntity.ok(new MessageResponse("Département supprimer"));
				}
		}
		else return ResponseEntity.badRequest().body(new MessageResponse("Erreur: Vous devez supprimer les personnels avant de supprimer"));
		
		return ResponseEntity.badRequest().body(new MessageResponse("Erreur: Échec lors de suppression"));	
	}
	
}
