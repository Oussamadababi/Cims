package Cims.PFE.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.AppelJourPersonnel;

@Repository
public interface AppelDeJourPersonnelRepository extends JpaRepository<AppelJourPersonnel, Long> {
	//UPDATE public.appel_de_jour_personnels SET etat=?1 WHERE id=;
	@Query(value = "UPDATE public.appel_de_jour_personnels SET etat=?1 WHERE id=?2", nativeQuery = true)
	public  void JustifierlAbsence(String etat,Long id);
	

}
