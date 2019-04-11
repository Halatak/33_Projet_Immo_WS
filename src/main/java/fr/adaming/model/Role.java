package fr.adaming.model;

public class Role {
	
	// Attributs
	private int id;
	private String nomRole;
	
	// Constructeurs
	public Role() {
		super();
	}
	public Role(String nomRole) {
		super();
		this.nomRole = nomRole;
	}
	public Role(int id, String nomRole) {
		super();
		this.id = id;
		this.nomRole = nomRole;
	}
	
	// Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomRole() {
		return nomRole;
	}
	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
	
	

}
