package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Photo;

@Repository
public class PhotoDaoImpl  extends AbstraitHibernateDao<Photo> implements IPhotoDao{

}
