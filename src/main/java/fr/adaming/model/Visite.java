package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Visite implements Serializable{
	private static final long serialVersionUID = 1L;
	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vi")
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dateVisite;
	@Temporal(value = TemporalType.TIME)
	private Date heureVisite;
	
	@OneToOne
	@JoinColumn(name="cl_id", referencedColumnName="id_cl")
	private Client client; 
	
	@OneToOne
	@JoinColumn(name="co_id", referencedColumnName="id_co")
	private Conseiller conseiller; 
	
	@OneToOne
	@JoinColumn(name="bimmo_id", referencedColumnName="id_bimmo")
	private BienImmobilier bienImmobilier;
	
	
	// Déclaration des constructeurs
	public Visite() {
		super();
	}

	public Visite(Date dateVisite, Date heureVisite, Client client, Conseiller conseiller,
			BienImmobilier bienImmobilier) {
		super();
		this.dateVisite = dateVisite;
		this.heureVisite = heureVisite;
		this.client = client;
		this.conseiller = conseiller;
		this.bienImmobilier = bienImmobilier;
	}

	public Visite(int id, Date dateVisite, Date heureVisite, Client client, Conseiller conseiller,
			BienImmobilier bienImmobilier) {
		super();
		this.id = id;
		this.dateVisite = dateVisite;
		this.heureVisite = heureVisite;
		this.client = client;
		this.conseiller = conseiller;
		this.bienImmobilier = bienImmobilier;
	}
	
	// Getters & Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	public Date getHeureVisite() {
		return heureVisite;
	}

	public void setHeureVisite(Date heureVisite) {
		this.heureVisite = heureVisite;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}

	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}

	
	// To String
	@Override
	public String toString() {
		return "Visite [id=" + id + ", dateVisite=" + dateVisite + ", heureVisite=" + heureVisite + ", client=" + client
				+ ", conseiller=" + conseiller + ", bienImmobilier=" + bienImmobilier + "]";
	} 
	
	
	
	
}
