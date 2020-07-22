package Cims.PFE.Dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.AppelDeJour;
import Cims.PFE.Entities.Personnel;
@Repository
public interface AppelDeJourRepository extends JpaRepository<AppelDeJour, Date> {
	AppelDeJour findByDatedujour(Date datedujour);
}
