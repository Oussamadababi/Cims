package Cims.PFE.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

import Cims.PFE.Dao.AffectationPartielleRepository;
import Cims.PFE.Dao.AffectationTotaleRepository;
import Cims.PFE.Dao.CompteRepository;
import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Dao.RoleRepository;
import Cims.PFE.Entities.AffectationPartielle;
import Cims.PFE.Entities.AffectationTotale;
import Cims.PFE.Entities.ERole;
import Cims.PFE.Entities.Personnel;
import Cims.PFE.Entities.Role;
import Cims.PFE.Service.AffectationTotaleService;
import Cims.PFE.Service.PersonnelService;
import Cims.PFE.payload.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AffectationTotaleController {
	
	@Autowired
	private AffectationTotaleService service;
	
	@Autowired
	CompteRepository compteRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private PersonnelService personnelService;
	
	@Autowired
	private AffectationTotaleRepository affRepository;
	
	@Autowired
	PersonnelRepository repo;
	
	@Autowired
	private AffectationPartielleRepository Affrepo;
	
	@GetMapping(value="/listAffectation_T")
	public List<AffectationTotale> listAffectationTotale(){
		return service.listAll();
	}
	
	
	@PostMapping(value="/addAffectation_T")
	public ResponseEntity<?> save(@RequestBody AffectationTotale affT) {
		
		if(affRepository.existsByPersonnel(affT.getPersonnel())==false) {
			
		
		Set<Role> roles = new HashSet<>();
		Role CorrespondantRole = roleRepository.findByName(ERole.ROLE_CORRESPONDANT)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		Role userRole = roleRepository.findByName(ERole.ROLE_PERSONNEL)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(CorrespondantRole);
		roles.add(userRole);
		
 Long id=affT.getPersonnel().getId_personnel();
		 if(service.save(affT)!= null) {
			 Personnel pers=personnelService.getById( id);
			 pers.getUser().setRoles(roles);
			personnelService.save(pers);
		 }
		 return ResponseEntity.ok(new MessageResponse("Affectation totale ajouter!"));
	}
		
		 return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Echec d'ajout d'affectation! le personnel a une affectation totale"));
		 }
	
	
	@PutMapping(value="/updateAffectation_T/{id}")
	public ResponseEntity<?> update(@PathVariable(name="id") Long id,@RequestBody AffectationTotale t){
		List<AffectationPartielle> list=Affrepo.getSiteParPersonnel(t.getSite().getIdSite(),t.getPersonnel().getId_personnel());
		AffectationTotale affT=service.getById(id);
		affT.setPersonnel(t.getPersonnel());
		if(list.isEmpty()) {
			affT.setSite(t.getSite());
		}else return ResponseEntity.badRequest().body(new MessageResponse(t.getPersonnel().getNom()+" a une affectation partielle dans le site  "+t.getSite().getNomSite()));
		
		final AffectationTotale updatedAffect=service.save(affT);
		return ResponseEntity.ok(new MessageResponse("Affectation  totale modifiée!"));
	}
	
	
	@GetMapping(value="/getAffectation_T/{id}")
	public AffectationTotale get(@PathVariable(name="id") Long id) {
		return service.getById(id);
	}
	
	
	@DeleteMapping(value="/deleteAffectation_T/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
		List<AffectationPartielle> list=Affrepo.getAffectPartielle(id);
		if(list.isEmpty()) {
			if(service.delete(id)==true) {
			return ResponseEntity.ok(new MessageResponse("Affectation totale supprimer!"));
			}
		}		else return ResponseEntity.badRequest().body(new MessageResponse("Erreur: Vous devez supprimer les affectations partielles de personnel avant de supprimer"));

		
		return ResponseEntity.badRequest().body(new MessageResponse("Erreur: Échec lors de suppression"));	
	}
	
	
	@GetMapping(value="/list_T_Personnel")
	public List<Personnel> listAffecPersonnel(){
		List<Personnel> list=new ArrayList<Personnel>();
		for(int i=0;i<affRepository.count();i++) {
			Long id=affRepository.getId().get(i);
		Personnel p=personnelService.getById(id);
		if(list.contains(p)==false) {
			list.add(p);
		}
		
		}
	
		return list;
	}
	
}
