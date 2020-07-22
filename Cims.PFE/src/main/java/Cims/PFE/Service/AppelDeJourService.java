package Cims.PFE.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Cims.PFE.Dao.AppelDeJourRepository;
import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Entities.AppelDeJour;
import Cims.PFE.Entities.Personnel;


@Service
public class AppelDeJourService {

	@Autowired
	AppelDeJourRepository AppelDeJourRepository;

	@Autowired
	private PersonnelRepository personnelRepository;

	// public void save(AppelDeJour a){
	//
	// List<Personnel> Listepersonnel = personnelRepository.findAll();
	// for(Personnel Personnel1 : Listepersonnel)
	// {
	// a.setDatedujour(java.sql.Date.valueOf(LocalDate.now()));
	// a.setEtat("P");
	//// a.setPersonnels(Personnel1.);
	//
	// }
	// AppelDeJourRepository.save(a);
	//
	// }
//	public void affecterEmployeADepartement(int employeId, int depId) {
//		Departement depManagedEntity = deptRepoistory.findById(depId).get();
//		Employe employeManagedEntity = employeRepository.findById(employeId).get();
//
//		if(depManagedEntity.getEmployes() == null){
//
//			List<Employe> employes = new ArrayList<>();
//			employes.add(employeManagedEntity);
//			depManagedEntity.setEmployes(employes);
//		}else{
//
//			depManagedEntity.getEmployes().add(employeManagedEntity);
//
//		}
//
//	}

	public void ajouteAuListeAbsence(long personnel_id,Date date) {
		Personnel p = personnelRepository.getOne(personnel_id);
		AppelDeJour a = new AppelDeJour();
		a.setDatedujour(date);
		AppelDeJourRepository.save(a);
		if (p.getAppels() == null) {

			List<AppelDeJour> AppelDeJour = new ArrayList<>();
			AppelDeJour.add(a);
			p.setAppels(AppelDeJour);
		
		} else {
			p.getAppels().add(a);
			
		}
		
//		return a.getPersonnels();
	}

}