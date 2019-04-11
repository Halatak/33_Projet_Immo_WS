package fr.adaming.model;

public class Proprietaire {
	
	// Déclaration des attributs
	private int id;
	private String nom;
	private String mail;
	private String mdp; 
	private String telephonePro;
	private String telephonePrive;
	
	// Constructeurs
	public Proprietaire() {
		super();
	}
	public Proprietaire(String nom, String mail, String mdp, String telephonePro, String telephonePrive) {
		super();
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
		this.telephonePro = telephonePro;
		this.telephonePrive = telephonePrive;
	}
	public Proprietaire(int id, String nom, String mail, String mdp, String telephonePro, String telephonePrive) {
		super();
		this.id = id;
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
		this.telephonePro = telephonePro;
		this.telephonePrive = telephonePrive;
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
	
	// To String
	@Override
	public String toString() {
		return "Proprietaire [id=" + id + ", nom=" + nom + ", mail=" + mail + ", mdp=" + mdp + ", telephonePro="
				+ telephonePro + ", telephonePrive=" + telephonePrive + "]";
	}
	
	
	

	

}
