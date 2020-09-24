package Cims.PFE.Service;

import java.math.BigInteger;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cims.PFE.Dao.PersonnelRepository;
import Cims.PFE.Dao.PointageRetardRepository;
import Cims.PFE.Entities.AppelDeJour;
import Cims.PFE.Entities.Personnel;
import Cims.PFE.Entities.PointageRetard;

@Service
public class PointageRetardService {
	@Autowired
	PointageRetardRepository pointageRetardRepository;
	@Autowired
	PersonnelRepository personnelRepository;
	public void ajouteAuListeRetard(long personnel_id, Date date,LocalDateTime   heureEntree) {
		Personnel p = personnelRepository.findById(personnel_id).get();
		PointageRetard r = pointageRetardRepository.findByDatedujour(date);
		if (r == null) {
			PointageRetard pointageRetard = new PointageRetard();
			pointageRetard.setDatedujour(date);
			pointageRetard.setHeureEntree(heureEntree);

			if (pointageRetard.getPersonnels() == null) {
				List<Personnel> personnels = new ArrayList<>();
				personnels.add(p);
				pointageRetard.setPersonnels(personnels);
				pointageRetard.setHeureEntree(heureEntree);

				pointageRetardRepository.save(pointageRetard);
			}
		
		} else {
			if (r.getPersonnels() == null) {

				List<Personnel> personnels = new ArrayList<>();
				personnels.add(p);
				r.setPersonnels(personnels);
				pointageRetardRepository.save(r);

			} else {
				r.getPersonnels().add(p);
				pointageRetardRepository.save(r);

			}
		}

		
	}
	public void supprimerPersonnelDeLaListe(long personnel_id, Date date)
	{
		PointageRetard r = pointageRetardRepository.findByDatedujour(date);
		int nbPersonnel=r.getPersonnels().size();	
		for(int i = 0; i < nbPersonnel; i++)
		{
			if(r.getPersonnels().get(i).getId_personnel() == personnel_id)
			{
				r.getPersonnels().remove(i);
				pointageRetardRepository.save(r);
				break;
			}
			
		}
	}
	public List<Personnel>listNonRetard(Date date){
		List <Personnel> p = new ArrayList();
		List <BigInteger> idp=pointageRetardRepository.listNonRetardParJour(date);
		
		for(BigInteger i : idp){
			Personnel p1 = new Personnel ();
			p1=personnelRepository.getOne(i.longValue());
			p.add(p1);
			
			
		}
		return p;
		
		
	}
	public List<Personnel> listRetardParJour(Date date)
	{
		return pointageRetardRepository.listRetardParJour(date);
	}
}
