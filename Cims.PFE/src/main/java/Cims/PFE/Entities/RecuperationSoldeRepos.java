package Cims.PFE.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name = "recuperationSoldeRepos")
public class RecuperationSoldeRepos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "datedemande")
	@Temporal(TemporalType.DATE)
	private Date datedemande;
	@Column(name = "Etat")
	private String etat;
	@Column(name = "TitreAnnee")
	private String TitreAnnee;
	@Column(name = "soldeRecuperer")
	private double SoldeRecuperer;
	@ManyToOne
	@JoinColumn(name = "Personnel_id", nullable = false)
	private Personnel p;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatedemande() {
		return datedemande;
	}
	public void setDatedemande(Date datedemande) {
		this.datedemande = datedemande;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Personnel getP() {
		return p;
	}
	public void setP(Personnel p) {
		this.p = p;
	}
	public String getTitreAnnee() {
		return TitreAnnee;
	}
	public void setTitreAnnee(String titreAnnee) {
		TitreAnnee = titreAnnee;
	}
	public double getSoldeRecuperer() {
		return SoldeRecuperer;
	}
	public void setSoldeRecuperer(double soldeRecuperer) {
		SoldeRecuperer = soldeRecuperer;
	}
	

	

	
}
