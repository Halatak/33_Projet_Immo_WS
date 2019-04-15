package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.BienAchat;
import fr.adaming.model.BienImmobilier;
import fr.adaming.model.BienLocation;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;
import fr.adaming.model.Proprietaire;

@Repository
public class BienImmobilierDaoImpl extends AbstraitHibernateDao<BienImmobilier> implements IBienImmobilierDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<BienImmobilier> recBImmoParClasse(ClasseStandard classe) {
		// Requ�te JPQL
		String req = "SELECT b FROM BienImmobilier as b WHERE b.classeStandard.id=:pId";

		// R�cup�rer un objet de type Query
		Query query = em.createQuery(req);

		// Passage des param�tres
		query.setParameter("pId", classe.getId());

		return query.getResultList();
	}

	@Override
	public List<BienImmobilier> recBImmoParProp(Proprietaire proprietaire) {
		// Requ�te JPQL
		String req = "SELECT b FROM BienImmobilier as b WHERE b.proprietaire.id=:pId";

		// R�cup�rer un objet de type Query
		Query query = em.createQuery(req);

		// Passage des param�tres
		query.setParameter("pId", proprietaire.getId());

		return query.getResultList();
	}

	@Override
	public List<BienImmobilier> recBImmoParClient(Client client) {
		// Requ�te JPQL
		String req = "SELECT b FROM BienImmobilier as b JOIN b.listeClient cl WHERE cl.id=:pId";

		// R�cup�rer un objet de type Query
		Query query = em.createQuery(req);

		// Passage des param�tres
		query.setParameter("pId", client.getId());

		return query.getResultList();
	}

	@Override
	public List<BienImmobilier> recBImmoParType(String type) {
		// Requ�te JPQL
		String req = "SELECT b FROM BienImmobilier as b WHERE TYPE(b)=:pType";

		// R�cup�rer un objet de type Query
		Query query = em.createQuery(req);

		// Passage des param�tres
		query.setParameter("pType", type);

		return query.getResultList();
	}

}
