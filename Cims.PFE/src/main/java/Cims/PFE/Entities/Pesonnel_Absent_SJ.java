package Cims.PFE.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class Pesonnel_Absent_SJ implements Serializable{
	

	
	private String nom;
	

	private String prenom;
	
	
	private String nom_AR;
	
	
	private String prenom_AR;
	

	private String poste_Occupe;
	
	
	private int matricule;
	
	
	private Long id_personnel;
	@Temporal(TemporalType.DATE)
	private Date datedujour;

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom_AR() {
		return nom_AR;
	}
	public void setNom_AR(String nom_AR) {
		this.nom_AR = nom_AR;
	}
	public String getPrenom_AR() {
		return prenom_AR;
	}
	public void setPrenom_AR(String prenom_AR) {
		this.prenom_AR = prenom_AR;
	}
	public String getPoste_Occupe() {
		return poste_Occupe;
	}
	public void setPoste_Occupe(String poste_Occupe) {
		this.poste_Occupe = poste_Occupe;
	}
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public Date getDatedujour() {
		return datedujour;
	}
	public void setDatedujour(Date datedujour) {
		this.datedujour = datedujour;
	}
	
	
	public Long getId_personnel() {
		return id_personnel;
	}
	public void setId_personnel(Long id_personnel) {
		this.id_personnel = id_personnel;
	}
	
	
	public Pesonnel_Absent_SJ( String nom, String prenom, String nom_AR, String prenom_AR, String poste_Occupe,
			int matricule, Long id_personnel, Date datedujour) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nom_AR = nom_AR;
		this.prenom_AR = prenom_AR;
		this.poste_Occupe = poste_Occupe;
		this.matricule = matricule;
		this.id_personnel = id_personnel;
		this.datedujour = datedujour;
	}
	public Pesonnel_Absent_SJ() {
		super();
	}
	

}
