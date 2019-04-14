package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;
import fr.adaming.model.Proprietaire;

public interface IBienImmobilierDao extends IGeneriqueDao<BienImmobilier >{
	
	public List<BienImmobilier> recBImmoParClasse(ClasseStandard classe);
	public List<BienImmobilier> recBImmoParProp(Proprietaire proprietaire);
	public List<BienImmobilier> recBImmoParClient(Client client);


}
