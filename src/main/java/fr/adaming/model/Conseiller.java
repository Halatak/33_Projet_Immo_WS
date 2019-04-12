package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Conseiller implements Serializable{
	private static final long serialVersionUID = 1L;
	// Attributs 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_co")
	private int id;
	private String mail;
	private String mdp;
	
	@ManyToOne
	@JoinColumn(name="roles_id",referencedColumnName="id_roles")
	@JsonIgnoreProperties("listeConseiller")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Role role;
	
	@OneToOne(mappedBy="conseiller")
	@JsonIgnoreProperties("conseiller")
	private Visite visite;
	
	// IL MANQUE L'ASSO AVEC ROLE 
	
	// Constructeurs
	public Conseiller() {
		super();
	}
	public Conseiller(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}
	public Conseiller(int id, String mail, String mdp) {
		super();
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
	}
	
	// Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	//To String
	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", mail=" + mail + ", mdp=" + mdp + "]";
	}
	
	
	
	

}
