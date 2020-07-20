package Cims.PFE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import Cims.PFE.Dao.GradeRepository;
import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Entities.Grade;
import Cims.PFE.Entities.Personnel;
import Cims.PFE.Service.GradeService;
import Cims.PFE.payload.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class GradeController {
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private PersonnelRepository personnelRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@GetMapping(value="/listGrades")
	public List<Grade> listGrades(){
		return gradeService.listAll();
	}
	
	@PostMapping(value="/addGrade")
	public ResponseEntity<MessageResponse> save(@RequestBody Grade p) {
		List<Grade> list=gradeRepository.getGrade(p.getNom_grade());
		if(list.isEmpty()) {
			gradeService.save(p);
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Grade ajouter"));
		}else return ResponseEntity.badRequest().body(new MessageResponse("Grade existe déja !!!"));
		
	}
	
	@PutMapping(value="/updateGrade/{id}")
	public ResponseEntity<?> updateGrade(@PathVariable("id") Long id, @RequestBody Grade grade) {
	    Grade g=gradeService.getById(id);
		List<Grade> list=gradeRepository.getGrade(grade.getNom_grade());
		if(list.isEmpty()) {
			 g.setNom_grade(grade.getNom_grade());
			    final Grade updatedGrade = gradeService.save(g);
			    return ResponseEntity.ok(new MessageResponse("Grade modifier"));
		}else return ResponseEntity.badRequest().body(new MessageResponse("Grade existe déja !!!"));
	   
	}
	
	@GetMapping(value="/getGrade/{id}")
	public Grade get(@PathVariable(name="id") Long id) {
		return gradeService.getById(id);
	}
	
	@DeleteMapping(value="/deleteGrade/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
		List<Personnel> list=personnelRepository.getGrade(id);
		if(list.isEmpty()) {
			if(gradeService.delete(id)) {
				 return ResponseEntity.ok(new MessageResponse("Grade supprimer"));
				}	
		}else return ResponseEntity.badRequest().body(new MessageResponse("Erreur: Vous devez supprimer les personnels avant de supprimer"));
		
	return ResponseEntity.badRequest().body(new MessageResponse("Erreur: Échec lors de suppression"));	
				
		
	}
	
	
}
