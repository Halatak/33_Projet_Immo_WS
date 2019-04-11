package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStandard;

public interface IClasseStandardService {
	
	public ClasseStandard getById(long id);

	public List<ClasseStandard> getAll();

	public ClasseStandard ajout(ClasseStandard cs);

	public ClasseStandard modifier(ClasseStandard cs);

	public void suppr(final ClasseStandard cs);

	public void supprById(final long id);

}
