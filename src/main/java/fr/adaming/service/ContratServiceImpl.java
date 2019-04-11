package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;
import fr.adaming.model.Contrat;

@Service("contratService")
@Transactional
public class ContratServiceImpl implements IContratService{

	//transformation uml en java
	private IContratDao contDao;
		
	//setter pour injection de dependance
	@Autowired
	public void setContDao(IContratDao contDao) {
		this.contDao = contDao;
		contDao.setClazz(Contrat.class);
	}

	@Override
	public Contrat getById(long id) {
		return contDao.getById(id);
	}

	@Override
	public List<Contrat> getAll() {
		return contDao.getAll();
	}

	@Override
	public Contrat ajout(Contrat cont) {
		return contDao.ajout(cont);
	}

	@Override
	public Contrat modifier(Contrat cont) {
		return contDao.modifier(cont);
	}

	@Override
	public void suppr(Contrat cont) {
		contDao.suppr(cont);
		
	}

	@Override
	public void supprById(long id) {
		contDao.supprById(id);		
	}

}
