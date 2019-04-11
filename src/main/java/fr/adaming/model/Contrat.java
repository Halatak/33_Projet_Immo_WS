package fr.adaming.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Contrat {
	
	// Attributs
	private int id;
	private double prixAchat;
	@Temporal(TemporalType.DATE)
	private Date dateAchat;
	
	// Constructeurs
	public Contrat() {
		super();
	}
	public Contrat(double prixAchat, Date dateAchat) {
		super();
		this.prixAchat = prixAchat;
		this.dateAchat = dateAchat;
	}
	public Contrat(int id, double prixAchat, Date dateAchat) {
		super();
		this.id = id;
		this.prixAchat = prixAchat;
		this.dateAchat = dateAchat;
	}
	
	// Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	
	// To String
	@Override
	public String toString() {
		return "Contrat [id=" + id + ", prixAchat=" + prixAchat + ", dateAchat=" + dateAchat + "]";
	}
	
	

}
