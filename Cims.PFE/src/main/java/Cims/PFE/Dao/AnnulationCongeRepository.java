package Cims.PFE.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.AnnulationConge;


@Repository
public interface AnnulationCongeRepository extends JpaRepository<AnnulationConge, Long> {
	@Modifying
	@Query(value = "UPDATE public.annulation_conge SET  etat=?1 WHERE id=?2", nativeQuery = true)
	public void ModifierEtatAnulationConge(String etat,long id);

}
