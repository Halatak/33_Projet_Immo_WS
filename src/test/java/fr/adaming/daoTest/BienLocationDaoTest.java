package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienAchatDao;
import fr.adaming.dao.IBienImmobilierDao;
import fr.adaming.dao.IBienLocationDao;
import fr.adaming.model.BienAchat;
import fr.adaming.model.BienImmobilier;
import fr.adaming.model.BienLocation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class BienLocationDaoTest {

	// TRanformation de l'association UML en JAVA
	private IBienImmobilierDao blDao;

	//setter injection dependance
	@Autowired
	public void setBlDao(IBienImmobilierDao blDao) {
		this.blDao = blDao;
		blDao.setClazz(BienImmobilier.class);
	}

	// Vérifier l'ajout d'un bienImmobilier à vendre (achat) dans la BdD
	@Test
	@Transactional
	@Rollback(true)
	public void testAddBienAchat() {

		BienImmobilier bLoc = new BienLocation("toto", new Date(), new Date(), 150, "", 300, 1, 2, "", true);

		// récupérer la taille de la liste
		int tailleReelle = 2;

		blDao.ajout(bLoc);

		assertEquals(tailleReelle + 1, blDao.getAll().size());

	}


}
