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
@Table(name="Structure") 
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Proxy(lazy = false)
public class Structure {
	@Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name="id_dept")
	private Long id_dept;
	
	@Column(name="nom_dept")
	private String nom_dept;
	
	@Column(name="division")
	private String division;
	
	@Column(name="direction")
	private String direction;
	
	@Column(name="service")
	private String service;
	
	@OneToMany(mappedBy="departement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Personnel> personnels ;

	
	public Structure(Long id_dept, String nom_dept) {
		super();
		this.id_dept = id_dept;
		this.nom_dept = nom_dept;
		//this.personnels = personnels;
	}

	public Structure() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_dept() {
		return id_dept;
	}

	public void setId_dept(Long id_dept) {
		this.id_dept = id_dept;
	}

	public String getNom_dept() {
		return nom_dept;
	}

	public void setNom_dept(String nom_dept) {
		this.nom_dept = nom_dept;
	}

	

	

	 
}
