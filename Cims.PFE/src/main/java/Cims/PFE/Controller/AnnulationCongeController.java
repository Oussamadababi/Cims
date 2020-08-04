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

import Cims.PFE.Entities.AnnulationConge;
import Cims.PFE.Service.AnnulationCongeService;
import Cims.PFE.payload.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AnnulationCongeController {
	
	@Autowired
	AnnulationCongeService annulationCongeService;
	
	@PostMapping(value = "/addAnnulationConge")
	public ResponseEntity<MessageResponse> save(@RequestBody AnnulationConge c) {
		annulationCongeService.save(c);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Annulation Conge ajouter"));

	}
	
	@GetMapping(value = "/listannulationconge")
	public List<AnnulationConge> listAnnulationConges() {
		return annulationCongeService.listAll();
	}
	
	@PostMapping(value = "/ajouterAConge/{id_conge}")
	public ResponseEntity<MessageResponse> ajouterAConge(
			@PathVariable("id_conge") Long id_conge) {
		annulationCongeService.ajouterAConge( id_conge);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("demande annulation conge ajouter"));
	}
	
	@DeleteMapping(value="/deleteAnnulationConge/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
		annulationCongeService.deleteAnnulationConge(id);
		return ResponseEntity.ok(new MessageResponse("demande annulation conge supprimer"));
	}
	
	@PutMapping(value="/accepterAnnulationConge/{id}")
	public ResponseEntity<MessageResponse> AccepterAConge(@PathVariable(name="id") Long id){
		annulationCongeService.AccepterAnnulationConge(id);;
		return ResponseEntity.ok(new MessageResponse("demande annulation conge Accepter"));
	}
	@PutMapping(value="/refuserAnnulationConge/{id}")
	public ResponseEntity<MessageResponse> RefuserAConge(@PathVariable(name="id") Long id){
		annulationCongeService.RefuserAnnulationConge(id);;
		return ResponseEntity.ok(new MessageResponse("demande annulation conge Refuser"));
	}
	

}
