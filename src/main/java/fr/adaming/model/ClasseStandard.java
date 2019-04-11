package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="classes")
public class ClasseStandard implements Serializable{
	
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
	@OneToMany(mappedBy="classeStandard") 
	private List<BienImmobilier> listeBiensImmo;
	
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
	
	// To String
	@Override
	public String toString() {
		return "ClasseStandard [id=" + id + ", typeBien=" + typeBien + ", modeOffre=" + modeOffre + ", prixMax="
				+ prixMax + ", superficieMin=" + superficieMin + "]";
	} 
	
	
	

}
