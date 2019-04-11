package fr.adaming.model;

import java.io.Serializable;

public class BienAchat extends BienImmobilier implements Serializable{

	// Attributs
	private double prix;
	private String etat;

	// Constructeurs
	public BienAchat() {
		super();
	}

	public BienAchat(double prix, String etat) {
		super();
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

	@Override
	public String toString() {
		return "BienAchat [prix=" + prix + ", etat=" + etat + "]";
	}

}
