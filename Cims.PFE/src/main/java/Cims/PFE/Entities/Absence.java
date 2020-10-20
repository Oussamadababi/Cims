package Cims.PFE.Entities;

import java.time.LocalDateTime;
import java.util.Date;

public class Absence {
	private long id;
	private String nom;
	private String prenom;
	private String etat;
	private Date date;
	private int minute;
	private LocalDateTime  heureEntree;
	
	
	public LocalDateTime getHeureEntree() {
		return heureEntree;
	}
	public void setHeureEntree(LocalDateTime heureEntree) {
		this.heureEntree = heureEntree;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
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
	public Absence(long id,String nom, String prenom, Date date,String etat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.etat=etat;
	}
	public Absence(String nom, String prenom, Date date) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Absence(String nom, String prenom, Date date, int minute) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.minute = minute;
	}
	public Absence(String nom, String prenom, int minute, LocalDateTime heureEntree) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.minute = minute;
		this.heureEntree = heureEntree;
	}
	
	

}
