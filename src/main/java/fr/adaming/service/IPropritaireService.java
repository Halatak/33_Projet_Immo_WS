package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IPropritaireService {
	
	public Proprietaire getById(int id);

	public List<Proprietaire> getAll();

	public Proprietaire ajout(Proprietaire p);

	public Proprietaire modifier(Proprietaire p);

	public void suppr(final Proprietaire p);

	public void supprById(final int id);

}
