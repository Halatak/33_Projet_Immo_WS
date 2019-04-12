package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.BienLocation;

@Repository
public class BienLocationDaoImpl extends AbstraitHibernateDao<BienLocation> implements IBienLocationDao {

}
