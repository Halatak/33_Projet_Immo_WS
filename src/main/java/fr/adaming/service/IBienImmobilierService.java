package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilier;

public interface IBienImmobilierService {

	public BienImmobilier getById(long id);

	public List<BienImmobilier> getAll();

	public BienImmobilier ajout(BienImmobilier bi);

	public BienImmobilier modifier(BienImmobilier bi);

	public void suppr(final BienImmobilier bi);

	public void supprById(final long id);
	
}
