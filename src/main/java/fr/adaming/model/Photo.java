package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ph")
	private int id;
	@Transient
	private String photo;
	@Lob
	private byte[] img;

	@ManyToOne
	@JoinColumn(name = "bimmo_id", referencedColumnName = "id_bimmo")
	@JsonIgnoreProperties("listePhoto")
	@LazyCollection(LazyCollectionOption.FALSE)
	private BienImmobilier bienImmo;

	// Constructeurs
	public Photo() {
		super();
	}

	public Photo(String photo, byte[] img) {
		super();
		this.photo = photo;
		this.img = img;
	}

	public Photo(int id, String photo, byte[] img) {
		super();
		this.id = id;
		this.photo = photo;
		this.img = img;
	}

	// Getters & Setters

	public int getId() {
		return id;
	}

	public BienImmobilier getBienImmo() {
		return bienImmo;
	}

	public void setBienImmo(BienImmobilier bienImmo) {
		this.bienImmo = bienImmo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", photo=" + photo + ", bienImmo=" + bienImmo + "]";
	}

	
}
