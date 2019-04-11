package fr.adaming.model;

import java.io.Serializable;

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

	public BienLocation(double caution, double loyerMensuel, String typeBail, boolean garniture) {
		super();
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

	@Override
	public String toString() {
		return "BienLocation [caution=" + caution + ", loyerMensuel=" + loyerMensuel + ", typeBail=" + typeBail
				+ ", garniture=" + garniture + "]";
	}

}
