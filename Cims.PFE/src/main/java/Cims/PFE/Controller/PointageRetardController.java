package Cims.PFE.Controller;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cims.PFE.Entities.Personnel;
import Cims.PFE.Service.PointageRetardService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PointageRetardController {
	@Autowired
	PointageRetardService pointageRetardService;
	@PutMapping(value = "ListeRetard/{personnel_id}/{date}/{heureEntree}")
	public void ajouteAuListeAbsence(@PathVariable("personnel_id") long personnel_id,
			@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,@PathVariable("heureEntree")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime   heureEntree) {
		pointageRetardService.ajouteAuListeRetard(personnel_id, date,heureEntree);
	}
	@PutMapping(value = "supprimerPersonnelDeLaListeRetard/{personnel_id}/{date}")
	public void supprimerPersonnelDeLaListe(@PathVariable("personnel_id")long personnel_id,@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date)
	{
		pointageRetardService.supprimerPersonnelDeLaListe(personnel_id, date);
	}
	@GetMapping(value = "/listNonRetard/{date}")
	public List<Personnel> listnonRetard(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
		return pointageRetardService.listNonRetard(date);
	}
	@GetMapping(value = "/listRetard/{date}")
	public List<Personnel> listRetard(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
		return pointageRetardService.listRetardParJour(date);
	}
	
}
