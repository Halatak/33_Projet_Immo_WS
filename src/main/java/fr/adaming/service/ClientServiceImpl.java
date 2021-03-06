package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.BienImmobilier;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements IClientService{

	//transformation de l'association uml en java
	private IClientDao clDao;
	
	//setter pour injection de dependance
	@Autowired
	public void setClDao(IClientDao clDao) {
		this.clDao = clDao;
		clDao.setClazz(Client.class);
	}

	@Override
	public Client getById(int id) {
		return clDao.getById(id);
	}

	@Override
	public List<Client> getAll() {
		return clDao.getAll();
	}

	@Override
	public Client ajout(Client cl) {
		return clDao.ajout(cl);
	}

	@Override
	public Client modifier(Client cl) {
		return clDao.modifier(cl);
	}

	@Override
	public void suppr(Client cl) {
		clDao.suppr(cl);		
	}

	@Override
	public void supprById(int id) {
		clDao.supprById(id);		
	}
	
	@Override
	public List<Client> recClientParClasse(ClasseStandard classe){
		return clDao.recClientParClasse(classe);
	}

	@Override
	public List<Client> recClientParBienImmo(BienImmobilier bimmo) {
		return clDao.recClientParBienImmo(bimmo);
	}


}
