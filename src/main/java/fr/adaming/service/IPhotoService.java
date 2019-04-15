package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Photo;

public interface IPhotoService {
	
	public Photo getById(int id);

	public List<Photo> getAll();

	public Photo ajout(Photo ph);

	public Photo modifier(Photo ph);

	public void suppr(final Photo ph);

	public void supprById(final int id);
	
	public List<Photo> recPhotoParBienImmo(BienImmobilier bimmo);

}
