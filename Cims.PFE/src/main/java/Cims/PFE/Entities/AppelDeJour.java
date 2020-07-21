package Cims.PFE.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(	name = "AppelDeJour")
public class AppelDeJour {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date datedujour;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Personnel> Personnels;
	
	private String Etat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatedujour() {
		return datedujour;
	}

	public void setDatedujour(Date datedujour) {
		this.datedujour = datedujour;
	}

	public List<Personnel> getPersonnels() {
		return Personnels;
	}

	public void setPersonnels(List<Personnel> personnels) {
		Personnels = personnels;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}
	
	
	

}
