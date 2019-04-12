package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Visite;

@Service("visiteService")
@Transactional
public class VisiteServiceImpl implements IVisiteService{
	
	//transformation de l'association uml en java
	private IVisiteDao vDao;
	
	//setter pour injection de dependance
	public void setvDao(IVisiteDao vDao) {
		this.vDao = vDao;
		vDao.setClazz(Visite.class);
	}

	@Override
	public Visite getById(long id) {
		return vDao.getById(id);
	}

	@Override
	public List<Visite> getAll() {
		return vDao.getAll();
	}

	@Override
	public Visite ajout(Visite v) {
		return vDao.ajout(v);
	}

	@Override
	public Visite modifier(Visite v) {
		return vDao.modifier(v);
	}

	@Override
	public void suppr(Visite v) {
		vDao.suppr(v);
		
	}

	@Override
	public void supprById(long id) {
		vDao.supprById(id);
		
	}

	@Override
	public List<Visite> recVisiteParConseiller(Conseiller conseiller) {
		return vDao.recVisiteParConseiller(conseiller);
	}

	@Override
	public List<Visite> recVisiteParClient(Client client) {
		return vDao.recVisiteParClient(client);
	}

	@Override
	public List<Visite> recVisiteParBImmo(BienImmobilier bienImmobilier) {
		return vDao.recVisiteParBImmo(bienImmobilier);
	}

}
