package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClasseStandard implements Serializable{
	private static final long serialVersionUID = 1L;
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_classe")
	private int id; //correspond au code de Classe
	private String typeBien;
	private String modeOffre; //à louer ou à acheter
	private double prixMax;
	private double superficieMin;
	
	//Transformation de l'association UML en JAVA
	@OneToMany(mappedBy="classeStandard", fetch=FetchType.EAGER) 
	@JsonIgnoreProperties("classeStandard")
	private List<BienImmobilier> listeBienImmobilier;
	
	@ManyToMany
	@JoinTable(name="tab_assoc", joinColumns=@JoinColumn(name="classe_id"),inverseJoinColumns=@JoinColumn(name="cl_id"))
	@JsonIgnoreProperties("listeClasseStandard")
	private List<Client> listeClient;
	
	// Constructeurs
	public ClasseStandard() {
		super();
	}
	public ClasseStandard(String typeBien, String modeOffre, double prixMax, double superficieMin) {
		super();
		this.typeBien = typeBien;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.superficieMin = superficieMin;
	}
	public ClasseStandard(int id, String typeBien, String modeOffre, double prixMax, double superficieMin) {
		super();
		this.id = id;
		this.typeBien = typeBien;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.superficieMin = superficieMin;
	}
	
	// Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeBien() {
		return typeBien;
	}
	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}
	public String getModeOffre() {
		return modeOffre;
	}
	public void setModeOffre(String modeOffre) {
		this.modeOffre = modeOffre;
	}
	public double getPrixMax() {
		return prixMax;
	}
	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}
	public double getSuperficieMin() {
		return superficieMin;
	}
	public void setSuperficieMin(double superficieMin) {
		this.superficieMin = superficieMin;
	}
	

	public List<BienImmobilier> getListeBienImmobilier() {
		return listeBienImmobilier;
	}
	public void setListeBienImmobilier(List<BienImmobilier> listeBienImmobilier) {
		this.listeBienImmobilier = listeBienImmobilier;
	}
	public List<Client> getListeClient() {
		return listeClient;
	}
	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}
	// To String
	@Override
	public String toString() {
		return "ClasseStandard [id=" + id + ", typeBien=" + typeBien + ", modeOffre=" + modeOffre + ", prixMax="
				+ prixMax + ", superficieMin=" + superficieMin + "]";
	} 
	
	
	

}
