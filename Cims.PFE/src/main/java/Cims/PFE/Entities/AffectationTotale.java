package Cims.PFE.Entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity  
@Table(name="AffectationTotale")
public class AffectationTotale{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column(name="id_affectationT")
	private Long idAffectT;
	
    @ManyToOne
    @JoinColumn(name = "id_site")
	private Affectation site;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_personnel")
	private Personnel personnel;
	
	

	public AffectationTotale(Long idAffectT, Affectation site, Cims.PFE.Entities.Personnel personnel) {
		super();
		this.idAffectT = idAffectT;
		this.site = site;
		this.personnel = personnel;
	}

	public AffectationTotale() {
	}

	public Long getIdAffectT() {
		return idAffectT;
	}

	public void setIdAffectT(Long idAffectT) {
		this.idAffectT = idAffectT;
	}

	public Affectation getSite() {
		return site;
	}

	public void setSite(Affectation site) {
		this.site = site;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	@Override
	public String toString() {
		return "Affectation [idAffectT=" + idAffectT + ", site=" + site + ", Personnel=" + personnel + "]";
	}
	

}
