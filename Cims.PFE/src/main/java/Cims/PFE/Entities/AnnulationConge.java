package Cims.PFE.Entities;

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
	@Temporal(TemporalType.DATE)
	private Date datedemande;

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
	@OneToOne
	Conge conge;

	public Conge getConge() {
		return conge;
	}

	public void setConge(Conge conge) {
		this.conge = conge;
	}
	
	
}
