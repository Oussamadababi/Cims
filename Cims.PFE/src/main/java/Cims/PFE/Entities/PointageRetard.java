package Cims.PFE.Entities;


import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PointageRetard")
public class PointageRetard {
	@Id
	@Temporal(TemporalType.DATE)
	private Date datedujour;


	@OneToMany(mappedBy="pointageRetard",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PointageRetardPersonnel> retard;

	public Date getDatedujour() {
		return datedujour;
	}

	public void setDatedujour(Date datedujour) {
		this.datedujour = datedujour;
	}

	
	public List<PointageRetardPersonnel> getRetard() {
		return retard;
	}

	public void setRetard(List<PointageRetardPersonnel> retard) {
		this.retard = retard;
	}

	public PointageRetard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PointageRetard(Date datedujour, List<PointageRetardPersonnel> retard) {
		super();
		this.datedujour = datedujour;
		this.retard = retard;
	}

	
	

}
