package Cims.PFE.Dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.AppelDeJour;
import Cims.PFE.Entities.Personnel;
import Cims.PFE.Entities.PointageRetard;
@Repository
public interface PointageRetardRepository extends JpaRepository<PointageRetard, Date> {
	PointageRetard findByDatedujour(Date datedujour);
	@Query(value = "select id_personnel from personnel EXCEPT   (select p.id_personnel FROM pointage_retard_personnels ap join pointage_retard a on ap.retard_datedujour= a.datedujour join personnel p on p.id_personnel=ap.personnels_id_personnel where a.datedujour=?1) ", nativeQuery = true)
	List<BigInteger> listNonRetardParJour(Date date);
	@Query(value = "SELECT * FROM pointage_retard_personnels ap join pointage_retard a on ap.retard_datedujour= a.datedujour join personnel p on p.id_personnel=ap.personnels_id_personnel where a.datedujour=?1 ", nativeQuery = true)
	List<Personnel> listRetardParJour(Date date);
}
