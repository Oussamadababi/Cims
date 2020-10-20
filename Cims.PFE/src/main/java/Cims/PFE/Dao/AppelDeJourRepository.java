package Cims.PFE.Dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.Absence;
import Cims.PFE.Entities.AppelDeJour;



@Repository
public interface AppelDeJourRepository extends JpaRepository<AppelDeJour, Date> {
	AppelDeJour findByDatedujour(Date datedujour);


	//@Query(value = "SELECT COUNT(*)FROM appel_de_jour_personnels c where personnels_id_personnel=?1 and EXTRACT(YEAR FROM NOW())-EXTRACT(YEAR FROM c.appels_datedujour)<=2", nativeQuery = true)
	//public int NbAbscenceparId(Long id);

	// @Query(value = "SELECT * from appel_de_jour_personnels c join personnel p
	// on c.personnels_id_personnel=p.id_personnel join appel_de_jour a on
	// c.appels_datedujour=a.datedujour where a.etat='Sansjusitf'", nativeQuery
	// = true)
	// public List<Personnel> ListeAbsenceSansJustifiaction();
	//@Query(value = "SELECT * from appel_de_jour_personnels c join personnel p on c.personnels_id_personnel=p.id_personnel join appel_de_jour a on c.appels_datedujour=a.datedujour where a.etat='Sansjusitf' order by a.datedujour ", nativeQuery = true)
	//public List<Object> ListeAbsenceSansJustifiaction2();


	@Query(value = "SELECT COUNT(*)FROM appel_de_jour_personnels c where personnels_id_personnel=?1 and EXTRACT(YEAR FROM NOW())-EXTRACT(YEAR FROM c.appel_de_jour_datedujour)<=2", nativeQuery = true)
	public  int NbAbscenceparId(Long id);
	
	@Query(value = "SELECT NEW Cims.PFE.Entities.Absence (ap.id,p.nom,p.prenom,a.datedujour,ap.mail) FROM AppelJourPersonnel  ap join ap.personnels p join ap.appelDeJour a where  ap.etat='non justifié' order by  a.datedujour")
	List<Absence> listAbsenceSansJusftication();
	
	@Query(value = "SELECT NEW Cims.PFE.Entities.Absence (p.nom,p.prenom,a.datedujour) FROM AppelJourPersonnel  ap join ap.personnels p join ap.appelDeJour a where  ap.etat='non justifié' and ap.mail='non-reçu' order by  a.datedujour")
	List<Absence> listAbsenceSansJusfticationEtNonMailing();
	
	@Query(value = "SELECT a.id FROM  appel_de_jour_personnels a join personnel p on a.personnels_id_personnel=p.id_personnel where p.nom=?1 and p.prenom=?2 and a.appel_de_jour_datedujour=?3", nativeQuery = true)
	public BigInteger ListeIdAbsenceParNomPrenomDate(String nom,String Prenom,Date date);
	
	// SELECT id FROM  appel_de_jour_personnels a join personnel p on a.personnels_id_personnel=p.id_personnel where p.nom=?1 and p.prenom=?2 and a.appel_de_jour_datedujour=?3 ;
	
	
	
	

}
