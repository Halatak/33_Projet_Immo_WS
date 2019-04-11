package fr.adaming.model;

public class Conseiller {
	
	// Attributs 
	private int id;
	private String mail;
	private String mdp;
	
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
