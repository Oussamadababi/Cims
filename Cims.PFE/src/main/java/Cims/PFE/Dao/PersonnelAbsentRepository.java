package Cims.PFE.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Cims.PFE.Entities.AppelJourPersonnel;
import Cims.PFE.Entities.Personnel;
import Cims.PFE.Entities.Pesonnel_Absent_SJ;

public interface PersonnelAbsentRepository extends JpaRepository<AppelJourPersonnel, Long> {

	 @Query(value = "select * from appel_de_jour_personnels ap where ap.personnels_id_personnel=? and ap.appel_de_jour_datedujour=?", nativeQuery
		 = true)
		 public AppelJourPersonnel getAppelJourPersonnel(long idPersonnel,Date date);
}
