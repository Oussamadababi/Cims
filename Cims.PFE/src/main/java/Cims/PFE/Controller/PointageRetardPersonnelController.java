package Cims.PFE.Controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cims.PFE.Entities.Absence;
import Cims.PFE.Entities.Personnel;
import Cims.PFE.Entities.PointageRetardPersonnel;
import Cims.PFE.Service.PointageRetardPersonnelService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PointageRetardPersonnelController {
	@Autowired
	PointageRetardPersonnelService pointageRetardPersonnelService;
	
	@PostMapping(value = "ListeRetard/{personnel_id}/{date}/{heureEntree}")
	public void ajouteAuListeRetard(@PathVariable("personnel_id") long personnel_id,
			@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,@PathVariable("heureEntree")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime   heureEntree,@RequestBody PointageRetardPersonnel pr) {
		pointageRetardPersonnelService.ajouteAuListeRetard(personnel_id, date,heureEntree,pr);
	}
	@GetMapping(value ="allpointageRetardPersonnel")
	public List<PointageRetardPersonnel>getAll()
	{
		return pointageRetardPersonnelService.getAll();
		
	}
	@GetMapping(value = "/listNonRetard/{date}")
	public List<Personnel> listnonRetard(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
		return pointageRetardPersonnelService.listnonRetardParJour(date);
	}
	@GetMapping(value = "/listRetard/{date}")
	public List<Personnel> listRetardParJour(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
		return pointageRetardPersonnelService.listRetardParJour(date);

}
	@DeleteMapping(value = "supprimerPersonnelDeLaListeRetard/{personnel_id}/{date}")
	public void supprimerPersonnelDeLaListe(@PathVariable("personnel_id")long personnel_id,@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date)
	{
		pointageRetardPersonnelService.supprimerAuListeRetard(personnel_id, date);
	}
	@GetMapping(value = "/listRetard")
	public List<Absence> listRetard()
	{
		return pointageRetardPersonnelService.listRetard();	
	}
	@GetMapping(value = "/ListeDesHeuresRetardParPersonnelId/{personnel_id}")
	List<PointageRetardPersonnel> listeDesHeuresRetardParPersonnelId(@PathVariable("personnel_id")long idpersonnel)
	{
		return pointageRetardPersonnelService.listeDesHeuresRetardParPersonnelId(idpersonnel);
	}
}
