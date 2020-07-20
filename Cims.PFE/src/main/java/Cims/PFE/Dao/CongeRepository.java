package Cims.PFE.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.Conge;
@Repository
public interface CongeRepository  extends JpaRepository<Conge, Long>{
	
	@Query(value = "SELECT * from conge c join personnel p on c.id=p.id_personnel where p.matricule=?1  ", nativeQuery = true)
	List<Conge>congeparMatricule(int matricule);

}
