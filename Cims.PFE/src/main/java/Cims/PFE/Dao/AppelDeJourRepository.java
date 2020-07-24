package Cims.PFE.Dao;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Cims.PFE.Entities.AppelDeJour;

@Repository
public interface AppelDeJourRepository extends JpaRepository<AppelDeJour, Date> {
	AppelDeJour findByDatedujour(Date datedujour);
	@Query(value = "SELECT COUNT(*) FROM public.appel_de_jour_personnels where personnels_id_personnel=?1  ", nativeQuery = true)
	public  int NbAbscenceparId(Long id);
}


