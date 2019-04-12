package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Visite;

public interface IVisiteService {
	
	public Visite getById(int id);

	public List<Visite> getAll();

	public Visite ajout(Visite v);

	public Visite modifier(Visite v);

	public void suppr(final Visite v);

	public void supprById(final int id);
	
	public List<Visite> recVisiteParConseiller(Conseiller conseiller);
	
	public List<Visite> recVisiteParClient(Client client);
	
	public List<Visite> recVisiteParBImmo(BienImmobilier bienImmobilier);

}
