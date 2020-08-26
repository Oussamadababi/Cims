package Cims.PFE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Cims.PFE.Entities.Division;
import Cims.PFE.Entities.Structure;
import Cims.PFE.Service.DivisionService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DivisionController {
	@Autowired
	DivisionService divisionService;
	@GetMapping(value="/getDivisionParStructure/{idStructure}")
	public List<Division>getDivisionParStructure(@PathVariable(name="idStructure") Long idStructure) {
		return divisionService.getDivisionParStructure(idStructure);
	}

}
