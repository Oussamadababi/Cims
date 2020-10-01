package Cims.PFE.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "AppelDeJour")
public class AppelDeJour {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private Long id;
	@Id
	@Temporal(TemporalType.DATE)
	private Date datedujour;
	@OneToMany(mappedBy="appelDeJour", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AppelJourPersonnel> appelJourPersonnel;

	private String etat;

	public Date getDatedujour() {
		return datedujour;
	}

	public void setDatedujour(Date datedujour) {
		this.datedujour = datedujour;
	}


	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

<<<<<<< HEAD
	public List<AppelJourPersonnel> getAppelJourPersonnel() {
		return appelJourPersonnel;
	}

	public void setAppelJourPersonnel(List<AppelJourPersonnel> appelJourPersonnel) {
		this.appelJourPersonnel = appelJourPersonnel;
	}
=======

>>>>>>> branch 'master' of https://github.com/Oussamadababi/Cims.git

}
