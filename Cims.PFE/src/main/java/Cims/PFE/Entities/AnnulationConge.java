package Cims.PFE.Entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "annulation_conge")
public class AnnulationConge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date")
	private LocalDate datedemande;
	
	@Column(name = "Etat")
	private String etat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatedemande() {
		return datedemande;
	}

	public void setDatedemande(LocalDate datedemande) {
		this.datedemande = datedemande;
	}

	@OneToOne
	Conge conge;

	public Conge getConge() {
		return conge;
	}

	public void setConge(Conge conge) {
		this.conge = conge;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public AnnulationConge(Long id, LocalDate datedemande, String etat, Conge conge) {
		super();
		this.id = id;
		this.datedemande = datedemande;
		this.etat = etat;
		this.conge = conge;
	}

	public AnnulationConge() {
		super();
	}
	
	
}
