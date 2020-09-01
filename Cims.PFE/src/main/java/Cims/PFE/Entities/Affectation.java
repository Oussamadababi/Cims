package Cims.PFE.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "affectation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Affectation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name="id_affectation")
	private Long id_affectation;
	
	@Column(name="nom_site")
	private String nomSite;
	
	@Column(name="nom_etablissement_fr")
	private String nom_etablissement_fr;
	
	@Column(name="nom_etablissement_ar")
	private String nom_etablissement_ar;
	
	@Column(name="nature_etablissement_fr")
	private String nature_etablissement_fr;
	
	@Column(name="nature_etablissement_ar")
	private String nature_etablissement_ar;
	
	@Column(name="qualite_direction_fr")
	private String qualite_direction_fr;
	
	@Column(name="qualite_direction_ar")
	private String qualite_direction_ar;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_gouvernorat", nullable = false)
	private Gouvernorat gouvernorat;

	
	@JsonIgnore
	@OneToMany(mappedBy = "site")
	 private List<AffectationPartielle> affectationp; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "site")
	 private List<AffectationTotale> affectationt; 
	
	@JsonIgnore
	@OneToMany(mappedBy="affectation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Personnel> pesonnel ;

public Affectation() {
	super();
	// TODO Auto-generated constructor stub
}



public Long getId_affectation() {
	return id_affectation;
}



public void setId_affectation(Long id_affectation) {
	this.id_affectation = id_affectation;
}



public String getNomSite() {
	return nomSite;
}

public void setNomSite(String nomSite) {
	this.nomSite = nomSite;
}

public Gouvernorat getGouvernorat() {
	return gouvernorat;
}


public void setGouvernorat(Gouvernorat gouvernorat) {
	this.gouvernorat = gouvernorat;
}


public void setAffectationp(List<AffectationPartielle> affectationp) {
	this.affectationp = affectationp;
}

public void setAffectationt(List<AffectationTotale> affectationt) {
	this.affectationt = affectationt;
}



public String getNom_etablissement_fr() {
	return nom_etablissement_fr;
}



public void setNom_etablissement_fr(String nom_etablissement_fr) {
	this.nom_etablissement_fr = nom_etablissement_fr;
}



public String getNom_etablissement_ar() {
	return nom_etablissement_ar;
}



public void setNom_etablissement_ar(String nom_etablissement_ar) {
	this.nom_etablissement_ar = nom_etablissement_ar;
}



public String getNature_etablissement_fr() {
	return nature_etablissement_fr;
}



public void setNature_etablissement_fr(String nature_etablissement_fr) {
	this.nature_etablissement_fr = nature_etablissement_fr;
}



public String getNature_etablissement_ar() {
	return nature_etablissement_ar;
}



public void setNature_etablissement_ar(String nature_etablissement_ar) {
	this.nature_etablissement_ar = nature_etablissement_ar;
}



public String getQualite_direction_fr() {
	return qualite_direction_fr;
}



public void setQualite_direction_fr(String qualite_direction_fr) {
	this.qualite_direction_fr = qualite_direction_fr;
}



public String getQualite_direction_ar() {
	return qualite_direction_ar;
}



public void setQualite_direction_ar(String qualite_direction_ar) {
	this.qualite_direction_ar = qualite_direction_ar;
}


public List<Personnel> getPesonnel() {
	return pesonnel;
}



public void setPesonnel(List<Personnel> pesonnel) {
	this.pesonnel = pesonnel;
}



public List<AffectationPartielle> getAffectationp() {
	return affectationp;
}



public List<AffectationTotale> getAffectationt() {
	return affectationt;
}



public Affectation(Long id_affectation, String nomSite, Gouvernorat gouvernorat, List<AffectationPartielle> affectationp,
		List<AffectationTotale> affectationt) {
	super();
	this.id_affectation = id_affectation;
	this.nomSite = nomSite;
	this.gouvernorat = gouvernorat;
	this.affectationp = affectationp;
	this.affectationt = affectationt;
}


public Affectation(Long id_affectation, String nomSite, String nom_etablissement_fr, String nom_etablissement_ar,
		String nature_etablissement_fr, String nature_etablissement_ar, String qualite_direction_fr,
		String qualite_direction_ar, Gouvernorat gouvernorat, List<AffectationPartielle> affectationp,
		List<AffectationTotale> affectationt, List<Personnel> pesonnel) {
	super();
	this.id_affectation = id_affectation;
	this.nomSite = nomSite;
	this.nom_etablissement_fr = nom_etablissement_fr;
	this.nom_etablissement_ar = nom_etablissement_ar;
	this.nature_etablissement_fr = nature_etablissement_fr;
	this.nature_etablissement_ar = nature_etablissement_ar;
	this.qualite_direction_fr = qualite_direction_fr;
	this.qualite_direction_ar = qualite_direction_ar;
	this.gouvernorat = gouvernorat;
	this.affectationp = affectationp;
	this.affectationt = affectationt;
	this.pesonnel = pesonnel;
}




@Override
public String toString() {
	return "Site [idSite=" + id_affectation + ", nomSite=" + nomSite + ", gouvernorat=" + gouvernorat + ", affectationp="
			+ affectationp + ", affectationt=" + affectationt + "]";
}



}
