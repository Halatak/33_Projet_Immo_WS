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

import fr.adaming.dao.IBienImmobilierDao;
import fr.adaming.model.BienAchat;
import fr.adaming.model.BienImmobilier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class BienImmobilierDaoTest {

	// TRanformation de l'association UML en JAVA
	private IBienImmobilierDao bImmoDao;

	// setters
	@Autowired
	public void setbImmoDao(IBienImmobilierDao  bImmoDao) {
		this.bImmoDao = bImmoDao;
		bImmoDao.setClazz(BienImmobilier.class);
	}
	
	// V�rifier la taille de liste retourn�e
	@Test
	@Transactional(readOnly = true)
	public void testAfficherListeBienImmobilier() {

		int tailleTheo = 2;

		// r�cup�rer la taille de la liste
		int tailleReelle = bImmoDao.getAll().size();

		assertEquals(tailleTheo, tailleReelle);

	}
	
	// V�rifier l'ajout d'un bienImmobilier � vendre (achat) dans la BdD
	@Test
	@Transactional
	@Rollback(true)
	public void testAddBienImmoAchat() {
		
		BienAchat bAchat = new BienAchat("ok", new Date(), new Date(), 500, new Date(), "Titi", 2, "photo", 10, "ok");

		// r�cup�rer la taille de la liste
		int tailleReelle = 2;
		
		bImmoDao.ajout(bAchat);

		assertEquals(tailleReelle + 1, bImmoDao.getAll().size());
		
	}
	
}
