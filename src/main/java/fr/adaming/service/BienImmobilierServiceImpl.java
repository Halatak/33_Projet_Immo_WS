package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienImmobilierDao;
import fr.adaming.model.BienImmobilier;

@Service("bienImmobilierService")
@Transactional
public class BienImmobilierServiceImpl implements IBienImmobilierService{
	
	//transformation uml en java
	private IBienImmobilierDao bienImmoDao;
	
	//setter pour injection de dependance
	@Autowired
	public void setBienImmoDao(IBienImmobilierDao bienImmoDao) {
		this.bienImmoDao = bienImmoDao;
		bienImmoDao.setClazz(BienImmobilier.class);
	}

	@Override
	public BienImmobilier getById(long id) {
		return bienImmoDao.getById(id);
	}

	@Override
	public List<BienImmobilier> getAll() {
		return bienImmoDao.getAll();
	}

	@Override
	public BienImmobilier ajout(BienImmobilier bi) {
		return bienImmoDao.ajout(bi);
	}

	@Override
	public BienImmobilier modifier(BienImmobilier bi) {
		return bienImmoDao.modifier(bi);
	}

	@Override
	public void suppr(BienImmobilier bi) {
		bienImmoDao.suppr(bi);
		
	}

	@Override
	public void supprById(long id) {
		bienImmoDao.supprById(id);
		
	}

}
