package Cims.PFE.Dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.AppelDeJour;
import Cims.PFE.Entities.Pesonnel_Absent_SJ;


@Repository
public interface AppelDeJourRepository extends JpaRepository<AppelDeJour, Date> {
	AppelDeJour findByDatedujour(Date datedujour);
	@Query(value = "SELECT COUNT(*)FROM appel_de_jour_personnels c where personnels_id_personnel=?1 and EXTRACT(YEAR FROM NOW())-EXTRACT(YEAR FROM c.appels_datedujour)<=2", nativeQuery = true)
	public  int NbAbscenceparId(Long id);
	
//	@Query(value = "SELECT * from appel_de_jour_personnels c join personnel p on c.personnels_id_personnel=p.id_personnel join appel_de_jour a on c.appels_datedujour=a.datedujour where a.etat='Sansjusitf'", nativeQuery = true)
//	public  List<Personnel> ListeAbsenceSansJustifiaction();
	@Query(value = "SELECT p.nom,p.prenom,p.nom_AR,p.prenom_AR,p.poste_occupe,p.matricule,a.datedujour from appel_de_jour_personnels c join c.personnel p on c.personnels_id_personnel=p.id_personnel join c.appel_de_jour a on c.appels_datedujour=a.datedujour where a.etat='Sansjusitf' ", nativeQuery = true)
	public  ArrayList<Object> ListeAbsenceSansJustifiaction2();
	
}


