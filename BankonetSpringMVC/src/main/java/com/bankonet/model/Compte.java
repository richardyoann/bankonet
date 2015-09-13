package com.bankonet.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Yoann
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public  class Compte {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String intitule;
	private float solde;
	// le @autowired permet de lier automatiquement le bean adresse 
	@Autowired
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
	public Compte( String intitule,float solde) {
		super();
		
		this.intitule = intitule;
		this.solde=solde;
	}
	
	
	@Override
	public String toString() {
		return "Compte [id=" + id + ", intitule=" + intitule + ", solde=" + solde + "]";
	}
	
	
	
}
