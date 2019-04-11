package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstraitHibernateDao<T extends Serializable> implements IGeneriqueDao<T> {

	private Class<T> clazz;
	
	@PersistenceContext
	private EntityManager em;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	// methode getById
	public T getById(long id) {
		return (T) em.find(clazz, id);
	}

	public List<T> getAll() {
		return em.createQuery("SELECT t FROM " + clazz.getName()+" t").getResultList();
	}

	public T ajout(T entity) {
		// creation de la requete
		em.persist(entity);
		return entity;

	}

	public T modifier(T entity) {
		// creation de la requete
		em.merge(entity);
		return entity;
	}

	public void suppr(T entity) {
		// creation de la requete
		em.remove(entity);
	}

	public void supprById(long entityId) {
		T entity = getById(entityId);
		suppr(entity);
	}

}
