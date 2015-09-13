package com.bankonet.metier;

import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;

public interface IClientService {
	//Gestion Client
	public void addClient(Client c) throws Exception; 
	public List<Client> listClients();
	public void deleteClient(int idClient);
	public Client editClient(int idClient);
	public void updateClient(Client c);
    public List<Client> chercherClients(String	motCle);
    
  //Gestion Compte
  	public void addCompte(Compte cpt) throws Exception; 
  	public List<Compte> listCompteClients(String idClient);
  	public void deleteCompteClient(int idCompte);
  	public Client editCompteClient(int idClient);
    
}
