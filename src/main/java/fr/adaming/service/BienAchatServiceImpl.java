package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienAchatDao;
import fr.adaming.model.BienAchat;

@Service("bienAchatService")
@Transactional
public class BienAchatServiceImpl implements IBienAchatService{

	//transformation de l'association uml en java
	private IBienAchatDao baDao;
	
	//setter pour injection de dependance
	@Autowired
	public void setBaDao(IBienAchatDao baDao) {
		this.baDao = baDao;
		baDao.setClazz(BienAchat.class);
	}
	
	@Override
	public BienAchat getById(long id) {
		return baDao.getById(id);
	}

	@Override
	public List<BienAchat> getAll() {
		return baDao.getAll();
	}

	@Override
	public BienAchat ajout(BienAchat ba) {
		return baDao.ajout(ba);
	}

	@Override
	public BienAchat modifier(BienAchat ba) {
		return baDao.modifier(ba);
	}

	@Override
	public void suppr(BienAchat ba) {
		baDao.suppr(ba);
		
	}

	@Override
	public void supprById(long id) {
		baDao.supprById(id);
		
	}

}
