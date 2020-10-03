package Cims.PFE.Entities;

public class Absence {
	private long id;
	private String nom;
	private String prenom;
	private String etat;
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
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Absence(String nom, String prenom, String etat) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.etat = etat;
	}
	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Absence(long id, String nom, String prenom, String etat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.etat = etat;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	

}
