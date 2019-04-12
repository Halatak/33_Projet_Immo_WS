package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienAchat;

public interface IBienAchatService {
	
	public BienAchat getById(int id);

	public List<BienAchat> getAll();

	public BienAchat ajout(BienAchat ba);

	public BienAchat modifier(BienAchat ba);

	public void suppr(final BienAchat ba);

	public void supprById(final int id);
	

}
