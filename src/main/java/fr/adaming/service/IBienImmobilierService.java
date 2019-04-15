package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;
import fr.adaming.model.Proprietaire;

public interface IBienImmobilierService {

	public BienImmobilier getById(int id);

	public List<BienImmobilier> getAll();

	public BienImmobilier ajout(BienImmobilier bi);

	public BienImmobilier modifier(BienImmobilier bi);

	public void suppr(final BienImmobilier bi);

	public void supprById(final int id);
	
	public List<BienImmobilier> recBImmoParClasse(ClasseStandard classe);
	
	public List<BienImmobilier> recBImmoParProp(Proprietaire proprietaire);
	
	public List<BienImmobilier> recBImmoParClient(Client client);
	
	public List<BienImmobilier> recBImmoParType(String type);
	
}
