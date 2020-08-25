package Cims.PFE.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity  
@Table(name="Division") 
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Proxy(lazy = false)
public class Division {
	@Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name="id_division")
	private Long id_division;
	
	@Column(name="nom_divisionFr")
	private String nom_divisionFr;
	
	@Column(name="nom_divisionAr")
	private String nom_divisionAr;
	@ManyToOne
	private Structure structure;
	
	@OneToMany(mappedBy="division", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Service> Service ;

	public Long getId_division() {
		return id_division;
	}

	public void setId_division(Long id_division) {
		this.id_division = id_division;
	}

	public String getNom_divisionFr() {
		return nom_divisionFr;
	}

	public void setNom_divisionFr(String nom_divisionFr) {
		this.nom_divisionFr = nom_divisionFr;
	}

	public String getNom_divisionAr() {
		return nom_divisionAr;
	}

	public void setNom_divisionAr(String nom_divisionAr) {
		this.nom_divisionAr = nom_divisionAr;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public List<Service> getService() {
		return Service;
	}

	public void setService(List<Service> service) {
		Service = service;
	}

	public Division(Long id_division, String nom_divisionFr, String nom_divisionAr, Structure structure,
			List<Cims.PFE.Entities.Service> service) {
		super();
		this.id_division = id_division;
		this.nom_divisionFr = nom_divisionFr;
		this.nom_divisionAr = nom_divisionAr;
		this.structure = structure;
		Service = service;
	}

	public Division() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
