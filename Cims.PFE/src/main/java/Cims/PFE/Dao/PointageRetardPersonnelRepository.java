package Cims.PFE.Dao;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.Absence;
import Cims.PFE.Entities.PointageRetardPersonnel;

@Repository
public interface PointageRetardPersonnelRepository extends JpaRepository<PointageRetardPersonnel, Long> {
	@Query(value = "select id_personnel from personnel EXCEPT   (select p.id_personnel FROM pointage_retard_personnels ap join pointage_retard a on ap.pointage_retard_datedujour = a.datedujour join personnel p on p.id_personnel=ap.personnels_id_personnel where a.datedujour=?1) ", nativeQuery = true)
	List<BigInteger> listNonRetardParJour(Date date);

	@Query(value = "SELECT p.id_personnel FROM pointage_retard_personnels ap join pointage_retard a on ap.pointage_retard_datedujour= a.datedujour join personnel p on p.id_personnel=ap.personnels_id_personnel where a.datedujour=?1 ", nativeQuery = true)
	List<BigInteger> listRetardParJour(Date date);

	@Query(value = "select * from pointage_retard_personnels ap where ap.personnels_id_personnel=?1 and ap.pointage_retard_datedujour=?2", nativeQuery = true)
	public PointageRetardPersonnel getPointageRetardPersonnel(long idPersonnel, Date date);

	@Query(value = "SELECT NEW Cims.PFE.Entities.Absence (p.nom,p.prenom,p.NbrMinuteRetard,ap.heureEntree) FROM PointageRetardPersonnel  ap join ap.personnels p join ap.pointageRetard a  order by  a.datedujour")
	List<Absence> listRetard();

	@Query(value = "SELECT * FROM  pointage_retard_personnels   where personnels_id_personnel=?1 ", nativeQuery = true)
	List<PointageRetardPersonnel> ListeRetardParPersonnelId(long id);

	@Query(value = "SELECT heure_entree FROM pointage_retard_personnels  where personnels_id_personnel=?1 ", nativeQuery = true)
	List<Timestamp> ListeDesHeuresRetardParPersonnelId(Long id);
}
