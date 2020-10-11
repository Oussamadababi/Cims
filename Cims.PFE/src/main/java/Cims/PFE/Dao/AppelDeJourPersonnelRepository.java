package Cims.PFE.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.AppelJourPersonnel;

@Repository
public interface AppelDeJourPersonnelRepository extends JpaRepository<AppelJourPersonnel, Long> {
	

}
