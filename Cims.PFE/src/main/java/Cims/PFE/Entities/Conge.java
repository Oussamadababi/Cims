package Cims.PFE.Entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "conge")
public class Conge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Typedeconge")
	@Enumerated(EnumType.STRING)
	private Type_conge typedeconge;

	@Column(name = "datedemande")
	@Temporal(TemporalType.DATE)
	private Date datedemande;

	@Column(name = "datedebut")
	private LocalDate datedebut;

	@Column(name = "datefin")
	private LocalDate datefin;
	@Column(name = "numDeJour")
	private int numDeJour;

	@Column(name = "Etat")
	private String etat;

	@ManyToOne
	@JoinColumn(name = "Personnel_id", nullable = false)
	private Personnel p;

	@OneToOne(mappedBy = "conge", cascade = CascadeType.ALL)
	private AnnulationConge annulationConge;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Type_conge getTypedeconge() {
		return typedeconge;
	}

	public void setTypedeconge(Type_conge typedeconge) {
		this.typedeconge = typedeconge;
	}

	public Date getDatedemande() {
		return datedemande;
	}

	public void setDatedemande(Date datedemande) {
		this.datedemande = datedemande;
	}

	public LocalDate getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(LocalDate datedebut) {
		this.datedebut = datedebut;
	}

	public LocalDate getDatefin() {
		return datefin;
	}

	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
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

	public Conge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conge(Long id, Type_conge typedeconge, Date datedemande, LocalDate datedebut, LocalDate datefin, String etat,
			Personnel p) {
		super();
		this.id = id;
		this.typedeconge = typedeconge;
		this.datedemande = datedemande;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.etat = etat;
		this.p = p;
	}

	public Conge(Long id, Type_conge typedeconge, Date datedemande, LocalDate datedebut, LocalDate datefin,
			int numDeJour, String etat, Personnel p) {
		super();
		this.id = id;
		this.typedeconge = typedeconge;
		this.datedemande = datedemande;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.numDeJour = numDeJour;
		this.etat = etat;
		this.p = p;
	}
	

}
