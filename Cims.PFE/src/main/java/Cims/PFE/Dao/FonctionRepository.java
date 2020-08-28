package Cims.PFE.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.Fonction;


@Repository
public interface FonctionRepository extends JpaRepository<Fonction, Long>{
	@Query(value="SELECT * from fonction  where  id_fonction=?1",nativeQuery = true)
	public Fonction getTypeFonction( Long id_fonction);

}
