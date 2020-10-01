package Cims.PFE.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cims.PFE.Entities.Conge;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Long> {

	@Query(value = "SELECT * from conge c join personnel p on c.id=p.id_personnel where p.matricule=?1  ", nativeQuery = true)
	List<Conge> congeparMatricule(int matricule);

	@Query(value = "SELECT * from conge c join personnel p on c.personnel_id=p.id_personnel where p.id_personnel=?1  ", nativeQuery = true)
	List<Conge> congeparPersonnel(long idPersonnel);

	@Query(value = "SELECT * FROM public.conge where personnel_id=?1 and etat='en-attente'", nativeQuery = true)
	Conge congeparPersonnelenattente(long idPersonnel);
	
	@Query(value = "SELECT * from conge c join personnel p on c.personnel_id=p.id_personnel where p.id_personnel=?1  ", nativeQuery = true)
	List<Conge> congeparPersonnelEnetatComfirmer(long idPersonnel);
	
	@Modifying
	@Query(value = "UPDATE public.conge SET etat=?1 WHERE id=?2", nativeQuery = true)
	public void ModifierEtatConge(String etat,long id);
	
	@Query(value = "SELECT * from conge c join personnel p on c.personnel_id=p.id_personnel where p.id_personnel=?1 and c.etat='accepter' ", nativeQuery = true)
	List<Conge> congeAccepterParIdpersonnel(long idPersonnel);
	@Query(value = "SELECT * from conge c join personnel p on c.personnel_id=p.id_personnel join appel_de_jour_personnels ap on ap.personnels_id_personnel=p.id_personnel where p.id_personnel=?1 and ?2 BETWEEN c.datedebut and c.datefin  ", nativeQuery = true)
	List<Conge> congeparPersonnelParDate(long idPersonnel,Date date);
}
