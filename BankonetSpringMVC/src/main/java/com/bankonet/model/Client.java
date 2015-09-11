/**
 * 
 */
package com.bankonet.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;



/**
 * @author ETY
 *
 */
@Entity
@DiscriminatorValue("C")
public class Client extends Personne {
	
// rend le champ Login non null et impose une taille max et min 	
@NotNull
@Size(max=16,min=12)
private String login;
@NotNull
@Size(max=50,min=6)
private String mdp;

// le @autowired permet de lier automatiquement le bean adresse 
@Autowired
// le @Embedded perment d'informer qu'il faut inserer dans la simple table (Personne) les attribut de la classe adresse  
@Embedded
private Adresse adresse;


/**
 * @return the adresse
 */
public Adresse getAdresse() {
	return adresse;
}
/**
 * @param adresse the adresse to set
 */
public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
}
/**
 * @return the login
 */
public String getLogin() {
	return login;
}
/**
 * @param login the login to set
 */
public void setLogin(String login) {
	this.login = login;
}
/**
 * @return the mdp
 */
public String getMdp() {
	return mdp;
}
/**
 * @param mdp the mdp to set
 */
public void setMdp(String mdp) {
	this.mdp = mdp;
}
/**
 * 
 */
public Client() {
	super();
}
/**
 * @param login
 * @param mdp
 */
public Client(String login, String mdp) {
	super();
	this.login = login;
	this.mdp = mdp;
}


/**
 * @param login
 * @param mdp
 * @param adresse
 */
public Client(String nom , String prenom, String login, String mdp, Adresse adresse) {
	super.setNom(nom);
	super.setPrenom(prenom);
	this.login = login;
	this.mdp = mdp;
	this.adresse = adresse;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return " Client [ " + super.toString() + " login=" + login + ", mdp=" + mdp + adresse.toString()+"]";
}





}
