package Cims.PFE.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.AppelDeJourRepository;
import Cims.PFE.Dao.CompteRepository;
import Cims.PFE.Dao.DepartementRepository;
import Cims.PFE.Dao.DivisionRepository;
import Cims.PFE.Dao.FonctionRepository;
import Cims.PFE.Dao.GradeRepository;
import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Dao.ServiceRepository;
import Cims.PFE.Dao.SiteRepository;
import Cims.PFE.Entities.Absence;
import Cims.PFE.Entities.Affectation;
import Cims.PFE.Entities.Compte;
import Cims.PFE.Entities.Division;
import Cims.PFE.Entities.Fonction;
import Cims.PFE.Entities.Grade;
import Cims.PFE.Entities.Personnel;
import Cims.PFE.Entities.Service1;
import Cims.PFE.Entities.Structure;


@Service
public class PersonnelService {
	
	@Autowired
	private PersonnelRepository personnelRepository;
	
	
	@Autowired
	private AppelDeJourRepository appelDeJourRepository;
	
	@Autowired
	CongeService congeService;
	@Autowired
	GradeRepository gradeRepository;
	@Autowired
	FonctionRepository fonctionRepository;
	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	SiteRepository siteRepository;
	@Autowired
	DivisionRepository divisionRepository;
	@Autowired
	ServiceRepository serviceRepository;
	@Autowired
	CompteRepository compteRepository;
	
	public List<Personnel> listAll(){
		List<Personnel> personnels = new ArrayList<>();
		personnelRepository.findAll().forEach(personnels::add);
		return personnelRepository.findAll();
	}
	
	
	public Personnel save(Personnel p) {
		p.setSoldeRepos(0);
		p.setSoldeExceptionnel(0);
		return personnelRepository.save(p);
	}
	public Personnel save2(Personnel p,long id_grade,long idFonction,long idStructure,long idAffectation,long idDivision,long idService) {
		Grade g =gradeRepository.getOne(id_grade);
		Fonction f =fonctionRepository.getOne(idFonction);
		Structure s =departementRepository.getOne(idStructure);
		Affectation a=siteRepository.getOne(idAffectation);
		Division d =divisionRepository.getOne(idDivision);
		Service1 service1=serviceRepository.getOne(idService);
		p.setDepartement(s);
		p.setGrade(g);
		p.setFonction(f);
		p.setAffectation(a);
		p.setDivision(d);
		p.setService1(service1);
		p.setSoldeRepos(0);
		p.setSoldeExceptionnel(0);
		p.setNbrMinuteRetard(0);
		return personnelRepository.save(p);
		
	}

	
	public Personnel update(Long id, Personnel p){
		p.setId_personnel(id);
		return personnelRepository.findById(id).get();
	}
	public Personnel getById(Long id) {
		return personnelRepository.findById(id).get();
	}
	public Personnel getByIdcompte(Long idCompte) {
		Compte c = compteRepository.getOne(idCompte);
		return personnelRepository.findById(c.getPersonnel().getId_personnel()).get();
	}
	public boolean delete(Long id){
		personnelRepository.deleteById(id);
		if(personnelRepository.existsById(id)==false)
		{
			return true;
		}
			return false;
		
	}
	public void updateSoldeexceptionnel(int matricule,int soldeExceptionnel)
	{
		Personnel p=personnelRepository.findByMatricule(matricule);
		p.setSoldeExceptionnel(soldeExceptionnel);
		personnelRepository.save(p);
	}
	
	/*Ajouter au solde repos chaque 6 jrs 0.5*/
	@Scheduled(cron = "0 0 7 0 * ?")
//	@Scheduled(fixedRate = 5000L) 518 400
	public void updateAutoSoldeRepos()
	{
		List<Personnel> Listepersonnel = personnelRepository.findAll();
		for(Personnel Personnel1 : Listepersonnel)
		{
			//int Nbjrstrav = Nbjourtrvail(Personnel1.getId_personnel());
		//	double soldeRepos1 =(Nbjrstrav/6)*0.5;
			Personnel1.setSoldeRepos(Personnel1.getSoldeRepos()+2.5);
			personnelRepository.save(Personnel1);
			
			
		}
		
	}
	
	
	//Nombre de jour de travail les deux dernière annees
	public int Nbjourtrvail(Long id){
		int Nbjrstravail;
		int NbAbscenceT=appelDeJourRepository.NbAbscenceparId(id);
		Personnel p= new Personnel();
		p=getById(id);
		int NbjConge=congeService.NbjrsCongeAccepter(id);
		int anneeRecrutement = p.getDate_recrutement().getYear();
		int anneeAujourdhui = LocalDate.now().getYear();
			if(anneeAujourdhui-anneeRecrutement==0){
				 Nbjrstravail=LocalDate.now().getDayOfYear()-p.getDate_recrutement().getDayOfYear();
			}
			else if (anneeAujourdhui-anneeRecrutement==1){
				 Nbjrstravail=LocalDate.now().getDayOfYear()-p.getDate_recrutement().getDayOfYear()+356;
			}
			else Nbjrstravail=LocalDate.now().getDayOfYear()-p.getDate_recrutement().getDayOfYear()+712;	
		
		return Nbjrstravail;
		
	}
	public List<Absence> listAbsenceParJour(Date date)
	{
		return personnelRepository.listAbsenceParJour2(date);
	}
	
	/*Transferer le Solde Repos vers le SRN-1 et N-2 chaque année*/
//	@Scheduled(cron = "1 0 0 1 * ?")
//	@Scheduled(fixedRate = 5000L) 518 400
	public void TransferSoldeRepos() {
		List<Personnel> Listepersonnel = personnelRepository.findAll();
		for(Personnel Personnel1 : Listepersonnel)
		{
			 double N =Personnel1.getSoldeRepos();
			 double N_1=Personnel1.getSoldeReposN_1();
			 double N_2=Personnel1.getSoldeReposN_2();
			 
			 Personnel1.setSoldeRepos(0);
			 Personnel1.setSoldeReposN_1(N);
			 Personnel1.setSoldeReposN_2(N_1);
			 
			personnelRepository.save(Personnel1);
			
			
		}
		
		
	}
	
	public void AjouterSoldeCompensation (long id_p,double soldeC){
		
		Personnel p = personnelRepository.getOne(id_p);
		double soldep=p.getSoldeCompensation();
		p.setSoldeCompensation(soldep+(double) soldeC);
		personnelRepository.save(p);
		
	}
	
}