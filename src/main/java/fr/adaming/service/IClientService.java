package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
	
	public Client getById(long id);

	public List<Client> getAll();

	public Client ajout(Client cl);

	public Client modifier(Client cl);

	public void suppr(final Client cl);

	public void supprById(final long id);

}
