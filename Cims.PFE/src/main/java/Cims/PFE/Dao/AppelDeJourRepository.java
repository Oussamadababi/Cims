package Cims.PFE.Dao;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Cims.PFE.Entities.AppelDeJour;

@Repository
public interface AppelDeJourRepository extends JpaRepository<AppelDeJour, Date> {
	AppelDeJour findByDatedujour(Date datedujour);
	@Query(value = "SELECT COUNT(*)FROM appel_de_jour_personnels c where personnels_id_personnel=?1 and EXTRACT(YEAR FROM NOW())-EXTRACT(YEAR FROM c.appels_datedujour)<=2", nativeQuery = true)
	public  int NbAbscenceparId(Long id);
}


