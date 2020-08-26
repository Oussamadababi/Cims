package Cims.PFE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cims.PFE.Entities.Division;
import Cims.PFE.Entities.Service1;
import Cims.PFE.Service.ServiceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ServiceController {
	
	@Autowired
	ServiceService SS;
	
	@GetMapping(value="/ServiceParDiv/{idDivision}")
	public List<Service1> getServiceParDiv(@PathVariable(name="idDivision") Long idDivision) {
		return SS.getServiceParDivision(idDivision);
	}

}
