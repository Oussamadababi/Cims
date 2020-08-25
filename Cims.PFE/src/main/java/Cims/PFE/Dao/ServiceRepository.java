package Cims.PFE.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.Service;
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}
