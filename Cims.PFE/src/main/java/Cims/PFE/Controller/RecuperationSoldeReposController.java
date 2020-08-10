package Cims.PFE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cims.PFE.Entities.RecuperationSoldeRepos;
import Cims.PFE.Service.RecuperationSoldeReposService;
import Cims.PFE.payload.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RecuperationSoldeReposController {
	@Autowired
	RecuperationSoldeReposService recuperationSoldeRepos;
	
	
	@PostMapping(value = "/addRSR")
	public ResponseEntity<MessageResponse> save(@RequestBody RecuperationSoldeRepos c) {
		recuperationSoldeRepos.ajouterdemandeRSR(c);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Demande RSR ajouter"));

	}

}