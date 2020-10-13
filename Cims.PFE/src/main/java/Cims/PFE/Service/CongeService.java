package Cims.PFE.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import Cims.PFE.Entities.Type_conge;

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
	public List<Conge> listAllAccepte() {
		List<Conge> conges = new ArrayList<>();
		congeRepository.congeparEtat("Accepté").forEach(conges::add);
		return conges;
	}
	public List<Conge> listAllEnAttente() {
		List<Conge> conges = new ArrayList<>();
		congeRepository.congeparEtat("En_attente").forEach(conges::add);
		return conges;
	}

	public Conge demanderConge(Conge c, long idCompte) {

		Compte co = compteRepository.getOne(idCompte);
		Personnel p = personnelRepository.getOne(co.getPersonnel().getId_personnel());
		/*Conge c1 = congeRepository.congeparPersonnelenattente(co.getPersonnel().getId_personnel());

		if (c1 == null) {
			c.setEtat("en-attente");
			c.setP(p);
			c.setDatedemande(java.sql.Date.valueOf(LocalDate.now()));
			return congeRepository.save(c);
		}
		return c1;*/
		
		// Conveert local date to date pour utiliser dans le calendar
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date dated = Date.from(c.getDatedebut().atStartOfDay(defaultZoneId).toInstant());
		// ajouter nbj au date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dated);
		c.setP(p);
		c.setEtat("En_attente");
		c.setDatedemande(java.sql.Date.valueOf(LocalDate.now()));
		// soustracter le conge de la solde repos n-2
		if (c.getTypedeconge() == Type_conge.conge_repos) {

			calendar.add(Calendar.DATE, c.getNumDeJour());
			Date currentDatePlusOne = calendar.getTime();
			// Converting the Date to LocalDate
			Instant instant = currentDatePlusOne.toInstant();
			LocalDate Datedebutplusnbj = instant.atZone(defaultZoneId).toLocalDate();
			// Convert Finis
			c.setDatefin(Datedebutplusnbj);
			c.setNumDeMois(0);
			if (p.getSoldeReposN_2() != 0) {
				p.setSoldeReposN_2(p.getSoldeReposN_2() - c.getNumDeJour());
				return congeRepository.save(c);
			} else if (p.getSoldeReposN_1() != 0) {
				p.setSoldeReposN_1(p.getSoldeReposN_1() - c.getNumDeJour());
				return congeRepository.save(c);
			} else if (p.getSoldeRepos() != 0) {
				p.setSoldeRepos(p.getSoldeRepos() - c.getNumDeJour());
				return congeRepository.save(c);
			}

			else
				c.setEtat("Pas de solde");
			return congeRepository.save(c);
		} else if (c.getTypedeconge() == Type_conge.conge_maladie_longue_duree
				| c.getTypedeconge() == Type_conge.conge_post_natal | c.getTypedeconge() == Type_conge.conge_maternite
				| c.getTypedeconge() == Type_conge.conge_sans_solde) {

			calendar.add(Calendar.MONTH, c.getNumDeMois());
			// Converting the calendar to date
			Date currentDatePlusOne = calendar.getTime();
			// Converting the Date to LocalDate
			Instant instant = currentDatePlusOne.toInstant();
			LocalDate DatedebutplusNbMois = instant.atZone(defaultZoneId).toLocalDate();
			// Convert Finis
			c.setNumDeJour(0);
			c.setDatefin(DatedebutplusNbMois);
			return congeRepository.save(c);

		} else if (c.getTypedeconge() == Type_conge.mise_a_pied) {
			c.setNumDeJour(0);
			c.setNumDeMois(0);
			c.setEtat("mise à pied");
			return congeRepository.save(c);
		} else
			c.setNumDeJour(0);
		c.setNumDeMois(0);
		c.setEtat("Detachement");
		return congeRepository.save(c);
		
	}

	public Conge ajouterConge(Conge c, long id) {
		Personnel p = personnelRepository.getOne(id);
		// Conveert local date to date pour utiliser dans le calendar
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date dated = Date.from(c.getDatedebut().atStartOfDay(defaultZoneId).toInstant());
		// ajouter nbj au date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dated);
		c.setP(p);
		c.setEtat("Accepté");
		c.setDatedemande(java.sql.Date.valueOf(LocalDate.now()));
		// soustracter le conge de la solde repos n-2
		if (c.getTypedeconge() == Type_conge.conge_repos) {

			calendar.add(Calendar.DATE, c.getNumDeJour());
			Date currentDatePlusOne = calendar.getTime();
			// Converting the Date to LocalDate
			Instant instant = currentDatePlusOne.toInstant();
			LocalDate Datedebutplusnbj = instant.atZone(defaultZoneId).toLocalDate();
			// Convert Finis
			c.setDatefin(Datedebutplusnbj);
			c.setNumDeMois(0);
			if (p.getSoldeReposN_2() != 0) {
				p.setSoldeReposN_2(p.getSoldeReposN_2() - c.getNumDeJour());
				return congeRepository.save(c);
			} else if (p.getSoldeReposN_1() != 0) {
				p.setSoldeReposN_1(p.getSoldeReposN_1() - c.getNumDeJour());
				return congeRepository.save(c);
			} else if (p.getSoldeRepos() != 0) {
				p.setSoldeRepos(p.getSoldeRepos() - c.getNumDeJour());
				return congeRepository.save(c);
			}

			else
				c.setEtat("Pas de solde");
			return congeRepository.save(c);
		} else if (c.getTypedeconge() == Type_conge.conge_maladie_longue_duree
				| c.getTypedeconge() == Type_conge.conge_post_natal | c.getTypedeconge() == Type_conge.conge_maternite
				| c.getTypedeconge() == Type_conge.conge_sans_solde) {

			calendar.add(Calendar.MONTH, c.getNumDeMois());
			// Converting the calendar to date
			Date currentDatePlusOne = calendar.getTime();
			// Converting the Date to LocalDate
			Instant instant = currentDatePlusOne.toInstant();
			LocalDate DatedebutplusNbMois = instant.atZone(defaultZoneId).toLocalDate();
			// Convert Finis
			c.setNumDeJour(0);
			c.setDatefin(DatedebutplusNbMois);
			return congeRepository.save(c);

		} else if (c.getTypedeconge() == Type_conge.mise_a_pied) {
			c.setNumDeJour(0);
			c.setNumDeMois(0);
			c.setEtat("mise à pied");
			return congeRepository.save(c);
		} else
			c.setNumDeJour(0);
		c.setNumDeMois(0);
		c.setEtat("Detachement");
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

	// liste conges par matricule
	public List<Conge> congeparPersonnel(int matricule) {
		return congeRepository.congeparMatricule(matricule);
	}

	// Liste des conges par id conges
	public List<Conge> congeparPersonnel(long idCompte) {
		Compte co = compteRepository.getOne(idCompte);

		return congeRepository.congeparPersonnel(co.getPersonnel().getId_personnel());
	}

	public Conge congeparPersonnelenattente(long idPersonnel) {
		return congeRepository.congeparPersonnelenattente(idPersonnel);
	}

	public Conge congeparPersonnelenattenteCompte(long idCompte) {
		Compte co = compteRepository.getOne(idCompte);
		return congeRepository.congeparPersonnelenattente(co.getPersonnel().getId_personnel());
	}

	public int NbjrsCongeAccepter(Long id_p) {
		List<Conge> listeConge = congeRepository.congeAccepterParIdpersonnel(id_p);
		int nbfinal = 0;
		for (Conge C : listeConge) {
			int nbj = C.getDatefin().getDayOfYear() - C.getDatefin().getDayOfYear();
			nbfinal = nbfinal + nbj;
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
	public List<Conge> listCongeParDate(long idPersonnel,Date date) {
		List<Conge> conges = new ArrayList<>();
		congeRepository.congeparPersonnelParDate(idPersonnel, date).forEach(conges::add);
		return conges;
	}
}