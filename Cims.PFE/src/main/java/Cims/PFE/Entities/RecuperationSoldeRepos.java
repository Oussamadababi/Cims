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
	@ManyToOne
	@JoinColumn(name = "Personnel_id", nullable = false)
	private Personnel p;

}
