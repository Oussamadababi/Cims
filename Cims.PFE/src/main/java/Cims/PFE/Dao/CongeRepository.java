package Cims.PFE.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.Conge;
@Repository
public interface CongeRepository  extends JpaRepository<Conge, Long>{

}
