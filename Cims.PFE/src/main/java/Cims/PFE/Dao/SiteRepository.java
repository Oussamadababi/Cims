package Cims.PFE.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import Cims.PFE.Entities.Affectation;
import Cims.PFE.Entities.AffectationGouv;

@CrossOrigin("*")
@RepositoryRestResource
public interface SiteRepository  extends JpaRepository<Affectation,Long>{
@Query(value="SELECT * from affectation join gouvernorat using(id_gouv) where id_gouv=?1",nativeQuery = true)
List<Affectation> getss(Long id_gouv);

@Query(value="SELECT id_site from affectation_totale  where id_site=?1",nativeQuery = true)
List<Long> existsAffTotale(Long id);

@Query(value="SELECT * from affectation  where id_gouvernorat=?1 and nom_site=?2",nativeQuery = true)
List<Affectation> getSite(Long id_gouv, String nom);


@Query(value="SELECT  * FROM public.affectation a INNER JOIN public.gouvernorat g  on a.id_gouvernorat = g.id_gouv where id_affectation=?1",nativeQuery = true)
List<Object> getAttributForAffectation(Long id_aff);

@Query(value="SELECT NEW Cims.PFE.Entities.AffectationGouv ( a.nature_etablissement_fr,a.qualite_direction_fr,g.nomGouv) FROM Affectation a  JOIN a.gouvernorat g  where id_affectation=:id_aff")
public AffectationGouv getAttributForAffectation2(@Param("id_aff")Long id_aff);
}
