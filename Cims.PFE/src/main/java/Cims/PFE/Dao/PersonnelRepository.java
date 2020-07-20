package Cims.PFE.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import Cims.PFE.Entities.Personnel;

@CrossOrigin("*")
@RepositoryRestResource
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
	Boolean existsByEmail(String email);

	@Query(value = "SELECT count(id_personnel) from personnel  ", nativeQuery = true)
	Long getNbrPersonnel();

	@Query(value = "SELECT * from personnel where id_grade=?1  ", nativeQuery = true)
	List<Personnel> getGrade(Long id);

	@Query(value = "SELECT * from personnel where id_dept=?1  ", nativeQuery = true)
	List<Personnel> getDept(Long id);

	Personnel findByMatricule(int matricule);

}
