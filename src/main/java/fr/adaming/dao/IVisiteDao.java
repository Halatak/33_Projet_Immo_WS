package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Visite;

public interface IVisiteDao extends IGeneriqueDao<Visite>{
	
	public List<Visite> recVisiteParConseiller(Conseiller conseiller);
	public List<Visite> recVisiteParClient(Client client);
	public List<Visite> recVisiteParBImmo(BienImmobilier bienImmobilier);
	

}
