/**
 * 
 */
package com.bankonet.model;

import javax.persistence.Entity;

/**
 * @author Yoann
 *
 */
@Entity
public class compteEpargne extends Compte{
	private float TxE;
	public float getTxE() {
		return TxE;
	}
	public void setTxE(float txE) {
		TxE = txE;
	}
	
	/**
	 * 
	 */
	public compteEpargne() {
		super();
	}
	/**
	 * @param txE
	 */
	public compteEpargne(float txE) {
		super();
		TxE = txE;
	}
	
	@Override
	public String toString() {
		return "compteEpargne [TxE=" + TxE + "]";
	}
	
	
	
}
