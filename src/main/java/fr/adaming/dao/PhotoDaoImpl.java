package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Photo;

@Repository
public class PhotoDaoImpl  extends AbstraitHibernateDao<Photo> implements IPhotoDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Photo> recPhotoParBienImmo(BienImmobilier bimmo) {
		// Requ�te JPQL
				String req = "SELECT p FROM Photo as p WHERE p.bienImmo.id=:pId";

				// R�cup�rer un objet de type Query
				Query query = em.createQuery(req);

				// Passage des param�tres
				query.setParameter("pId", bimmo.getId());

				return query.getResultList();
	}

}
