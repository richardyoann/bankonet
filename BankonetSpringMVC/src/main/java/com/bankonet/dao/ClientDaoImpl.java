package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import com.bankonet.model.Client;

@Repository("dao")
public class ClientDaoImpl implements IClientDao {
	// Recuperation du persistance pensé à faire un getter et setter 

	@PersistenceContext
	private EntityManager entityManager;	
	/**
	 * @return the em
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}


	/**
	 * @param em the em to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void addClient(Client c) {
		System.out.println("dans ClientDaoImpl.addClient --> Ajout d'un client");		
		entityManager.persist(c);

	}

	
	public List<Client> listClients() {
		System.out.println("dans ClientDaoImpl.listClients --> List des clients");
		
		return entityManager.createQuery("SELECT C FROM Client C ").getResultList();
	}

	
	public void deleteClient(int idClient) {
		System.out.println("listClientsSuppression d'un client");
		Client c = entityManager.find(Client.class, idClient);
		entityManager.remove(c);
	}

	
	public Client editClient(int idClient) {
		System.out.println("Edition des information d'un client avec Tostring");
		Client c = entityManager.find(Client.class, idClient);		
		return c;
	}

	
	public void updateClient(Client c) {
		System.out.println("Mise a jour  d'un client");
		entityManager.merge(c);
	}

	
	public List<Client> chercherClients(String motCle) {
		System.out.println("Recherche d'un client");	
		return entityManager.createQuery("SELECT C FROM Client C WHERE C.nom like :x or C.prenom like :x").setParameter("x", "%" + motCle + "%").getResultList();
	}

}
