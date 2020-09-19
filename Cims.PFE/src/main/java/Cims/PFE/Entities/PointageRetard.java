package Cims.PFE.Entities;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PointageRetard")
public class PointageRetard {
	@Id
	@Temporal(TemporalType.DATE)
	private Date datedujour;
	
	private Time heureEntree;

	@ManyToMany
	private List<Personnel> Personnels;

	public Date getDatedujour() {
		return datedujour;
	}

	public void setDatedujour(Date datedujour) {
		this.datedujour = datedujour;
	}



	public Time getHeureEntree() {
		return heureEntree;
	}

	public void setHeureEntree(Time heureEntree) {
		this.heureEntree = heureEntree;
	}

	public List<Personnel> getPersonnels() {
		return Personnels;
	}

	public void setPersonnels(List<Personnel> personnels) {
		Personnels = personnels;
	}

	public PointageRetard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
