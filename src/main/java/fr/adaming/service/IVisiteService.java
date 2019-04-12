package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Visite;

public interface IVisiteService {
	
	public Visite getById(long id);

	public List<Visite> getAll();

	public Visite ajout(Visite v);

	public Visite modifier(Visite v);

	public void suppr(final Visite v);

	public void supprById(final long id);

}
