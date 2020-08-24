package Cims.PFE.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.Fonction;

@Repository
public interface FonctionRepository extends JpaRepository<Fonction, Long>{

}
