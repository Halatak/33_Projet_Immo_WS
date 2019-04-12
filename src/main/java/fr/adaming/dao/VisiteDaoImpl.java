package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Visite;

@Repository
public class VisiteDaoImpl extends AbstraitHibernateDao<Visite> implements IVisiteDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Visite> recVisiteParConseiller(Conseiller conseiller) {
		// Requ�te JPQL
		String req = "SELECT v FROM Visite as v WHERE v.conseiller.id=:pId";

		// R�cup�rer un objet de type Query
		Query query = em.createQuery(req);

		// Passage des param�tres
		query.setParameter("pId", conseiller.getId());

		return query.getResultList();
	}

	@Override
	public List<Visite> recVisiteParClient(Client client) {
		// Requ�te JPQL
		String req = "SELECT v FROM Visite as v WHERE v.client.id=:pId";

		// R�cup�rer un objet de type Query
		Query query = em.createQuery(req);

		// Passage des param�tres
		query.setParameter("pId", client.getId());

		return query.getResultList();
	}

	@Override
	public List<Visite> recVisiteParBImmo(BienImmobilier bienImmobilier) {
		// Requ�te JPQL
		String req = "SELECT v FROM Visite as v WHERE v.bienImmobilier.id=:pId";

		// R�cup�rer un objet de type Query
		Query query = em.createQuery(req);

		// Passage des param�tres
		query.setParameter("pId", bienImmobilier.getId());

		return query.getResultList();
	}

}
