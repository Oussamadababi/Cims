package Cims.PFE.Dao;

import java.util.List;

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
	@Query(value = "SELECT *FROM public.annulation_conge a join conge c on a.conge_id=c.id where c.personnel_id=?1 and a.etat='En_attente'", nativeQuery = true)
	public AnnulationConge AnulationCongeenattente(long idPersonnel);
	@Query(value = "SELECT * FROM public.annulation_conge  where conge_id=?1", nativeQuery = true)
	public  AnnulationConge AnulationConge(long idPersonnel);
	@Query(value = "SELECT *FROM public.annulation_conge a join conge c on a.conge_id=c.id where c.personnel_id=?1 ", nativeQuery = true)
	public List<AnnulationConge> AnulationCongeParPersonne(long idPersonnel);

}
