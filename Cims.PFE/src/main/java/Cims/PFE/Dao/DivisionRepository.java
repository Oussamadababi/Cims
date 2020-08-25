package Cims.PFE.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Cims.PFE.Entities.Division;


public interface DivisionRepository extends JpaRepository<Division, Long> {
	
	@Query(value="SELECT * from division  where  structure_id_dept=?1",nativeQuery = true)
	List<Division> getDivisionParStructure( long idStructure);

}
