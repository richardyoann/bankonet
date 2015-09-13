package com.bankonet.model;

import java.util.ArrayList;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Yoann
 *
 */
public class Compte {
	private long id;
	private String intitule;
	private float solde;
	@ManyToOne
	@JoinColumn(name="Client-ID")		
	private Client client;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	/**
	 * 
	 */
	public Compte() {
		super();
	}
	/**
	 * @param id
	 * @param intitule
	 * @param solde
	 */
	public Compte(long id, String intitule,float solde) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.solde=solde;
	}
	
	/**
	 * @param id
	 * @param intitule
	 * @param solde
	 * @param listeClient
	 */
	public Compte(long id, String intitule, float solde, Client client) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.solde = solde;
		this.client = client;
	}
	@Override
	public String toString() {
		return "Compte [id=" + id + ", intitule=" + intitule + ", solde=" + solde + ", Client=" + client
				+ "]";
	}
	
	
	
}
