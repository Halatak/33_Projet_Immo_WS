package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Proprietaire;

@Service("proprietaireService")
@Transactional
public class ProprietaireServiceImpl implements IPropritaireService{

	//transformation de l'association uml en java
	private IProprietaireDao propDao;
	
	//setter pour l'injection de dependance
	@Autowired
	public void setPropDao(IProprietaireDao propDao) {
		this.propDao = propDao;
		propDao.setClazz(Proprietaire.class);
	}

	@Override
	public Proprietaire getById(int id) {
		return propDao.getById(id);
	}

	@Override
	public List<Proprietaire> getAll() {
		return propDao.getAll();
	}

	@Override
	public Proprietaire ajout(Proprietaire p) {
		return propDao.ajout(p);
	}

	@Override
	public Proprietaire modifier(Proprietaire p) {
		return propDao.modifier(p);
	}

	@Override
	public void suppr(Proprietaire p) {
		propDao.suppr(p);
		
	}

	@Override
	public void supprById(int id) {
		propDao.supprById(id);
		
	}

}
