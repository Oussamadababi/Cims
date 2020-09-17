package Cims.PFE.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Cims.PFE.Entities.Pesonnel_Absent_SJ;

public interface Pesonnel_Absent_SJRepository extends JpaRepository<Pesonnel_Absent_SJ, Long> {
	@Query(value = "SELECT NEW Cims.PFE.Entities.Pesonnel_Absent_SJ (p.nom,p.prenom,p.nom_AR,p.prenom_AR,p.poste_Occupe,p.matricule,p.id_personnel,a.datedujour) from appel_de_jour_personnels c join personnel p on c.personnels_id_personnel=p.id_personnel join appel_de_jour a on c.appels_datedujour=a.datedujour where a.etat='Sansjusitf';")
	public  List<Pesonnel_Absent_SJ> ListeAbsenceSansJustifiaction();

}
