package Cims.PFE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cims.PFE.Entities.Fonction;
import Cims.PFE.Service.FonctionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FonctionController {
	
	@Autowired
	FonctionService FS;
	
	@GetMapping(value = "/listFonctions")
	public List<Fonction> listGrades() {
		return FS.listAll();
	}

}
