package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Contrat;

public interface IContratService {
	
	public Contrat getById(long id);

	public List<Contrat> getAll();

	public Contrat ajout(Contrat cont);

	public Contrat modifier(Contrat cont);

	public void suppr(final Contrat cont);

	public void supprById(final long id);

}
