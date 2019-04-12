package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;

public interface IClasseStandardDao extends IGeneriqueDao<ClasseStandard >{
	
	public List<ClasseStandard> recClasseParClient(Client client);

}
