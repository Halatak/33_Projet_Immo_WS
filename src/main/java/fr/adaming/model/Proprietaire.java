package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Proprietaire implements Serializable{
	private static final long serialVersionUID = 1L;
	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pr")
	private int id;
	private String nom;
	private String mail;
	private String mdp; 
	private String telephonePro;
	private String telephonePrive;
	
	//Transformation de l'association UML en JAVA
	@Embedded
	private Adresse adresse; 
	
	@OneToMany(mappedBy="proprietaire") 
	@JsonIgnoreProperties("proprietaire")
	private List<BienImmobilier> listeBiensImmo;
	
	@OneToMany(mappedBy="proprietaire") 
	@JsonIgnoreProperties("proprietaire")
	private List<Contrat> listeContrats; 
	
	// IL MANQUE L'ASSO AVEC ROLE 
	
	// Constructeurs
	public Proprietaire() {
		super();
	}
	public Proprietaire(String nom, String mail, String mdp, String telephonePro, String telephonePrive,
			Adresse adresse) {
		super();
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
		this.telephonePro = telephonePro;
		this.telephonePrive = telephonePrive;
		this.adresse = adresse;
	}
	public Proprietaire(int id, String nom, String mail, String mdp, String telephonePro, String telephonePrive,
			Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
		this.telephonePro = telephonePro;
		this.telephonePrive = telephonePrive;
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
	public String getTelephonePro() {
		return telephonePro;
	}
	public void setTelephonePro(String telephonePro) {
		this.telephonePro = telephonePro;
	}
	public String getTelephonePrive() {
		return telephonePrive;
	}
	public void setTelephonePrive(String telephonePrive) {
		this.telephonePrive = telephonePrive;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

	public List<BienImmobilier> getListeBiensImmo() {
		return listeBiensImmo;
	}
	public void setListeBiensImmo(List<BienImmobilier> listeBiensImmo) {
		this.listeBiensImmo = listeBiensImmo;
	}
	public List<Contrat> getListeContrats() {
		return listeContrats;
	}
	public void setListeContrats(List<Contrat> listeContrats) {
		this.listeContrats = listeContrats;
	}
	// To String
	@Override
	public String toString() {
		return "Proprietaire [id=" + id + ", nom=" + nom + ", mail=" + mail + ", mdp=" + mdp + ", telephonePro="
				+ telephonePro + ", telephonePrive=" + telephonePrive + ", adresse=" + adresse + "]";
	}
	

	
	
	

	

}
