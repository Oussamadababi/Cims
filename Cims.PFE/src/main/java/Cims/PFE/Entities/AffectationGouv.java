package Cims.PFE.Entities;

public class AffectationGouv {
	
	private String nature;
	private String Gouvernorat;
	private String qualite;
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getGouvernorat() {
		return Gouvernorat;
	}
	public void setGouvernorat(String gouvernorat) {
		Gouvernorat = gouvernorat;
	}
	public String getQualite() {
		return qualite;
	}
	public void setQualite(String qualite) {
		this.qualite = qualite;
	}
	public AffectationGouv(String nature, String gouvernorat, String qualite) {
		super();
		this.nature = nature;
		Gouvernorat = gouvernorat;
		this.qualite = qualite;
	}
	
}
