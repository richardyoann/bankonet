/**
 * 
 */
package com.bankonet.model;
	
/**
 * @author Yoann
 *
 */
public class compteEpargne {
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
