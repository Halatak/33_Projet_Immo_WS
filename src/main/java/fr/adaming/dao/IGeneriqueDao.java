package fr.adaming.dao;


import java.util.List;

public interface IGeneriqueDao<T>{
	
	public void setClazz(Class<T> clazzToSet);
	
	public T getById(final long id);

	public List<T> getAll();

	public T ajout(T entity);

	public T modifier(T entity);

	public void suppr(final T entity);

	public void supprById(final long entityId);

}
