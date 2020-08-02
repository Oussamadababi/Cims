package Cims.PFE.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.RecuperationSoldeRepos;
@Repository
public interface RecuperationSoldeReposRepository extends JpaRepository<RecuperationSoldeRepos, Long>{

}
