package Cims.PFE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping(value = "/getTypeFonction/{id_fonction}")
	public Fonction getTypeFonction(@PathVariable("id_fonction") Long id_fonction)
	{
		return FS.getTypeFonction(id_fonction);
	}

}
