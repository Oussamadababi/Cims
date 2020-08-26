package Cims.PFE.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  
@Table(name="Fonction") 
public class Fonction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column(name="id_fonction")
	private Long id_fonction;
	
	@Column(name="fonction")
	private String fonction;
	
	@Column(name="type_fonction")
	private String type_fonction;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "structure_id", nullable = false)
	private Structure structure;
	
	@Column(name="date_fonction")
	private LocalDate date_fonction;
	
	@OneToMany(mappedBy="fonction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Personnel> pesonnel ;

	public Long getId_fonction() {
		return id_fonction;
	}

	public void setId_fonction(Long id_fonction) {
		this.id_fonction = id_fonction;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getType_fonction() {
		return type_fonction;
	}

	public void setType_fonction(String type_fonction) {
		this.type_fonction = type_fonction;
	}

	

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public LocalDate getDate_fonction() {
		return date_fonction;
	}

	public void setDate_fonction(LocalDate date_fonction) {
		this.date_fonction = date_fonction;
	}

	public List<Personnel> getPesonnel() {
		return pesonnel;
	}

	public void setPesonnel(List<Personnel> pesonnel) {
		this.pesonnel = pesonnel;
	}

	public Fonction(Long id_fonction, String fonction, String type_fonction, Structure structure,
			LocalDate date_fonction) {
		super();
		this.id_fonction = id_fonction;
		this.fonction = fonction;
		this.type_fonction = type_fonction;
		this.structure = structure;
		this.date_fonction = date_fonction;
	}

	public Fonction() {
		super();
	}
	

	
	
	
	
	
	

}
