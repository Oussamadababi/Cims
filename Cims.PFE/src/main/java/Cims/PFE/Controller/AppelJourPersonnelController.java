package Cims.PFE.Controller;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import Cims.PFE.Entities.Absence;
import Cims.PFE.Entities.AppelJourPersonnel;
import Cims.PFE.Entities.Personnel;
import Cims.PFE.Service.AppelJourPersonnelService;
import Cims.PFE.payload.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AppelJourPersonnelController {
	@Autowired
	AppelJourPersonnelService appelJourPersonnelService;
	@PostMapping(value = "/ajouteAuListeAbsence/{idPersonnel}/{date}")
	public void ajouteAuListeAbsence(@PathVariable(name="idPersonnel") Long idPersonnel, @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,@RequestBody AppelJourPersonnel ap) throws MessagingException
	{
		appelJourPersonnelService.ajouteAuListeAbsence(idPersonnel, date, ap);
	}

	@DeleteMapping(value = "/suppDuListeAbsence/{idPersonnel}/{date}")
	public void suppDuListeAbsence(@PathVariable(name="idPersonnel") Long idPersonnel, @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date)
	{
		appelJourPersonnelService.supprimerAuListeAbsence(idPersonnel, date);
	}
	@GetMapping(value = "/listnonAbsent/{date}")
	public List<Personnel> listnonAbsent(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
		return appelJourPersonnelService.listnonAbsent(date);
	}
//	@GetMapping(value = "/listAllAbsent")
//	public List<Object>listAllAbsent(){
//		return appelDeJourService.listAllAbsent();
//	}
	@GetMapping(value = "/listabsentSansJus")
	public List<Absence> listAbsenceSansJusftication()
	{
	return	appelJourPersonnelService.listAbsenceSansJusftication();
	}
	@PutMapping(value = "/envoyermail")
	public ResponseEntity<MessageResponse> envoyerMailPersonnelAbSansjustif() throws MessagingException{
		
		appelJourPersonnelService.envoyermail();
		return ResponseEntity.ok(new MessageResponse("Mail envoyé "));
	}
	@PutMapping(value = "/justifierAbsence/{id}")
	public ResponseEntity<MessageResponse> JustifierAbsence(@PathVariable("id")long id) {
		appelJourPersonnelService.JustifierAppelDejou(id);
		return ResponseEntity.ok(new MessageResponse("Absence justifié "));
	}
}
