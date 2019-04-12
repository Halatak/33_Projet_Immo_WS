package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Conseiller;

@Repository
public class ConseillerDaoImpl extends AbstraitHibernateDao<Conseiller> implements IConseillerDao{

}
