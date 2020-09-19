package Cims.PFE.Dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.AppelDeJour;
import Cims.PFE.Entities.PointageRetard;
@Repository
public interface PointageRetardRepository extends JpaRepository<PointageRetard, Date> {
	PointageRetard findByDatedujour(Date datedujour);

}
