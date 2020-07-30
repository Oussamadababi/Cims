package Cims.PFE.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.AnnulationConge;


@Repository
public interface AnnulationCongeRepository extends JpaRepository<AnnulationConge, Long> {

}
