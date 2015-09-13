package com.bankonet.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
//relation avec la table Compte 
@OneToMany
private List<Compte> listeCompte;


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
 * @return
 */
public List<Compte> getListeCompte() {
	return  listeCompte;
}
/**
 * 
 * @param listeCompte
 */
public void setListeCompte(List<Compte> listeCompte) {
	this.listeCompte = listeCompte;
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


/**
 * @param login
 * @param mdp
 * @param adresse
 * @param listeCompte
 */
public Client(String login, String mdp, Adresse adresse, List<Compte> listeCompte) {
	super();
	this.login = login;
	this.mdp = mdp;
	this.adresse = adresse;
	this.listeCompte = listeCompte;
}
@Override
public String toString() {
	return "Client [login=" + login + ", mdp=" + mdp + ", adresse=" + adresse + ", listeCompte=" + listeCompte + "]";
}





}
