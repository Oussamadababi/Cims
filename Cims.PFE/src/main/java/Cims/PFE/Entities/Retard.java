package Cims.PFE.Entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Retard {
private String nom;
private String prenom;
private LocalDateTime  heureEntree;
private int nbrMinuteRetard;
public Retard() {
	super();
	// TODO Auto-generated constructor stub
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
public LocalDateTime getHeureEntree() {
	return heureEntree;
}
public void setHeureEntree(LocalDateTime heureEntree) {
	this.heureEntree = heureEntree;
}
public int getNbrMinuteRetard() {
	return nbrMinuteRetard;
}
public void setNbrMinuteRetard(int nbrMinuteRetard) {
	this.nbrMinuteRetard = nbrMinuteRetard;
}

}
