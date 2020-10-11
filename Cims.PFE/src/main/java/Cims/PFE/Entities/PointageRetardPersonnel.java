package Cims.PFE.Entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "pointage_retard_personnels")
public class PointageRetardPersonnel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date datedujour;
	private LocalDateTime  heureEntree;
	@ManyToOne
	Personnel personnels;
	@ManyToOne
	PointageRetard pointageRetard;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatedujour() {
		return datedujour;
	}
	public void setDatedujour(Date datedujour) {
		this.datedujour = datedujour;
	}
	public LocalDateTime getHeureEntree() {
		return heureEntree;
	}
	public void setHeureEntree(LocalDateTime heureEntree) {
		this.heureEntree = heureEntree;
	}
	public Personnel getPersonnels() {
		return personnels;
	}
	public void setPersonnels(Personnel personnels) {
		this.personnels = personnels;
	}
	public PointageRetard getPointageRetard() {
		return pointageRetard;
	}
	public void setPointageRetard(PointageRetard pointageRetard) {
		this.pointageRetard = pointageRetard;
	}
	public PointageRetardPersonnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PointageRetardPersonnel(Long id, Date datedujour, LocalDateTime heureEntree, Personnel personnels,
			PointageRetard pointageRetard) {
		super();
		this.id = id;
		this.datedujour = datedujour;
		this.heureEntree = heureEntree;
		this.personnels = personnels;
		this.pointageRetard = pointageRetard;
	}
	public PointageRetardPersonnel(Long id, Date datedujour, LocalDateTime heureEntree) {
		super();
		this.id = id;
		this.datedujour = datedujour;
		this.heureEntree = heureEntree;
	}
	

}
