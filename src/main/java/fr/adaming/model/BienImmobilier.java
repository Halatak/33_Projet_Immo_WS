package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeBien")

public class BienImmobilier implements Serializable{

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bimmo")
	protected int id;
	protected String statut;
	@Temporal(TemporalType.DATE)
	protected Date dateSoumission;
	@Temporal(TemporalType.DATE)
	protected Date dateDispo;
	protected double revenu;
	@Temporal(TemporalType.DATE)
	protected Date dateVisite;
	protected String coordonneePersAgence;
	
	//Transformation de l'association UML en JAVA
	@ManyToOne
	@JoinColumn(name = "classe_id", referencedColumnName = "id_classe")
	private ClasseStandard classeStandard;
	
	@ManyToOne
	@JoinColumn(name = "pr_id", referencedColumnName = "id_pr")
	private Proprietaire proprietaire;

	// Constructeurs
	public BienImmobilier() {
		super();
	}

	public BienImmobilier(String statut, Date dateSoumission, Date dateDispo, double revenu, Date dateVisite,
			String coordonneePersAgence, ClasseStandard classeStandard) {
		super();
		this.statut = statut;
		this.dateSoumission = dateSoumission;
		this.dateDispo = dateDispo;
		this.revenu = revenu;
		this.dateVisite = dateVisite;
		this.coordonneePersAgence = coordonneePersAgence;
		this.classeStandard = classeStandard;
	}

	public BienImmobilier(int id, String statut, Date dateSoumission, Date dateDispo, double revenu, Date dateVisite,
			String coordonneePersAgence) {
		super();
		this.id = id;
		this.statut = statut;
		this.dateSoumission = dateSoumission;
		this.dateDispo = dateDispo;
		this.revenu = revenu;
		this.dateVisite = dateVisite;
		this.coordonneePersAgence = coordonneePersAgence;
	}

	// Getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateSoumission() {
		return dateSoumission;
	}

	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public Date getDateDispo() {
		return dateDispo;
	}

	public void setDateDispo(Date dateDispo) {
		this.dateDispo = dateDispo;
	}

	public double getRevenu() {
		return revenu;
	}

	public void setRevenu(double revenu) {
		this.revenu = revenu;
	}

	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	public String getCoordonneePersAgence() {
		return coordonneePersAgence;
	}

	public void setCoordonneePersAgence(String coordonneePersAgence) {
		this.coordonneePersAgence = coordonneePersAgence;
	}

	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}
	

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	// To String

	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", statut=" + statut + ", dateSoumission=" + dateSoumission + ", dateDispo="
				+ dateDispo + ", revenu=" + revenu + ", dateVisite=" + dateVisite + ", coordonneePersAgence="
				+ coordonneePersAgence + "]";
	}

}
