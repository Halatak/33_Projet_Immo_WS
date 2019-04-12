package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Contrat implements Serializable{
	private static final long serialVersionUID = 1L;
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrat")
	private int id;
	private double prixAchat;
	@Temporal(TemporalType.DATE)
	private Date dateAchat;
	
	//Transformation de l'association UML en JAVA
	@ManyToOne
	@JoinColumn(name = "pr_id", referencedColumnName = "id_pr")
	@JsonIgnoreProperties("listeContrats")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Proprietaire proprietaire; 
	
	@ManyToOne
	@JoinColumn(name = "cl_id", referencedColumnName = "id_cl")
	@JsonIgnoreProperties("listeContrats")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Client client; 
	
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
	
	
	public Proprietaire getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	// To String
	@Override
	public String toString() {
		return "Contrat [id=" + id + ", prixAchat=" + prixAchat + ", dateAchat=" + dateAchat + "]";
	}
	
	

}
