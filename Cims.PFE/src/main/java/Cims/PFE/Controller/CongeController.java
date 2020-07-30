package Cims.PFE.Controller;

import java.time.LocalDate;
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
import Cims.PFE.Entities.Conge;
import Cims.PFE.Service.CongeService;
import Cims.PFE.payload.response.MessageResponse;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CongeController {
	@Autowired
	CongeService congeService;

	@PostMapping(value = "/addConge")
	public ResponseEntity<MessageResponse> save(@RequestBody Conge c) {
		congeService.save(c);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Conge ajouter"));

	}

	@GetMapping(value = "/listconge")
	public List<Conge> listGrades() {
		return congeService.listAll();
	}

	@PostMapping(value = "/demanderConge/{personnel_id}")
	public ResponseEntity<MessageResponse> demanderConge(@RequestBody Conge c,
			@PathVariable("personnel_id") Long personnel_id) {
		congeService.demanderConge(c, personnel_id);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("demande ajouter"));
	}
	@PostMapping(value = "/ajouterConge/{personnel_id}")
	public ResponseEntity<MessageResponse>ajouterConge(@RequestBody Conge c,
			@PathVariable("personnel_id") long id) {
		congeService.ajouterConge(c, id);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("demande ajouter"));
	}
	
	@GetMapping(value = "/listcongeparMatricule/{matricule}")
	public List<Conge> congeparMatricule(@PathVariable int matricule)
	{
		return congeService.congeparMatricule(matricule);
	}
	@DeleteMapping(value="/deleteConge/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
		congeService.deleteConge(id);
		return ResponseEntity.ok(new MessageResponse("demande supprimer"));
	}
	@PutMapping(value="/updateConge/{id}")
	public ResponseEntity<?> update(@PathVariable(name="id") Long id,@RequestBody Conge c){
		
		Conge co = congeService.getById(id);
		co.setDatedebut(c.getDatedebut());
co.setDatefin(c.getDatefin());		
		co.setP(c.getP());
		co.setTypedeconge(c.getTypedeconge());
		 co.setDatedemande(java.sql.Date.valueOf(LocalDate.now()));
		final Conge updatedConge=congeService.save(co);
		return ResponseEntity.ok(new MessageResponse("Modifier"));
	}
	@GetMapping(value = "/listcongeparPersonnel/{id}")
	public List<Conge> listGone(@PathVariable(name="id")long id) {
		return congeService.congeparPersonnel(id);
	}
}
