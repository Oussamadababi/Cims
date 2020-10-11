package Cims.PFE.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Dao.PointageRetardPersonnelRepository;
import Cims.PFE.Dao.PointageRetardRepository;
import Cims.PFE.Entities.Absence;
import Cims.PFE.Entities.AppelDeJour;
import Cims.PFE.Entities.AppelJourPersonnel;
import Cims.PFE.Entities.Personnel;
import Cims.PFE.Entities.PointageRetard;
import Cims.PFE.Entities.PointageRetardPersonnel;

@Service
public class PointageRetardPersonnelService {
	@Autowired
	PointageRetardRepository pointageRetardRepository;
	@Autowired
	PersonnelRepository personnelRepository;
	@Autowired
	PersonnelService personnelService;
	@Autowired
	PointageRetardPersonnelRepository pointageRetardPersonnelRepository;
	public void ajouteAuListeRetard(long personnel_id, Date date,LocalDateTime heureEntree,PointageRetardPersonnel pr) {
		Personnel p = personnelRepository.findById(personnel_id).get();
		PointageRetard r = pointageRetardRepository.findByDatedujour(date);
		if (r == null) {
			
			PointageRetard pointageRetard = new PointageRetard();
			pointageRetard.setDatedujour(date);
			pointageRetardRepository.save(pointageRetard);
			pr.setPointageRetard(pointageRetard);
			pr.setPersonnels(p);
			pr.setHeureEntree(heureEntree);
			pr.setDatedujour(date);
			pointageRetardPersonnelRepository.save(pr);
		}else
		{
	
			pr.setPointageRetard(r);
			pr.setPersonnels(p);
			pr.setHeureEntree(heureEntree);
			pr.setDatedujour(date);
			pointageRetardPersonnelRepository.save(pr);
		}
	}
	public List<PointageRetardPersonnel>getAll()
	{
		return pointageRetardPersonnelRepository.findAll();
		
	}
	public List<Personnel>listnonRetardParJour(Date date){
	List <Personnel> p = new ArrayList();
	List <BigInteger> idp=pointageRetardPersonnelRepository.listNonRetardParJour(date);
	
	for(BigInteger i : idp){
		Personnel p1 = new Personnel ();
		p1=personnelRepository.getOne(i.longValue());
		p.add(p1);
		
		
	}
	return p;
	
	
}
	public List<Personnel>listRetardParJour(Date date){
		List <Personnel> p = new ArrayList();
		List <BigInteger> idp=pointageRetardPersonnelRepository.listRetardParJour(date);
		
		for(BigInteger i : idp){
			Personnel p1 = new Personnel ();
			p1=personnelRepository.getOne(i.longValue());
			p.add(p1);
			
			
		}
		return p;
		
		
	}
	public void supprimerAuListeRetard (long personnel_id, Date date) {
		PointageRetardPersonnel pr = pointageRetardPersonnelRepository.getPointageRetardPersonnel(personnel_id, date);
		pointageRetardPersonnelRepository.delete(pr);
		PointageRetard r = pointageRetardRepository.getOne(date);
		List<PointageRetardPersonnel> list = r.getRetard();
		if (list.isEmpty())
			pointageRetardRepository.delete(r);
	}
	public List<Absence> listRetard()
	{
	return 	pointageRetardPersonnelRepository.listRetard();
	}
	public List<PointageRetardPersonnel> listeDesHeuresRetardParPersonnelId(long idpersonnel)
	{
		return pointageRetardPersonnelRepository.ListeRetardParPersonnelId(idpersonnel);
	}
}
