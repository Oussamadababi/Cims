package Cims.PFE.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity  
@Table(name="grade") 
@Proxy(lazy = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Grade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column(name="id_grade")
	private Long id_grade;
	
	@Column(name="nom_grade_fr")
	private String nom_grade_fr;
	
	@Column(name="nom_grade_ar")
	private String nom_grade_ar;
	
	@Column(name="categorie_grade_fr")
	private String categorie_grade_fr;
	
	@Column(name="categorie_grade_ar")
	private String categorie_grade_ar;
	
	public String getNom_grade_fr() {
		return nom_grade_fr;
	}
	public void setNom_grade_fr(String nom_grade_fr) {
		this.nom_grade_fr = nom_grade_fr;
	}
	public String getNom_grade_ar() {
		return nom_grade_ar;
	}
	public void setNom_grade_ar(String nom_grade_ar) {
		this.nom_grade_ar = nom_grade_ar;
	}
	public String getCategorie_grade_fr() {
		return categorie_grade_fr;
	}
	public void setCategorie_grade_fr(String categorie_grade_fr) {
		this.categorie_grade_fr = categorie_grade_fr;
	}
	public String getCategorie_grade_ar() {
		return categorie_grade_ar;
	}
	public void setCategorie_grade_ar(String categorie_grade_ar) {
		this.categorie_grade_ar = categorie_grade_ar;
	}
	public List<Personnel> getPersonnels() {
		return personnels;
	}
	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}
	@OneToMany(mappedBy="grade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Personnel> personnels ;


public Long getId_grade() {
	return id_grade;
}
public void setId_grade(Long id_grade) {
	this.id_grade = id_grade;
}
public Grade(Long id_grade, String nom_grade_fr, String nom_grade_ar, String categorie_grade_fr,
		String categorie_grade_ar, List<Personnel> personnels) {
	super();
	this.id_grade = id_grade;
	this.nom_grade_fr = nom_grade_fr;
	this.nom_grade_ar = nom_grade_ar;
	this.categorie_grade_fr = categorie_grade_fr;
	this.categorie_grade_ar = categorie_grade_ar;
	this.personnels = personnels;
}
public Grade() {
	super();
}






}
