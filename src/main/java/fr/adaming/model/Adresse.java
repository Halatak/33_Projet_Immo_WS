package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;
	// Attributs
	private String rue;
	private int numero;
	private int codePostal;
	private String ville;

	// Constructeurs
	public Adresse() {
		super();
	}

	public Adresse(String rue, int numero, int codePostal, String ville) {
		super();
		this.rue = rue;
		this.numero = numero;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	// Getters & setters
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", numero=" + numero + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

}
