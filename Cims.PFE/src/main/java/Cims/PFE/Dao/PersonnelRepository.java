package Cims.PFE.Dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import Cims.PFE.Entities.Absence;
import Cims.PFE.Entities.Personnel;

@CrossOrigin("*")
@RepositoryRestResource
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
	Boolean existsByEmail(String email);

	@Query(value = "SELECT count(id_personnel) from personnel  ", nativeQuery = true)
	Long getNbrPersonnel();

	@Query(value = "SELECT * from personnel where id_grade=?1  ", nativeQuery = true)
	List<Personnel> getGrade(Long id);

	@Query(value = "SELECT * from personnel where id_dept=?1  ", nativeQuery = true)
	List<Personnel> getDept(Long id);

	Personnel findByMatricule(int matricule);

	@Query(value = "SELECT * FROM appel_de_jour_personnels ap join appel_de_jour a on ap.appel_de_jour_datedujour= a.datedujour join personnel p on p.id_personnel=ap.personnels_id_personnel where a.datedujour=?1 ", nativeQuery = true)
	List<Personnel> listAbsenceParJour(Date date);
	@Query(value = "select id_personnel from personnel EXCEPT   (SELECT p.id_personnel FROM appel_de_jour_personnels ap join appel_de_jour a on ap.appel_de_jour_datedujour= a.datedujour join personnel p on p.id_personnel=ap.personnels_id_personnel where a.datedujour=?1) ", nativeQuery = true)
	List<BigInteger> listNonAbsenceParJour(Date date);
	@Query(value = "SELECT NEW Cims.PFE.Entities.Absence (p.nom,p.prenom,ap.etat) FROM AppelJourPersonnel  ap join ap.personnels p join ap.appelDeJour a where a.datedujour=:dates ")
	List<Absence> listAbsenceParJour2(@Param("dates")Date date);
	

}
