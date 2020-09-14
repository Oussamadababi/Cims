package Cims.PFE.Entities;

import java.io.Serializable;
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
import javax.persistence.ManyToMany;
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
public  class Personnel implements Serializable {
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
	
	@Column(name="solderepos")
	private double soldeRepos;
	
	@Column(name="soldereposN_1")
	private double soldeReposN_1;
	
	@Column(name="soldereposN_2")
	private double soldeReposN_2;
	
	@Column(name="soldeexceptionnel")
	private double soldeExceptionnel;
	
	@Column(name="soldeCompensation")
	private double soldeCompensation;
	
	@Column(name="date_recrutement")
	private LocalDate date_recrutement;
	
	@Column(name="email")
	@NotBlank
	private String email;
	
	@Column(name="nom_Ar")
	private String nom_AR;
	
	@Column(name="prenom_AR")
	private String prenom_AR;
	
	@Column(name="matricule_CNRPS")
	private int matricule_CNRPS;
	
	@Column(name="matricule_CNSS")
	private int matricule_CNSS;
	
	@Column(name="date_Naissance")
	private LocalDate date_Naissance;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="poste_Occupe")
	private String poste_Occupe;
	
	@Column(name="date_Promotion")
	private LocalDate date_Promotion;
	
	@Column(name="echelle")
	private String echelle;
	
	@Column(name="date_Echelle")
	private LocalDate date_Echelle;
	
	@Column(name="echellon")
	private String echellon;
	
	@Column(name="date_Echellon")
	private LocalDate date_Echellon;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dept", nullable = false)
	private Structure departement;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_grade", nullable = false)
	private Grade grade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Compte compte;
	
	@OneToMany(mappedBy="personnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
    private List<AffectationTotale> affectationt ;
	
	@OneToMany(mappedBy="personnel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
    private List<AffectationPartielle> affectationp ;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="p", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Conge> Conges ;
	
	@ManyToMany(mappedBy="Personnels",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
    private List<AppelDeJour> appels ;
	
	@JsonIgnore
	@OneToMany(mappedBy="p", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RecuperationSoldeRepos> ListRecupSoldeRepos ;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fonction_id", nullable = false)
	@JsonIgnore
	private Fonction fonction;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "affectation_id", nullable = false)
	@JsonIgnore
	private Affectation affectation;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service1_id", nullable = false)
	@JsonIgnore
	Service1 service1;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "division_id", nullable = false)
	@JsonIgnore
	Division division;
	
	
	public Service1 getService1() {
		return service1;
	}
	public void setService1(Service1 service1) {
		this.service1 = service1;
	}
	public Division getDivision() {
		return division;
	}
	public void setDivision(Division division) {
		this.division = division;
	}
	public Affectation getAffectation() {
		return affectation;
	}
	public void setAffectation(Affectation affectation) {
		this.affectation = affectation;
	}
	public Personnel() {
		
	}
	@Override
	public String toString() {
		return "Personnel [id_personnel=" + id_personnel + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe
				+ ", telephone=" + telephone + ", date_recrutement=" + date_recrutement + ", email=" + email
				+  ", user=" + compte + "]";
	}
	public Personnel(Long id_personnel, String nom, String prenom, String sexe, int telephone, LocalDate date_recrutement,
			String email,Structure departement,Grade grade, Compte compte) {
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
	

	
	public double getSoldeCompensation() {
		return soldeCompensation;
	}
	public void setSoldeCompensation(double soldeCompensation) {
		this.soldeCompensation = soldeCompensation;
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


	public Structure getDepartement() {
		return departement;
	}


	public void setDepartement(Structure departement) {
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
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	
	
	public double getSoldeRepos() {
		return soldeRepos;
	}
	public void setSoldeRepos(double soldeRepos) {
		this.soldeRepos = soldeRepos;
	}
	public double getSoldeExceptionnel() {
		return soldeExceptionnel;
	}
	public void setSoldeExceptionnel(double soldeExceptionnel) {
		this.soldeExceptionnel = soldeExceptionnel;
	}
	
	
	
	
	public double getSoldeReposN_1() {
		return soldeReposN_1;
	}
	public void setSoldeReposN_1(double soldeReposN_1) {
		this.soldeReposN_1 = soldeReposN_1;
	}
	public double getSoldeReposN_2() {
		return soldeReposN_2;
	}
	public void setSoldeReposN_2(double soldeReposN_2) {
		this.soldeReposN_2 = soldeReposN_2;
	}
	public String getNom_AR() {
		return nom_AR;
	}
	public void setNom_AR(String nom_AR) {
		this.nom_AR = nom_AR;
	}
	public String getPrenom_AR() {
		return prenom_AR;
	}
	public void setPrenom_AR(String prenom_AR) {
		this.prenom_AR = prenom_AR;
	}
	public int getMatricule_CNRPS() {
		return matricule_CNRPS;
	}
	public void setMatricule_CNRPS(int matricule_CNRPS) {
		this.matricule_CNRPS = matricule_CNRPS;
	}
	public int getMatricule_CNSS() {
		return matricule_CNSS;
	}
	public void setMatricule_CNSS(int matricule_CNSS) {
		this.matricule_CNSS = matricule_CNSS;
	}
	public LocalDate getDate_Naissance() {
		return date_Naissance;
	}
	public void setDate_Naissance(LocalDate date_Naissance) {
		this.date_Naissance = date_Naissance;
	}
	public String getPoste_Occupe() {
		return poste_Occupe;
	}
	public void setPoste_Occupe(String poste_Occupe) {
		this.poste_Occupe = poste_Occupe;
	}
	public LocalDate getDate_Promotion() {
		return date_Promotion;
	}
	public void setDate_Promotion(LocalDate date_Promotion) {
		this.date_Promotion = date_Promotion;
	}
	public String getEchelle() {
		return echelle;
	}
	public void setEchelle(String echelle) {
		this.echelle = echelle;
	}
	public LocalDate getDate_Echelle() {
		return date_Echelle;
	}
	public void setDate_Echelle(LocalDate date_Echelle) {
		this.date_Echelle = date_Echelle;
	}
	public String getEchellon() {
		return echellon;
	}
	public void setEchellon(String echellon) {
		this.echellon = echellon;
	}
	public LocalDate getDate_Echellon() {
		return date_Echellon;
	}
	public void setDate_Echellon(LocalDate date_Echellon) {
		this.date_Echellon = date_Echellon;
	}

	public Fonction getFonction() {
		return fonction;
	}
	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}
	public List<AppelDeJour> getAppels() {
		return appels;
	}
	public void setAppels(List<AppelDeJour> appels) {
		this.appels = appels;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Personnel(Long id_personnel, int matricule, String nom, String prenom, String sexe, int telephone,
			int soldeRepos, int soldeExceptionnel, LocalDate date_recrutement, @NotBlank String email) {
		super();
		this.id_personnel = id_personnel;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.telephone = telephone;
		this.soldeRepos = soldeRepos;
		this.soldeExceptionnel = soldeExceptionnel;
		this.date_recrutement = date_recrutement;
		this.email = email;
	}
	public Personnel(Long id_personnel, int matricule, String nom, String prenom, String sexe, int telephone,
			double soldeRepos, double soldeReposN_1, double soldeReposN_2, double soldeExceptionnel,
			LocalDate date_recrutement, @NotBlank String email, String nom_AR, String prenom_AR, int matricule_CNRPS,
			int matricule_CNSS, LocalDate date_Naissance, String adresse, String poste_Occupe, LocalDate date_Promotion,
			String echelle, LocalDate date_Echelle, String echellon, LocalDate date_Echellon, Structure departement,
			Grade grade, Compte compte, List<AffectationTotale> affectationt, List<AffectationPartielle> affectationp,
			List<Conge> conges, List<AppelDeJour> appels, List<RecuperationSoldeRepos> listRecupSoldeRepos,
			Fonction fonction, Affectation affectation) {
		super();
		this.id_personnel = id_personnel;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.telephone = telephone;
		this.soldeRepos = soldeRepos;
		this.soldeReposN_1 = soldeReposN_1;
		this.soldeReposN_2 = soldeReposN_2;
		this.soldeExceptionnel = soldeExceptionnel;
		this.date_recrutement = date_recrutement;
		this.email = email;
		this.nom_AR = nom_AR;
		this.prenom_AR = prenom_AR;
		this.matricule_CNRPS = matricule_CNRPS;
		this.matricule_CNSS = matricule_CNSS;
		this.date_Naissance = date_Naissance;
		this.adresse = adresse;
		this.poste_Occupe = poste_Occupe;
		this.date_Promotion = date_Promotion;
		this.echelle = echelle;
		this.date_Echelle = date_Echelle;
		this.echellon = echellon;
		this.date_Echellon = date_Echellon;
		this.departement = departement;
		this.grade = grade;
		this.compte = compte;
		this.affectationt = affectationt;
		this.affectationp = affectationp;
		Conges = conges;
		this.appels = appels;
		ListRecupSoldeRepos = listRecupSoldeRepos;
		this.fonction = fonction;
		this.affectation = affectation;
	}
	
	
	
	
	
	
	

	

	
	
	
	
	
	
	

}