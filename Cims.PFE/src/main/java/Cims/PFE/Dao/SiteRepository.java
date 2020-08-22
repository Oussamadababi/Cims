package Cims.PFE.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import Cims.PFE.Entities.Affectation;

@CrossOrigin("*")
@RepositoryRestResource
public interface SiteRepository  extends JpaRepository<Affectation,Long>{
@Query(value="SELECT * from site join gouvernorat using(id_gouv) where id_gouv=?1",nativeQuery = true)
List<Affectation> getss(Long id_gouv);

@Query(value="SELECT id_site from affectation_totale  where id_site=?1",nativeQuery = true)
List<Long> existsAffTotale(Long id);

@Query(value="SELECT * from site  where id_gouv=?1 and nom_site=?2",nativeQuery = true)
List<Affectation> getSite(Long id_gouv, String nom);

}
