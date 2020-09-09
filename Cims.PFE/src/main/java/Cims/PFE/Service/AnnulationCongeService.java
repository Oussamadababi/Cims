package Cims.PFE.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.AnnulationCongeRepository;
import Cims.PFE.Dao.CompteRepository;
import Cims.PFE.Dao.CongeRepository;
import Cims.PFE.Entities.AnnulationConge;
import Cims.PFE.Entities.Compte;
import Cims.PFE.Entities.Conge;

@Service
public class AnnulationCongeService {

	@Autowired
	AnnulationCongeRepository annulationCongeRepository;
	@Autowired
	CongeRepository cRepository;
	@Autowired
	CompteRepository compteRepository;

	public AnnulationConge save(AnnulationConge Ac) {

		return annulationCongeRepository.save(Ac);
	}

	public List<AnnulationConge> listAll() {
		List<AnnulationConge> conges = new ArrayList<>();
		annulationCongeRepository.findAll().forEach(conges::add);
		return conges;
	}

	public AnnulationConge ajouterAConge(Long id_conge) {
		Conge ca = cRepository.getOne(id_conge);
		AnnulationConge c = new AnnulationConge();
		c.setConge(ca);
		c.setDatedemande(java.sql.Date.valueOf(LocalDate.now()));
		c.setEtat("En_attente");
		return save(c);

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

	public Object AnulationCongeenattente(long idPersonnel) {
		return annulationCongeRepository.AnulationConge(idPersonnel);
	}

//	public List<AnnulationConge> AnulationConge(long idCompte)
//	{
//		Compte co = compteRepository.getOne(idCompte);
//		return annulationCongeRepository.AnulationConge(co.getPersonnel().getId_personnel());
//	}

}
