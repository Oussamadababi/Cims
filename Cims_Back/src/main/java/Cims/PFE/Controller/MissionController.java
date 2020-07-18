package Cims.PFE.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Cims.PFE.Dao.MissionRepository;
import Cims.PFE.Entities.Mission;
import Cims.PFE.Service.MissionService;
import Cims.PFE.payload.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MissionController {

	@Autowired
	private MissionRepository missionRepository;
	
	@Autowired
	private MissionService missionService;
	
	@GetMapping(value="/listMissionAffectation/{id}")
	public List<Mission> listMissionAffectation(@PathVariable(name="id")Long idAffect){
		return missionRepository.getMission(idAffect);
	}
	
	@GetMapping(value="/getMission/{id}")
	public Mission get(@PathVariable(name="id") Long id) {
		return missionService.getById(id);
	}
	
	@PutMapping(value="/updateMission/{id}")
	public ResponseEntity<?> update(@PathVariable(name="id") Long id,@RequestBody Mission m){
		Mission mission=missionService.getById(id);
		mission.setHeureArrivee(m.getHeureArrivee());
		mission.setHeureDepart(m.getHeureDepart());
		missionService.save(mission);
		return ResponseEntity.ok(new MessageResponse("Mission modifier"));
	}
	
// les missions (accomplie)
	@GetMapping(value="/listMissionAffectationAccomplie")
	public List<Mission> listMissionAffectationAccomplie(){
		return missionRepository.getMissionAccomplie();
	}
	
	
	@GetMapping("/searchByDate")
    public ResponseEntity<List<Mission>> searchCustomerByEmail(@RequestParam("date") String date) {
		  LocalDate localDate = LocalDate.parse(date);
		List<Mission> mission = missionRepository.findByDate(localDate);
        if (mission != null) {
           
            return new ResponseEntity<List<Mission>>(mission, HttpStatus.OK);
        }
        return new ResponseEntity<List<Mission>>(HttpStatus.NO_CONTENT);
    }
}
