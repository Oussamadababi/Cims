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
	

	@Column(name="nomGouv_ar")
	private String nomGouv_ar;

	
	@OneToMany(mappedBy="gouvernorat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Affectation> Sites ;
	
	
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
	
	public void setSites(List<Affectation> sites) {
		Sites = sites;
	}
	
	
	public String getNomGouv_ar() {
		return nomGouv_ar;
	}
	public void setNomGouv_ar(String nomGouv_ar) {
		this.nomGouv_ar = nomGouv_ar;
	}
	public List<Affectation> getSites() {
		return Sites;
	}
	@Override
	public String toString() {
		return "Gouvernorat [idGouv=" + idGouv + ", nomGouv=" + nomGouv + ", Sites=" + Sites + "]";
	}
	

}
