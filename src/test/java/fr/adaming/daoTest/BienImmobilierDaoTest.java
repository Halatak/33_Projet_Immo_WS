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
import fr.adaming.model.Adresse;
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
	
	/*
	// Vérifier la taille de liste retournée
	@Test
	@Transactional(readOnly = true)
	public void testAfficherListeBienImmobilier() {

		int tailleTheo = 2;

		// récupérer la taille de la liste
		int tailleReelle = bImmoDao.getAll().size();

		assertEquals(tailleTheo, tailleReelle);

	}
	*/
	// Vérifier l'ajout d'un bienImmobilier à vendre (achat) dans la BdD
	@Test
	@Transactional
	@Rollback(true)
	public void testAddBienImmoAchat() {
		
		BienImmobilier bAchat = new BienAchat("Achat", new Date(), new Date(), 100, "", 3, "", "", new Adresse(), 100, "");
		

		// récupérer la taille de la liste
		int tailleReelle = 4;
		
		bImmoDao.ajout(bAchat);

		assertEquals(tailleReelle + 1, bImmoDao.getAll().size());
		
	}
	
}
