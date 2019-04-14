package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;

public interface IClientDao extends IGeneriqueDao<Client> {
	
	public List<Client> recClientParClasse(ClasseStandard classe);
	public List<Client> recClientParBienImmo(BienImmobilier bimmo);

}
