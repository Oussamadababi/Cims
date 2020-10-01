package Cims.PFE.Entities;

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
/**
 * @author Iheb
 *
 */
@Entity
@Table(name = "appel_de_jour_personnels")
public class AppelJourPersonnel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	Personnel personnels;
	@ManyToOne
	AppelDeJour appelDeJour;
	private String etat;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Personnel getPersonnels() {
		return personnels;
	}
	public void setPersonnels(Personnel personnels) {
		this.personnels = personnels;
	}
	public AppelDeJour getAppelDeJour() {
		return appelDeJour;
	}
	public void setAppelDeJour(AppelDeJour appelDeJour) {
		this.appelDeJour = appelDeJour;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public AppelJourPersonnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppelJourPersonnel(Long id, Personnel personnels, AppelDeJour appelDeJour, String etat) {
		super();
		this.id = id;
		this.personnels = personnels;
		this.appelDeJour = appelDeJour;
		this.etat = etat;
	}

}
