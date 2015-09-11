/**
 * 
 */
package com.bankonet.model;

import javax.persistence.Embeddable;

/**
 * @author ETY
 *
 */
// @Embeddable autorise la portabilite des attributs cette classe dans la simple table
@Embeddable
public class Adresse {

	private int numero;
	private String rue;
	private String ville;	
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}
	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/**
	 * Constructeur par default
	 */
	public Adresse() {
		super();
	}
	
	/**
	 * @param numero
	 * @param rue
	 * @param ville
	 * @param client
	 */
	public Adresse(int numero, String rue, String ville) {
		
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", ville="
				+ ville + "]";
	}
	
	
}
