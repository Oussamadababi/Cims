package Cims.PFE.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import Cims.PFE.Entities.Grade;

@CrossOrigin("*")
@RepositoryRestResource
public interface GradeRepository extends JpaRepository<Grade,Long> {
	@Query(value="SELECT * from grade  where  nom_grade_fr=?1",nativeQuery = true)
	List<Grade> getGrade( String nom);
}
