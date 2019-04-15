package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Photo;

public interface IPhotoDao extends IGeneriqueDao<Photo>{
	
	public List<Photo> recPhotoParBienImmo(BienImmobilier bimmo);

}
