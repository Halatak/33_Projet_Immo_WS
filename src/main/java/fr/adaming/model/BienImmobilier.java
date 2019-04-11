package fr.adaming.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BienImmobilier {

	// Attributs
	private int id;
	private String statut;
	@Temporal(TemporalType.DATE)
	private Date dateSoumission;
	@Temporal(TemporalType.DATE)
	private Date dateDispo;
	private double revenu;
	@Temporal(TemporalType.DATE)
	private Date dateVisite;
	private String coordonneePersAgence;

	// Constructeurs
	public BienImmobilier() {
		super();
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

	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", statut=" + statut + ", dateSoumission=" + dateSoumission + ", dateDispo="
				+ dateDispo + ", revenu=" + revenu + ", dateVisite=" + dateVisite + ", coordonneePersAgence="
				+ coordonneePersAgence + "]";
	}

}
