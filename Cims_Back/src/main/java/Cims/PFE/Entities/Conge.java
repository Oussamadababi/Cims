package Cims.PFE.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Type_conge Typedeconge;
	
	@Column(name = "datedemande")
	@Temporal(TemporalType.DATE)
	private Date datedemande;
	
	@Column(name = "datedebut")
	@Temporal(TemporalType.DATE)
	private Date datedebut;
	
	@Column(name = "datefin")
	@Temporal(TemporalType.DATE)
	private Date datefin;
	
	@Column(name = "Etat")
	private String Etat;
	
	
	@ManyToOne
	@JoinColumn(name = "Personnel_id", nullable = false)
	private Personnel p;	
}
