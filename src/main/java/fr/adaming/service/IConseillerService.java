package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Conseiller;

public interface IConseillerService {
	
	public Conseiller getById(int id);

	public List<Conseiller> getAll();

	public Conseiller ajout(Conseiller cons);

	public Conseiller modifier(Conseiller cons);

	public void suppr(final Conseiller cons);

	public void supprById(final int id);

}
