package Cims.PFE.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.Service1;
@Repository
public interface ServiceRepository extends JpaRepository<Service1, Long> {
	@Query(value="SELECT * FROM public.service where division_id_division=?1",nativeQuery = true)
	List<Service1> getServiceParDivision( long idDivision);
	
	
	

}
