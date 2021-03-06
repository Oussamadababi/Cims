package Cims.PFE.Dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.PointageRetard;
import Cims.PFE.Entities.PointageRetardPersonnel;
@Repository
public interface PointageRetardRepository extends JpaRepository<PointageRetard, Date> {
	PointageRetard findByDatedujour(Date datedujour);
//	@Query(value = "select id_personnel from personnel EXCEPT   (select p.id_personnel FROM pointage_retard_personnels ap join pointage_retard a on ap.retard_datedujour= a.datedujour join personnel p on p.id_personnel=ap.personnels_id_personnel where a.datedujour=?1) ", nativeQuery = true)
//	List<BigInteger> listNonRetardParJour(Date date);
//	@Query(value = "SELECT p.id_personnel FROM pointage_retard_personnels ap join pointage_retard a on ap.retard_datedujour= a.datedujour join personnel p on p.id_personnel=ap.personnels_id_personnel where a.datedujour=?1 ", nativeQuery = true)
//	List<BigInteger> listRetardParJour(Date date);
//	
//	@Query(value = "SELECT heure_entree FROM  pointage_retard a join pointage_retard_personnels p on a.datedujour=p.retard_datedujour where p.personnels_id_personnel=?1 ", nativeQuery = true)
//	List<Timestamp> ListeDesHeuresRetardParPersonnelId(Long id);
//	//SELECT heure_entree FROM  pointage_retard a join pointage_retard_personnels p on a.datedujour=p.retard_datedujour where p.personnels_id_personnel=?2
	@Query(value = "SELECT * FROM  pointage_retard_personnels   where personnels_id_personnel=?1 ", nativeQuery = true)
	List<PointageRetardPersonnel> ListeRetardParPersonnelId(long id);
//
//	
//	//HAchty beha requette hethy
//	///SELECT * FROM public.pointage_retard_personnels where retard_datedujour=?1 and personnels_id_personnel=?2;
//
}
