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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Mission") 
public class Mission {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name="idMission")
	private Long idMission;
	
	@Column(name="heureDepart")
	private String heureDepart;
	
	@Column(name="heureArrivee")
	private String heureArrivee;
	
	@Column(name="date")
	private LocalDate date;
	
	@OneToMany(mappedBy = "Mission", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<OrdreMission> ordreMissions; 
	
	@ManyToOne
    @JoinColumn(name = "id_affectation_p")
	private AffectationPartielle affectationPartielle ;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Files file;
	
	@Column(name="etat_accomplie")
	private boolean etat_accomplie;
	
	public Long getIdMission() {
		return idMission;
	}
	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}
	public String getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}
	public String getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Mission() {
		super();
	}
	
	@JsonIgnore
	public List<OrdreMission> getOrdreMissions() {
		return ordreMissions;
	}
	public void setOrdreMissions(List<OrdreMission> ordreMissions) {
		this.ordreMissions = ordreMissions;
	}
	
	public AffectationPartielle getAffectationPartielle() {
		return affectationPartielle;
	}
	public void setAffectationPartielle(AffectationPartielle affectationPartielle) {
		this.affectationPartielle = affectationPartielle;
	}
	
	 @Transactional
	public Files getFile() {
		return file;
	}
	public void setFile(Files file) {
		this.file = file;
	}
	
	
	public boolean isEtat_accomplie() {
		return etat_accomplie;
	}
	public void setEtat_accomplie(boolean etat_accomplie) {
		this.etat_accomplie = etat_accomplie;
	}
	public Mission(String heureDepart, String heureArrivee, LocalDate date, List<OrdreMission> ordreMissions,
			AffectationPartielle affectationPartielle , Files file
			, boolean etat_accomplie) {
		super();
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.date = date;
		this.ordreMissions = ordreMissions;
		this.affectationPartielle = affectationPartielle;
		this.file = file;
		this.etat_accomplie = etat_accomplie;
	}
	
	@Override
	public String toString() {
		return "Mission [idMission=" + idMission + ", heureDepart=" + heureDepart + ", heureArrivee=" + heureArrivee
				+ ", date=" + date + ", ordreMissions=" + ordreMissions + ", affectationPartielle="
				+ affectationPartielle + "]";
	}
	}