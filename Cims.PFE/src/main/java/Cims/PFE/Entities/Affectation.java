package Cims.PFE.Entities;

import java.io.Serializable;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "affectation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Affectation implements Serializable{
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
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idGouv", nullable = false)
	private Gouvernorat gouvernorat;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idGouv_ar", nullable = false)
	private Gouvernorat gouvernorat_ar;

	@OneToMany(mappedBy = "site")
	 private List<AffectationPartielle> affectationp; 
	
	@OneToMany(mappedBy = "site")
	 private List<AffectationTotale> affectationt; 


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

public Affectation(Long id_affectation, String nomSite, Gouvernorat gouvernorat, List<AffectationPartielle> affectationp,
		List<AffectationTotale> affectationt) {
	super();
	this.id_affectation = id_affectation;
	this.nomSite = nomSite;
	this.gouvernorat = gouvernorat;
	this.affectationp = affectationp;
	this.affectationt = affectationt;
}

@Override
public String toString() {
	return "Site [idSite=" + id_affectation + ", nomSite=" + nomSite + ", gouvernorat=" + gouvernorat + ", affectationp="
			+ affectationp + ", affectationt=" + affectationt + "]";
}



}
