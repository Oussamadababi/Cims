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
@Table(name = "site")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Site implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name="id_site")
	private Long idSite;
	
	@Column(name="nom_site")
	private String nomSite;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idGouv", nullable = false)
	private Gouvernorat gouvernorat;

	@OneToMany(mappedBy = "site")
	 private List<AffectationPartielle> affectationp; 
	
	@OneToMany(mappedBy = "site")
	 private List<AffectationTotale> affectationt; 


public Site() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getIdSite() {
	return idSite;
}

public void setIdSite(Long idSite) {
	this.idSite = idSite;
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

public Site(Long idSite, String nomSite, Gouvernorat gouvernorat, List<AffectationPartielle> affectationp,
		List<AffectationTotale> affectationt) {
	super();
	this.idSite = idSite;
	this.nomSite = nomSite;
	this.gouvernorat = gouvernorat;
	this.affectationp = affectationp;
	this.affectationt = affectationt;
}

@Override
public String toString() {
	return "Site [idSite=" + idSite + ", nomSite=" + nomSite + ", gouvernorat=" + gouvernorat + ", affectationp="
			+ affectationp + ", affectationt=" + affectationt + "]";
}



}
