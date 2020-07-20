package Cims.PFE.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import Cims.PFE.Entities.Departement;
@CrossOrigin("*")
@RepositoryRestResource
public interface DepartementRepository extends JpaRepository<Departement,Long>{
	@Query(value="SELECT * from departement  where  nom_dept=?1",nativeQuery = true)
	List<Departement> getDept( String nom);
}
