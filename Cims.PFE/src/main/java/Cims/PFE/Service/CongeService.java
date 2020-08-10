package Cims.PFE.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Cims.PFE.Dao.CompteRepository;
import Cims.PFE.Dao.CongeRepository;
import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Entities.Compte;
import Cims.PFE.Entities.Conge;
import Cims.PFE.Entities.Personnel;

@Service
public class CongeService {

	@Autowired
	CongeRepository congeRepository;
	@Autowired
	PersonnelRepository personnelRepository;
	@Autowired
	CompteRepository compteRepository;

	public Conge save(Conge c) {
		return congeRepository.save(c);
	}

	public List<Conge> listAll() {
		List<Conge> conges = new ArrayList<>();
		congeRepository.findAll().forEach(conges::add);
		return conges;
	}

	public Conge demanderConge(Conge c, long idCompte) {
		
		Compte co = compteRepository.getOne(idCompte);
		Conge c1= congeRepository.congeparPersonnelenattente(co.getPersonnel().getId_personnel());
		Personnel p = personnelRepository.getOne(co.getPersonnel().getId_personnel());
		if(c1==null)
		{
		c.setEtat("en-attente");
		c.setP(p);
		c.setDatedemande(java.sql.Date.valueOf(LocalDate.now()));
		return congeRepository.save(c);
		}
		return c1;
	}

	public Conge ajouterConge(Conge c, long id) {
		Personnel p = personnelRepository.findById(id).get();
		Conge c1= congeRepository.congeparPersonnelenattente(p.getId_personnel());
		if(c1==null)
		{
		c.setP(p);
		c.setEtat("en-attente");
		c.setDatedemande(java.sql.Date.valueOf(LocalDate.now()));
		return congeRepository.save(c);
		}
		return c1;
	}

	public List<Conge> congeparMatricule(int matricule) {
		return congeRepository.congeparMatricule(matricule);
	}

	public void deleteConge(long id) {
		congeRepository.deleteById(id);
	}

	public Conge getById(Long id) {
		return congeRepository.findById(id).get();
	}

	public Conge update(Long id, Conge c) {
		c.setId(id);
		return congeRepository.findById(id).get();
	}
	//liste conges par matricule
	public List<Conge> congeparPersonnel(int matricule) {
		return congeRepository.congeparMatricule(matricule);
	}
	// Liste des conges par id conges
	public List<Conge> congeparPersonnel ( long idCompte) 
	{
		Compte co = compteRepository.getOne(idCompte);

		return congeRepository.congeparPersonnel(co.getPersonnel().getId_personnel());
	}
	public Conge congeparPersonnelenattente(long idPersonnel)
	{
		return congeRepository.congeparPersonnelenattente(idPersonnel);
	}
	public Conge congeparPersonnelenattenteCompte(long idCompte)
	{
		Compte co = compteRepository.getOne(idCompte);
		return congeRepository.congeparPersonnelenattente(co.getPersonnel().getId_personnel());
	}
	public int NbjrsCongeAccepter (Long id_p){
		List<Conge> listeConge=congeRepository.congeAccepterParIdpersonnel(id_p);
		int nbfinal=0;
		for(Conge C :listeConge)
		{
			int nbj = C.getDatefin().getDayOfYear()-C.getDatefin().getDayOfYear();
			nbfinal=nbfinal+nbj;
		}
		return nbfinal;
		
	}
	@Transactional
	public void AccepterConge(Long id) {
		congeRepository.ModifierEtatConge("accepter", id);
	}
	@Transactional
	public void RefuserConge(Long id) {
		congeRepository.ModifierEtatConge("refuser", id);
	}
}