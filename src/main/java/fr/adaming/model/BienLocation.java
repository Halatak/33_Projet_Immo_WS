package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue(value = "Location")
@Entity
public class BienLocation extends BienImmobilier implements Serializable{

	// Attributs
	private double caution;
	private double loyerMensuel;
	private String typeBail;
	// garniture ==> meublé = true, non-meublé = false
	private boolean garniture;

	// Constructeurs
	public BienLocation() {
		super();
	}

	public BienLocation(String statut, Date dateSoumission, Date dateDispo, double revenu, Date dateVisite,
			String coordonneePersAgence, ClasseStandard classeStandard, double caution, double loyerMensuel,
			String typeBail, boolean garniture) {
		super(statut, dateSoumission, dateDispo, revenu, dateVisite, coordonneePersAgence, classeStandard);
		this.caution = caution;
		this.loyerMensuel = loyerMensuel;
		this.typeBail = typeBail;
		this.garniture = garniture;
	}

	public BienLocation(int id, String statut, Date dateSoumission, Date dateDispo, double revenu, Date dateVisite,
			String coordonneePersAgence, double caution, double loyerMensuel, String typeBail, boolean garniture) {
		super(id, statut, dateSoumission, dateDispo, revenu, dateVisite, coordonneePersAgence);
		this.caution = caution;
		this.loyerMensuel = loyerMensuel;
		this.typeBail = typeBail;
		this.garniture = garniture;
	}

	// Getters & setters
	public double getCaution() {
		return caution;
	}

	public void setCaution(double caution) {
		this.caution = caution;
	}

	public double getLoyerMensuel() {
		return loyerMensuel;
	}

	public void setLoyerMensuel(double loyerMensuel) {
		this.loyerMensuel = loyerMensuel;
	}

	public String getTypeBail() {
		return typeBail;
	}

	public void setTypeBail(String typeBail) {
		this.typeBail = typeBail;
	}

	public boolean isGarniture() {
		return garniture;
	}

	public void setGarniture(boolean garniture) {
		this.garniture = garniture;
	}

	// To String
	@Override
	public String toString() {
		return "BienLocation [caution=" + caution + ", loyerMensuel=" + loyerMensuel + ", typeBail=" + typeBail
				+ ", garniture=" + garniture + ", id=" + id + ", statut=" + statut + ", dateSoumission="
				+ dateSoumission + ", dateDispo=" + dateDispo + ", revenu=" + revenu + ", dateVisite=" + dateVisite
				+ ", coordonneePersAgence=" + coordonneePersAgence + "]";
	}



}
