package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseStandardDao;
import fr.adaming.model.ClasseStandard;

@Service("classeStandardService")
@Transactional
public class ClasseStandardServiceImpl implements IClasseStandardService{

	//transformation uml en java
	private IClasseStandardDao classeStandDao;
	
	//setter pour injection de dependance
	@Autowired
	public void setClasseStandDao(IClasseStandardDao classeStandDao) {
		this.classeStandDao = classeStandDao;
		classeStandDao.setClazz(ClasseStandard.class);
	}
	
	@Override
	public ClasseStandard getById(long id) {
		return classeStandDao.getById(id);
	}

	@Override
	public List<ClasseStandard> getAll() {
		return classeStandDao.getAll();
	}

	@Override
	public ClasseStandard ajout(ClasseStandard cs) {
		return classeStandDao.ajout(cs);
	}

	@Override
	public ClasseStandard modifier(ClasseStandard cs) {
		return classeStandDao.modifier(cs);
	}

	@Override
	public void suppr(ClasseStandard cs) {
		classeStandDao.suppr(cs);
		
	}

	@Override
	public void supprById(long id) {
		classeStandDao.supprById(id);
		
	}

}
