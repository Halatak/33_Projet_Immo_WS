package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client implements Serializable{
	
	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cl")
	private int id;
	private String nom;
	private String mail;
	private String mdp;
	private String telephone; 
	
	//Transformation de l'association UML en JAVA
	@Embedded
	private Adresse adresse; 
	
	// Constructeurs
	public Client() {
		super();
	}

	public Client(String nom, String mail, String mdp, String telephone, Adresse adresse) {
		super();
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
		this.telephone = telephone;
		this.adresse = adresse;
	}

	public Client(int id, String nom, String mail, String mdp, String telephone, Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
		this.telephone = telephone;
		this.adresse = adresse;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	// To String
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", mail=" + mail + ", mdp=" + mdp + ", telephone=" + telephone
				+ ", adresse=" + adresse + "]";
	}





	
	
	

}
