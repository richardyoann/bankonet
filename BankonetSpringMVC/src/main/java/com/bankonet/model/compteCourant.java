/**
 * 
 */
package com.bankonet.model;



/**
 * @author Yoann
 *
 */
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
	 * @param debit
	 */
	public compteCourant(float debit) {
		super();
		this.debit = debit;
	}
	
	@Override
	public String toString() {
		return "compteCourant [debit=" + debit + "]";	
	}

	

}
