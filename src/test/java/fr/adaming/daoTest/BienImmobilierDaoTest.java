package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.model.BienImmobilier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class BienImmobilierDaoTest {

	// TRanformation de l'association UML en JAVA
	private IGeneriqueDao<BienImmobilier> bImmoDao;

	// setters
	@Autowired
	public void setbImmoDao(IGeneriqueDao<BienImmobilier> bImmoDao) {
		this.bImmoDao = bImmoDao;
		bImmoDao.setClazz(BienImmobilier.class);
	}
	
	// Vérifier la taille de liste retournée
	@Test
	@Transactional(readOnly = true)
	public void testAfficherListeBienImmobilier() {

		int tailleTheo = 2;

		// récupérer la taille de la liste
		int tailleReelle = bImmoDao.getAll().size();

		assertEquals(tailleTheo, tailleReelle);

	}
	
	
}
