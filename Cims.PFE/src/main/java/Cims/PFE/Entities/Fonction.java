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
	
	@Column(name="structure")
	private String structure;
	
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

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Fonction(Long id_fonction, String fonction, String type_fonction, String structure) {
		super();
		this.id_fonction = id_fonction;
		this.fonction = fonction;
		this.type_fonction = type_fonction;
		this.structure = structure;
	}
	
	
	
	
	

}
