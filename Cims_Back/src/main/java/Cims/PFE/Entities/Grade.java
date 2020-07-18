package Cims.PFE.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity  
@Table(name="grade") 
@Proxy(lazy = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Grade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column(name="id_grade")
	private Long id_grade;
	
	@Column(name="nom_grade")
	private String nom_grade;
	
	@OneToMany(mappedBy="grade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Personnel> personnels ;

   public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
public Grade(Long id_grade, String nom_grade) {
	super();
	this.id_grade = id_grade;
	this.nom_grade = nom_grade;
	//this.personnels = personnels;
}

public Long getId_grade() {
	return id_grade;
}
public void setId_grade(Long id_grade) {
	this.id_grade = id_grade;
}
public String getNom_grade() {
	return nom_grade;
}
public void setNom_grade(String nom_grade) {
	this.nom_grade = nom_grade;
}
@Override
public String toString() {
	return "Grade [id_grade=" + id_grade + ", nom_grade=" + nom_grade + ", personnels="  + "]";
}



}
