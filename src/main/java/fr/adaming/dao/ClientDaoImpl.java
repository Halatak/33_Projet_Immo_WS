package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl extends AbstraitHibernateDao<Client> implements IClientDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Client> recClientParClasse(ClasseStandard classe) {
		// Requête JPQL
		String req = "SELECT c FROM Client as c JOIN c.listeClasseStandard cl WHERE cl.id=:pId";

		// Récupérer un objet de type Query
		Query query = em.createQuery(req);

		// Passage des paramètres
		query.setParameter("pId", classe.getId());

		return query.getResultList();
	}
	

}
