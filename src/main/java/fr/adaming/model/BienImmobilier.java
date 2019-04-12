package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeBien")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BienImmobilier implements Serializable {
	private static final long serialVersionUID = 1L;
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bimmo")
	protected int id;
	protected String statut;
	@Temporal(TemporalType.DATE)
	protected Date dateSoumission;
	@Temporal(TemporalType.DATE)
	protected Date dateDispo;
	protected double revenu;
	protected String coordonneePersAgence;
	protected int nombreChambres;
	protected String latitude;
	protected String longitude;

	// Transformation de l'association UML en JAVA
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name = "classe_id", referencedColumnName = "id_classe")
	@JsonIgnoreProperties("listeBienImmobilier")
	@LazyCollection(LazyCollectionOption.FALSE)
	private ClasseStandard classeStandard;

	@ManyToOne
	@JoinColumn(name = "pr_id", referencedColumnName = "id_pr")
	@JsonIgnoreProperties("listeBiensImmo")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Proprietaire proprietaire;

	@ManyToMany(targetEntity = Client.class)
	@JoinTable(name = "tab_assoc2", joinColumns = @JoinColumn(name = "bimmo_id"), inverseJoinColumns = @JoinColumn(name = "cl_id"))
	// @JsonIgnoreProperties("listeBienImmobilier")
	@JsonManagedReference
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Client> listeClient;

	@OneToOne(mappedBy = "bienImmobilier")
	@JsonIgnoreProperties("bienImmobilier")
	private Visite visite;

	@OneToMany(mappedBy = "bienImmo")
	@JsonIgnoreProperties("bienImmo")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Photo> listePhoto;

	// Constructeurs
	public BienImmobilier() {
		super();
	}

	public BienImmobilier(String statut, Date dateSoumission, Date dateDispo, double revenu,
			String coordonneePersAgence, int nombreChambres, String latitude, String longitude, Adresse adresse) {
		super();
		this.statut = statut;
		this.dateSoumission = dateSoumission;
		this.dateDispo = dateDispo;
		this.revenu = revenu;
		this.coordonneePersAgence = coordonneePersAgence;
		this.nombreChambres = nombreChambres;
		this.latitude = latitude;
		this.longitude = longitude;
		this.adresse = adresse;
	}

	public BienImmobilier(int id, String statut, Date dateSoumission, Date dateDispo, double revenu,
			String coordonneePersAgence, int nombreChambres, String latitude, String longitude, Adresse adresse) {
		super();
		this.id = id;
		this.statut = statut;
		this.dateSoumission = dateSoumission;
		this.dateDispo = dateDispo;
		this.revenu = revenu;
		this.coordonneePersAgence = coordonneePersAgence;
		this.nombreChambres = nombreChambres;
		this.latitude = latitude;
		this.longitude = longitude;
		this.adresse = adresse;
	}

	// Getters & setters

	public int getId() {
		return id;
	}

	public Visite getVisite() {
		return visite;
	}

	public void setVisite(Visite visite) {
		this.visite = visite;
	}

	public List<Photo> getListePhoto() {
		return listePhoto;
	}

	public void setListePhoto(List<Photo> listePhoto) {
		this.listePhoto = listePhoto;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateSoumission() {
		return dateSoumission;
	}

	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public Date getDateDispo() {
		return dateDispo;
	}

	public void setDateDispo(Date dateDispo) {
		this.dateDispo = dateDispo;
	}

	public double getRevenu() {
		return revenu;
	}

	public void setRevenu(double revenu) {
		this.revenu = revenu;
	}

	public String getCoordonneePersAgence() {
		return coordonneePersAgence;
	}

	public void setCoordonneePersAgence(String coordonneePersAgence) {
		this.coordonneePersAgence = coordonneePersAgence;
	}

	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public int getNombreChambres() {
		return nombreChambres;
	}

	public void setNombreChambres(int nombreChambres) {
		this.nombreChambres = nombreChambres;
	}

	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}
	
	
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
		return "BienImmobilier [id=" + id + ", statut=" + statut + ", dateSoumission=" + dateSoumission + ", dateDispo="
				+ dateDispo + ", revenu=" + revenu + ", coordonneePersAgence=" + coordonneePersAgence
				+ ", nombreChambres=" + nombreChambres + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", adresse=" + adresse + ", proprietaire=" + proprietaire + "]";
	}



}
