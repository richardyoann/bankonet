/**
 * 
 */
package com.bankonet.model;


import javax.persistence.Entity;
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
public class compteCourant extends Compte {
		
	private float debit;	

	public float getDebit() {
		return debit;
	}

	public void setDebit(float debit) {
		this.debit = debit;
	}

	/**
	 * 
	 */
	public compteCourant() {
		super();
	}	

	/**
	 * @param solde
	 */
	public compteCourant(Compte compte,  float debit) {
		super.setIntitule(compte.getIntitule());
		super.setSolde(compte.getSolde());		
		this.debit = debit;
	}
	
	@Override
	public String toString() {
		return "compteCourant ["+super.toString()+" debit=" + debit +  "]";	
	}

	

}
