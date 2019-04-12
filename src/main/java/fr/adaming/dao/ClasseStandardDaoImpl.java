package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;

@Repository
public class ClasseStandardDaoImpl extends AbstraitHibernateDao<ClasseStandard> implements IClasseStandardDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ClasseStandard> recClasseParClient(Client client) {
		// Requ�te JPQL
		String req = "SELECT c FROM ClasseStandard as c WHERE c.client.id=:pId";

		// R�cup�rer un objet de type Query
		Query query = em.createQuery(req);

		// Passage des param�tres
		query.setParameter("pId", client.getId());

		return query.getResultList();
	}
	
	

}
