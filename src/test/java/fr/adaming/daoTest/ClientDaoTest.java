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

	// V�rifier la taille de liste retourn�e
	@Test
	@Transactional(readOnly = true)
	public void testAfficherListeBienImmobilier() {

		int tailleTheo = 2;

		// r�cup�rer la taille de la liste
		int tailleReelle = clientDao.getAll().size();

		assertEquals(tailleTheo, tailleReelle);

	}

	// V�rifier l'ajout d'un client dans la Base de donn�e
	@Test
	@Transactional(readOnly = true)
	@Rollback(true)
	public void testAjoutClient() {

		int tailleTheo = 2;

		// r�cup�rer la taille de la liste
		Client clientAJout = new Client("a", "a@a", "a", "ar", new Adresse());

		clientDao.ajout(clientAJout);

		assertEquals(tailleTheo + 1, clientDao.getAll().size());

	}

	// V�rifier l'ajout d'un client dans la Base de donn�e (v�rif attributs)
	@Test
	@Transactional(readOnly = true)
	@Rollback(true)
	public void testAjoutClient2() {

		// r�cup�rer la taille de la liste
		Client clientAJout = new Client("a", "a@a", "a", "ar", new Adresse());

		clientDao.ajout(clientAJout);
		
		Client clientTest = clientDao.getById(clientAJout.getId());

		assertEquals(clientAJout.getNom(), clientTest.getNom());

	}
	
	//V�rifier la suppression d'un client dans la base de donn�es
	@Test
	@Transactional(readOnly = true)
	@Rollback(true)
	public void testSupprClient() {
		
		int tailleTheo = 2;
		
		clientDao.supprById(1);
		
		assertEquals(tailleTheo - 1, clientDao.getAll().size());		
		
	}
	
	// V�rifier la suppression avec le suppr (client)
	@Test
	@Transactional(readOnly = true)
	@Rollback(true)
	public void testSupprClient2() {
		
		int tailleTheo = 2;
		
		Client clientSuppr = new Client( 2,"a", "a@a", "a", "ar", new Adresse());
		
		clientDao.suppr(clientSuppr);
		
		assertEquals(tailleTheo - 1, clientDao.getAll().size());	
		
	}

}
