package Cims.PFE.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.CongeRepository;
import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Entities.Conge;
import Cims.PFE.Entities.Grade;
import Cims.PFE.Entities.Personnel;

@Service
public class CongeService {

	@Autowired
	CongeRepository congeRepository;
	@Autowired
	PersonnelRepository personnelRepository;

	public Conge save(Conge c) {
		return congeRepository.save(c);
	}

	public List<Conge> listAll() {
		List<Conge> conges = new ArrayList<>();
		congeRepository.findAll().forEach(conges::add);
		return conges;
	}

	public Conge demanderConge(Conge c, long personnel_id) {
		Personnel p = personnelRepository.getOne(personnel_id);
		c.setP(p);
		//// Date d=new Date().
		// c.setDatedemande();
		return congeRepository.save(c);
	}

	public Conge ajouterConge(Conge c, long id) {
		Personnel p = personnelRepository.findById(id).get();
		c.setP(p);

		return congeRepository.save(c);
	}

	public List<Conge> congeparMatricule(int matricule) {
		return congeRepository.congeparMatricule(matricule);
	}
	public void deleteConge(long id) {
		congeRepository.deleteById(id);
	}
}
