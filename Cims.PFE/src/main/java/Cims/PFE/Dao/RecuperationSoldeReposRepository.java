package Cims.PFE.Dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Cims.PFE.Entities.RecuperationSoldeRepos;
@Repository
public interface RecuperationSoldeReposRepository extends JpaRepository<RecuperationSoldeRepos, Long>{

	@Query(value = "SELECT * FROM public.recuperation_solde_repos where titre_annee=?1 and personnel_id=?2 ", nativeQuery = true)
	List<RecuperationSoldeRepos> getRSRByDateAndIdPersonnel(String date,Long id);
	//SELECT * FROM public.recuperation_solde_repos where titre_annee=?1 and personnel_id=?2 ;
}
