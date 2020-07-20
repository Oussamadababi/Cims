package Cims.PFE.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import Cims.PFE.Entities.AffectationTotale;
import Cims.PFE.Entities.Personnel;
@CrossOrigin("*")
@RepositoryRestResource
public interface AffectationTotaleRepository extends JpaRepository<AffectationTotale, Long>{
	
	Boolean existsByPersonnel(Personnel p);
	
	@Query(value="SELECT id_personnel FROM personnel join affectation_totale using(id_personnel) ",nativeQuery = true)
	List<Long> getId();
	
	@Query(value="SELECT id_site from  affectation_totale where id_personnel=?1 ",nativeQuery = true)
	Long getSiteOfAffT(Long id_personnel);
	
}
