package Cims.PFE.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.AnnulationCongeRepository;
import Cims.PFE.Dao.CompteRepository;
import Cims.PFE.Dao.CongeRepository;
import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Entities.AnnulationConge;
import Cims.PFE.Entities.Conge;
import Cims.PFE.Entities.Personnel;


@Service
public class AnnulationCongeService {

	@Autowired
	AnnulationCongeRepository annulationCongeRepository;
	@Autowired
	CongeRepository cRepository;
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	PersonnelRepository personnelRepository;

	public AnnulationConge save(AnnulationConge Ac) {

		return annulationCongeRepository.save(Ac);
	}

	public List<AnnulationConge> listAll() {
		List<AnnulationConge> conges = new ArrayList<>();
		annulationCongeRepository.findAll().forEach(conges::add);
		return conges;
	}

	public AnnulationConge ajouterAConge(Long id_conge) {
		Conge conge = cRepository.getOne(id_conge);
		AnnulationConge c = new AnnulationConge();
		c.setConge(conge);
		c.setDatedemande(java.sql.Date.valueOf(LocalDate.now()));
		c.setEtat("Accepté");
		// Calculer difference entre deux localdate
		LocalDate d1 = conge.getDatedebut();
		LocalDate d2 = convertToLocalDateViaSqlDate(c.getDatedemande());
		Duration diff = Duration.between(d1, d2);
		long diffDays = diff.toDays();
		if(diffDays<conge.getNumDeJour()){
			Personnel P1=conge.getP();
			P1.setSoldeRepos(P1.getSoldeRepos()+diffDays);
			personnelRepository.save(P1);		
		    annulationCongeRepository.save(c);
		    return c;
		}
		else return c;
		
	}

	public void deleteAnnulationConge(long id) {
		annulationCongeRepository.deleteById(id);
	}

	public AnnulationConge getById(Long id) {
		return annulationCongeRepository.findById(id).get();
	}

	
	@Transactional
	public void AccepterAnnulationConge(Long id) {
		annulationCongeRepository.ModifierEtatAnulationConge("accepter", id);
		
		
	}

	@Transactional
	public void RefuserAnnulationConge(Long id) {
		annulationCongeRepository.ModifierEtatAnulationConge("refuser", id);
	}

	public AnnulationConge AnulationCongeenattente(long idPersonnel) {
		return annulationCongeRepository.AnulationConge(idPersonnel);
	}

//	public List<AnnulationConge> AnulationConge(long idCompte)
//	{
//		Compte co = compteRepository.getOne(idCompte);
//		return annulationCongeRepository.AnulationConge(co.getPersonnel().getId_personnel());
//	}
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}

}
