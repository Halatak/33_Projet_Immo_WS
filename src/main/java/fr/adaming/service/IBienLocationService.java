package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienLocation;

public interface IBienLocationService {
	
	public BienLocation getById(int id);

	public List<BienLocation> getAll();

	public BienLocation ajout(BienLocation bl);

	public BienLocation modifier(BienLocation bl);

	public void suppr(final BienLocation bl);

	public void supprById(final int id);

}
