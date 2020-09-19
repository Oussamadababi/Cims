package Cims.PFE.Controller;

import java.sql.Time;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cims.PFE.Service.PointageRetardService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PointageRetardController {
	@Autowired
	PointageRetardService pointageRetardService;
	@PutMapping(value = "ListeRetard/{personnel_id}/{date}")
	public void ajouteAuListeAbsence(@PathVariable("personnel_id") long personnel_id,
			@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,@DateTimeFormat (iso = DateTimeFormat.ISO.DATE_TIME) Time heureEntree) {
		pointageRetardService.ajouteAuListeRetard(personnel_id, date,heureEntree);
	}
}
