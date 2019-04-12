package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienLocationDao;
import fr.adaming.model.BienLocation;

@Service("bienLocation")
@Transactional
public class BienLocationServiceImpl implements IBienLocationService{
	
	//transformation de l'association uml en java
	private IBienLocationDao blDao;
	
	//setter pour injection dependance
	@Autowired
	public void setBlDao(IBienLocationDao blDao) {
		this.blDao = blDao;
		blDao.setClazz(BienLocation.class);
	}

	@Override
	public BienLocation getById(int id) {
		return blDao.getById(id);
	}

	@Override
	public List<BienLocation> getAll() {
		return blDao.getAll();
	}

	@Override
	public BienLocation ajout(BienLocation bl) {
		return blDao.ajout(bl);
	}

	@Override
	public BienLocation modifier(BienLocation bl) {
		return blDao.modifier(bl);
	}

	@Override
	public void suppr(BienLocation bl) {
		blDao.suppr(bl);
		
	}

	@Override
	public void supprById(int id) {
		blDao.supprById(id);
		
	}

}
