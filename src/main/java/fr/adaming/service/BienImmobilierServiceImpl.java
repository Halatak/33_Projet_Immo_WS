package fr.adaming.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienImmobilierDao;
import fr.adaming.dao.IPhotoDao;
import fr.adaming.model.BienImmobilier;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;
import fr.adaming.model.Photo;
import fr.adaming.model.Proprietaire;

@Service("bienImmobilierService")
@Transactional
public class BienImmobilierServiceImpl implements IBienImmobilierService{
	
	//transformation uml en java
	private IBienImmobilierDao bienImmoDao;
	private IPhotoDao phDao;
	
	//setter pour injection de dependance
	@Autowired
	public void setBienImmoDao(IBienImmobilierDao bienImmoDao) {
		this.bienImmoDao = bienImmoDao;
		bienImmoDao.setClazz(BienImmobilier.class);
	}
	
	@Autowired
	public void setPhDao(IPhotoDao phDao) {
		this.phDao = phDao;
		phDao.setClazz(Photo.class);
	}

	@Override
	public BienImmobilier getById(int id) {
		return bienImmoDao.getById(id);
	}

	@Override
	public List<BienImmobilier> getAll() {
		return bienImmoDao.getAll();
	}

	@Override
	public BienImmobilier ajout(BienImmobilier bi) {
		// récupérer les photos et les ajouter à la db
//		for (int i=0; i<bi.getListePhoto().size(); i++){
//			// recup du string de la photo de json
//			String phIn = bi.getListePhoto().get(i).getPhoto();
//			Photo photoIn = new Photo();
//			//conversion de la photo e byte
//			photoIn.setImg(Base64.getDecoder().decode(phIn));
//			//lier la photo au bien
//			photoIn.setBienImmo(bi);
//			//ajout de la photo dans la bd
//			phDao.ajout(photoIn);
//		}		
		
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
	public void supprById(int id) {
		bienImmoDao.supprById(id);
		
	}

	@Override
	public List<BienImmobilier> recBImmoParClasse(ClasseStandard classe) {
		return bienImmoDao.recBImmoParClasse(classe);
	}

	@Override
	public List<BienImmobilier> recBImmoParProp(Proprietaire proprietaire) {
		return bienImmoDao.recBImmoParProp(proprietaire);
	}

	@Override
	public List<BienImmobilier> recBImmoParClient(Client client) {
		return bienImmoDao.recBImmoParClient(client);
	}

	@Override
	public List<BienImmobilier> recBImmoParType(String type) {
		return bienImmoDao.recBImmoParType(type);
	}

}
