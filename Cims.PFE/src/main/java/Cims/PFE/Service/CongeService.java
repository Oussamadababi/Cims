package Cims.PFE.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
		Personnel p = personnelRepository.getOne(co.getPersonnel().getId_personnel());
		c.setEtat("en-attente");
		c.setP(p);
		c.setDatedemande(java.sql.Date.valueOf(LocalDate.now()));
		return congeRepository.save(c);
	}

	public Conge ajouterConge(Conge c, long id) {
		Personnel p = personnelRepository.findById(id).get();
		c.setP(p);
		c.setEtat("en-attente");
		c.setDatedemande(java.sql.Date.valueOf(LocalDate.now()));
		return congeRepository.save(c);
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
	public List<Conge> congeparPersonnel(int matricule) {
		return congeRepository.congeparMatricule(matricule);
	}
	public List<Conge> congeparPersonnel ( long idCompte) 
	{
		Compte co = compteRepository.getOne(idCompte);

		return congeRepository.congeparPersonnel(co.getPersonnel().getId_personnel());
	}
}