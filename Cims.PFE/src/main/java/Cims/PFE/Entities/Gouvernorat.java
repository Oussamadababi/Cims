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

@Entity  
@Table(name="Gouvernorat")
public class Gouvernorat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name="idGouv")
	private Long idGouv;
	
	@Column(name="nomGouv")
	private String nomGouv;
	
	@OneToMany(mappedBy="gouvernorat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Site> Sites ;
	
	
	public Gouvernorat(Long idGouv, String nomGouv) {
		super();
		this.idGouv = idGouv;
		this.nomGouv = nomGouv;
		
	}
	public Gouvernorat() {
		super();
	}
	public Long getIdGouv() {
		return idGouv;
	}
	public void setIdGouv(Long idGouv) {
		this.idGouv = idGouv;
	}
	public String getNomGouv() {
		return nomGouv;
	}
	public void setNomGouv(String nomGouv) {
		this.nomGouv = nomGouv;
	}
	
	public void setSites(List<Site> sites) {
		Sites = sites;
	}
	@Override
	public String toString() {
		return "Gouvernorat [idGouv=" + idGouv + ", nomGouv=" + nomGouv + ", Sites=" + Sites + "]";
	}
	

}
