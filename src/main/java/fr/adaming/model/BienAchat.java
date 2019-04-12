package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue(value = "Achat")
@Entity
public class BienAchat extends BienImmobilier implements Serializable {
	private static final long serialVersionUID = 1L;
	// Attributs
	private double prix;
	private String etat;

	// Constructeurs
	public BienAchat() {
		super();
	}


	public BienAchat(String statut, Date dateSoumission, Date dateDispo, double revenu, String coordonneePersAgence,
			int nombreChambres, String latitude, String longitude, Adresse adresse, double prix, String etat) {
		super(statut, dateSoumission, dateDispo, revenu, coordonneePersAgence, nombreChambres, latitude, longitude,
				adresse);
		this.prix = prix;
		this.etat = etat;
	}


	public BienAchat(int id, String statut, Date dateSoumission, Date dateDispo, double revenu,
			String coordonneePersAgence, int nombreChambres, String latitude, String longitude, Adresse adresse,
			double prix, String etat) {
		super(id, statut, dateSoumission, dateDispo, revenu, coordonneePersAgence, nombreChambres, latitude, longitude,
				adresse);
		this.prix = prix;
		this.etat = etat;
	}


	// Getters & setters
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	// To String
	@Override
	public String toString() {
		return "BienAchat [prix=" + prix + ", etat=" + etat + ", id=" + id + ", statut=" + statut + ", dateSoumission="
				+ dateSoumission + ", dateDispo=" + dateDispo + ", revenu=" + revenu + ", coordonneePersAgence="
				+ coordonneePersAgence + ", nombreChambres=" + nombreChambres + "]";
	}




}
