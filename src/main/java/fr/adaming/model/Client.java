package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cl")
	private int id;
	private String nom;
	private String mail;
	private String mdp;
	private String telephone;

	// Transformation de l'association UML en JAVA
	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "roles_id", referencedColumnName = "id_roles")
	@JsonIgnoreProperties("listeClient")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Role role;

	@OneToMany(mappedBy = "client")
	@JsonIgnoreProperties("client")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Contrat> listeContrats;

	@ManyToMany(mappedBy = "listeClient",targetEntity = ClasseStandard.class)
	@JsonIgnoreProperties("listeClient")
	//@JsonBackReference
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ClasseStandard> listeClasseStandard;

	@ManyToMany(mappedBy = "listeClient",targetEntity=BienImmobilier.class)
	@JsonIgnoreProperties("listeClient")
	//@JsonBackReference
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<BienImmobilier> listeBienImmobilier;

	@OneToOne(mappedBy = "client")
	@JsonIgnoreProperties("client")
	private Visite visite;

	// IL MANQUE L'ASSO AVEC ROLE ET CLASSE STANDARD

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

	public Visite getVisite() {
		return visite;
	}

	public void setVisite(Visite visite) {
		this.visite = visite;
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

	public List<Contrat> getListeContrats() {
		return listeContrats;
	}

	public void setListeContrats(List<Contrat> listeContrats) {
		this.listeContrats = listeContrats;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<ClasseStandard> getListeClasseStandard() {
		return listeClasseStandard;
	}

	public void setListeClasseStandard(List<ClasseStandard> listeClasseStandard) {
		this.listeClasseStandard = listeClasseStandard;
	}

	public List<BienImmobilier> getListeBienImmobilier() {
		return listeBienImmobilier;
	}

	public void setListeBienImmobilier(List<BienImmobilier> listeBienImmobilier) {
		this.listeBienImmobilier = listeBienImmobilier;
	}

	// To String
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", mail=" + mail + ", mdp=" + mdp + ", telephone=" + telephone
				+ ", adresse=" + adresse + "]";
	}

}
