/**
 * 
 */
package com.bankonet.metier;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.dao.IClientDao;
import com.bankonet.model.Client;
/**
 * @author ETY
 *
 */
//Annotion @Transactional (readOnly = true) permet de gerer les transactions
@Transactional
@Service("metier")
public class ClientService implements IClientService {

	@Resource(name="dao")
	private IClientDao dao;
	
	
	/**
	 * Getteur du dao
	 * @return the dao
	 */
	public IClientDao getDao() {
		return dao;
	}

	/**
	 * Setteur du dao
	 * @param dao the dao to set
	 */
	public void setDao(IClientDao dao) {
		this.dao = dao;
	}

	/**
	 * Fonction d'ajout dans la base de données d'un client
	 * @throws Exception 
	 * @see com.bankonet.metier.IClientService#addClient(com.bankonet.model.Client)
	 */
	@Transactional(rollbackFor=Exception.class)
	public void addClient(Client c) throws Exception {
		dao.addClient(c);
		
	}

	/**
	 * Fonction lister tous les clients
	 * @see com.bankonet.metier.IClientService#listClients()
	 */
	@Transactional
	public List<Client> listClients() {
		System.out.println("dans ClientService.listClients --> List des clients");
		return dao.listClients();
	}

	/**
	 * Fonction suppression d'un client
	 * @see com.bankonet.metier.IClientService#deleteClient(int)
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteClient(int idClient) {
		System.out.println("dans ClientService.deleteClient --> Suppression d'un client");
		dao.deleteClient(idClient);
	}

	/**
	 * Fonction edition de l'historique d'un client
	 * @see com.bankonet.metier.IClientService#editClient(int)
	 */
	@Transactional
	public Client editClient(int idClient) {
		System.out.println("dans ClientService.editClient --> Edition d'un client");
		return dao.editClient(idClient);
	}

	/**
	 * Fonction mise à jour d'un client
	 * @see com.bankonet.metier.IClientService#updateClient(com.bankonet.model.Client)
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateClient(Client c) {
		System.out.println("dans ClientService.updateClient --> MAJ d'un client");
		dao.updateClient(c);

	}

	/**
	 * Fonction rechercher un client en fonction d'un mot cle Nom ou prenon 
	 * @see com.bankonet.metier.IClientService#chercherClients(java.lang.String)
	 */
	
	public List<Client> chercherClients(String motCle) {
		System.out.println("dans ClientService.chercherClients --> cherche d'un client");
		return dao.chercherClients(motCle);
	}
	
	
	
}
