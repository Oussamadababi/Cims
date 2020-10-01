package Cims.PFE.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.AppelDeJourRepository;
import Cims.PFE.Dao.CongeRepository;
import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Entities.AppelDeJour;
import Cims.PFE.Entities.AppelJourPersonnel;
import Cims.PFE.Entities.Conge;
import Cims.PFE.Entities.Personnel;

@Service
public class AppelJourPersonnelService {
@Autowired
Cims.PFE.Dao.PersonnelAbsentRepository personnelAbsentRepository;
@Autowired
PersonnelRepository personnelRepository;
@Autowired
AppelDeJourRepository appelDeJourRepository;
@Autowired
private CongeRepository congeRepository;
public void ajouteAuListeAbsence(long personnel_id, Date date,AppelJourPersonnel ap)
{
	Personnel p = personnelRepository.findById(personnel_id).get();
AppelDeJour a = appelDeJourRepository.findByDatedujour(date);
List<Personnel> Personnels=personnelRepository.listAbsenceParJour(date);
List<Conge> conges = congeRepository.congeparPersonnelParDate(personnel_id, date);

if ((a == null)){
if(conges.isEmpty())
{
	ap.setEtat("nonjus");
}else
{
	ap.setEtat("jus");
}
AppelDeJour newAppel = new AppelDeJour();
	newAppel.setDatedujour(date);
	appelDeJourRepository.save(newAppel);
	ap.setAppelDeJour(newAppel);
	ap.setPersonnels(p);
	ap.setEtat("nonjus");
	personnelAbsentRepository.save(ap);
	
}
else 
{
	if(conges.isEmpty())
	{
		ap.setEtat("nonjus");
	}else
	{
		ap.setEtat("jus");
	}

	ap.setAppelDeJour(a);
	ap.setPersonnels(p);
	personnelAbsentRepository.save(ap);
}
}
public void supprimerAuListeAbsence(long personnel_id, Date date)
{
	AppelJourPersonnel ap =personnelAbsentRepository.getAppelJourPersonnel(personnel_id, date);
	personnelAbsentRepository.delete(ap);
	AppelDeJour appel =appelDeJourRepository.getOne(date);
	List<AppelJourPersonnel> list =appel.getAppelJourPersonnel();
	if(list.isEmpty())
		appelDeJourRepository.delete(appel);
}
public List<Personnel>listnonAbsent(Date date){
	List <Personnel> p = new ArrayList();
	List<BigInteger> idp=personnelRepository.listNonAbsenceParJour(date);
	
	for(BigInteger i : idp){
		Personnel p1 = new Personnel ();
		p1=personnelRepository.getOne(i.longValue());
		p.add(p1);
		
		
	}
	return p;
	
	
}
}
