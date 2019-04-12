package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class ClientDaoTest {

	// Transformation de l'association UML en JAVA
	private IClientDao clientDao;

	// setters
	@Autowired
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
		clientDao.setClazz(Client.class);
	}

	// Vérifier la taille de liste retournée
	@Test
	@Transactional(readOnly = true)
	public void testAfficherListeBienImmobilier() {

		int tailleTheo = 2;

		// récupérer la taille de la liste
		int tailleReelle = clientDao.getAll().size();

		assertEquals(tailleTheo, tailleReelle);

	}

	// Vérifier l'ajout d'un client dans la Base de donnée
	@Test
	@Transactional()
	@Rollback(true)
	public void testAjoutClient() {

		int tailleTheo = 2;

		// récupérer la taille de la liste
		Client clientAJout = new Client("a", "a@a", "a", "ar", new Adresse());

		clientDao.ajout(clientAJout);

		assertEquals(tailleTheo + 1, clientDao.getAll().size());

	}

	// Vérifier l'ajout d'un client dans la Base de donnée (vérif attributs)
	@Test
	@Transactional()
	@Rollback(true)
	public void testAjoutClient2() {

		// récupérer la taille de la liste
		Client clientAJout = new Client("a", "a@a", "a", "ar", new Adresse());

		clientDao.ajout(clientAJout);
		
		Client clientTest = clientDao.getById(clientAJout.getId());

		assertEquals(clientAJout.getNom(), clientTest.getNom());

	}
	
	//Vérifier la suppression d'un client dans la base de données
	@Test
	@Transactional()
	@Rollback(true)
	public void testSupprClient() {
		
		int tailleTheo = 2;
		
		clientDao.supprById(1);
		
		assertEquals(tailleTheo - 1, clientDao.getAll().size());		
		
	}
	
	// Vérifier la suppression avec le suppr (client)
	@Test
	@Transactional()
	@Rollback(true)
	public void testSupprClient2() {
		
		int tailleTheo = 2;
		
		Client clientSuppr = clientDao.getById(2);
		
		clientDao.suppr(clientSuppr);
		
		assertEquals(tailleTheo - 1, clientDao.getAll().size());	
		
	}

	// Vérifier la modification d'un client
	@Test
	@Transactional()
	@Rollback(true)
	public void testModifClient() {
		
		Client clientModif = clientDao.getById(1);
		
		clientModif.setNom("Arthur");
		
		clientDao.modifier(clientModif);
		
		Client clientModifie = clientDao.getById(1);
		
		assertEquals("Arthur", clientModifie.getNom());
		
	}
	
	
}
