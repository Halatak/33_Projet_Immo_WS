package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="contrats")
public class Contrat implements Serializable{
	
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrat")
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
