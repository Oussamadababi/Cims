
package Cims.PFE.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity  
@Table(name="Service") 
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Proxy(lazy = false)
public class Service1 {
	@Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name="id_Service")
	private Long id_Service;
	
	@Column(name="nom_ServiceFr")
	private String nom_ServiceFr;
	
	@Column(name="nom_ServiceAr")
	private String nom_ServiceAr;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Division division;

	public Long getId_Service() {
		return id_Service;
	}

	public void setId_Service(Long id_Service) {
		this.id_Service = id_Service;
	}

	public String getNom_ServiceFr() {
		return nom_ServiceFr;
	}

	public void setNom_ServiceFr(String nom_ServiceFr) {
		this.nom_ServiceFr = nom_ServiceFr;
	}

	public String getNom_ServiceAr() {
		return nom_ServiceAr;
	}

	public void setNom_ServiceAr(String nom_ServiceAr) {
		this.nom_ServiceAr = nom_ServiceAr;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}
	

}
