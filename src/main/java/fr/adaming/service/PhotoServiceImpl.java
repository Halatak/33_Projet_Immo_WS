package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IPhotoDao;
import fr.adaming.model.Photo;

@Service("photoService")
@Transactional
public class PhotoServiceImpl implements IPhotoService{
	
	//transformation de l'association uml en java
	private IPhotoDao phoDao;
	
	//setter pour injection de dependance
	@Autowired
	public void setPhoDao(IPhotoDao phoDao) {
		this.phoDao = phoDao;
		phoDao.setClazz(Photo.class);
	}

	@Override
	public Photo getById(int id) {
		return phoDao.getById(id);
	}

	@Override
	public List<Photo> getAll() {
		return phoDao.getAll();
	}

	@Override
	public Photo ajout(Photo ph) {
		return phoDao.ajout(ph);
	}

	@Override
	public Photo modifier(Photo ph) {
		return phoDao.modifier(ph);
	}   

	@Override
	public void suppr(Photo ph) {
		phoDao.suppr(ph);
		
	}

	@Override
	public void supprById(int id) {
		phoDao.supprById(id);
	}

}
