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

}
