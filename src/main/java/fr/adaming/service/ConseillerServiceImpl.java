package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Conseiller;

@Service("conseillerService")
@Transactional
public class ConseillerServiceImpl implements IConseillerService {

	//transformation uml en java
	private IConseillerDao consDao;

	//setter pour injection de dependance
	@Autowired
	public void setConsDao(IConseillerDao consDao) {
		this.consDao = consDao;
		consDao.setClazz(Conseiller.class);
	}

	@Override
	public Conseiller getById(long id) {
		return consDao.getById(id);
	}

	@Override
	public List<Conseiller> getAll() {
		return consDao.getAll();
	}

	@Override
	public Conseiller ajout(Conseiller cons) {
		return consDao.ajout(cons);
	}

	@Override
	public Conseiller modifier(Conseiller cons) {
		return consDao.modifier(cons);
	}

	@Override
	public void suppr(Conseiller cons) {
		consDao.suppr(cons);

	}

	@Override
	public void supprById(long id) {
		consDao.supprById(id);
	}

}
