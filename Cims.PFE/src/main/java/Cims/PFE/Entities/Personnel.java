package Cims.PFE.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity  
@Table(name="personnel",uniqueConstraints = { 
		@UniqueConstraint(columnNames = "email"),@UniqueConstraint(columnNames = "telephone")
	}) 
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name="discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Personnel")
public  class Personnel {
	@Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name="id_personnel")
	private Long id_personnel;
	
	@Column(name="matricule")
	private int matricule;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="sexe")
	private String sexe;
	
	@Column(name="telephone")
	private int telephone;
	
	@Column(name="date_recrutement")
	private LocalDate date_recrutement;
	
	@Column(name="email")
	@NotBlank
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dept", nullable = false)
	private Departement departement;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_grade", nullable = false)
	private Grade grade;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Compte compte;
	
	@OneToMany(mappedBy="personnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AffectationTotale> affectationt ;
	
	@OneToMany(mappedBy="personnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AffectationPartielle> affectationp ;
	
	
	@OneToMany(mappedBy="p", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Conge> Conges ;
	
	
	public Personnel() {
		
	}
	@Override
	public String toString() {
		return "Personnel [id_personnel=" + id_personnel + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe
				+ ", telephone=" + telephone + ", date_recrutement=" + date_recrutement + ", email=" + email
				+  ", user=" + compte + "]";
	}
	public Personnel(Long id_personnel, String nom, String prenom, String sexe, int telephone, LocalDate date_recrutement,
			String email,Departement departement,Grade grade, Compte compte) {
		super();
		this.id_personnel = id_personnel;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.telephone = telephone;
		this.date_recrutement = date_recrutement;
		this.email = email;
		this.departement = departement;
		this.grade = grade;
		this.compte = compte;
	}
	public Long getId_personnel() {
		return id_personnel;
	}

	public void setId_personnel(Long id_personnel) {
		this.id_personnel = id_personnel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	
	@JsonIgnore
	public List<AffectationTotale> getAffectationt() {
		return affectationt;
	}
	
	public void setAffectationt(List<AffectationTotale> affectationt) {
		this.affectationt = affectationt;
	}
	
	@JsonIgnore
	public List<AffectationPartielle> getAffectationp() {
		return affectationp;
	}
	public void setAffectationp(List<AffectationPartielle> affectationp) {
		this.affectationp = affectationp;
	}
	
	public Grade getGrade() {
		return grade;
	}
	
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	public LocalDate getDate_recrutement() {
		return date_recrutement;
	}

	public void setDate_recrutement(LocalDate date_recrutement) {
		this.date_recrutement = date_recrutement;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}


	@JsonIgnore
	public Compte getUser() {
		return compte;
	}
	public void setUser(Compte compte) {
		this.compte = compte;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	

	
	
	
	
	
	
	

}
