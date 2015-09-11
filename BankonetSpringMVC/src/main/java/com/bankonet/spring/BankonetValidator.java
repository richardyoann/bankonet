/**
 * 
 */
package com.bankonet.spring;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bankonet.model.Client;

/**
 * @author ETY
 *
 */
public class BankonetValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Client.class.equals(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors e) {

		ValidationUtils.rejectIfEmptyOrWhitespace(e,

		"nom", "nom.empty", "Le nom est demand�");

		ValidationUtils.rejectIfEmptyOrWhitespace(e,

		"prenom", "prenom.empty", "Le pr�nom est demand�");
		ValidationUtils.rejectIfEmptyOrWhitespace(e,

		"login", "login.empty", "Le login est demand�");

		ValidationUtils.rejectIfEmptyOrWhitespace(e,

		"mdp", "mdp.empty", "Le mot de passe est demand�");
		
		Client c = (Client) obj;		
		if (c.getNom().length()<3) {
			e.rejectValue("nom", "negativevalue", "Le nom doit comporter au moins 3 caract�re");
		} else if ( c.getNom().length() > 60) {
			e.rejectValue("nom", "negativevalue", "Le nom doit etre inferieur � 60 caract�res");
		}
		
		if (c.getPrenom().length()<3) {
			e.rejectValue("nom", "negativevalue", "Le pr�nom doit comporter au moins 3 caract�re");
		} else if ( c.getNom().length() > 60) {
			e.rejectValue("nom", "negativevalue", "Le pr�nom doit etre inferieur � 60 caract�res");
		}
		
		if (c.getLogin().length()<12) {
			e.rejectValue("nom", "negativevalue", "Le login doit comporter au moins 12 caract�re");
		} else if ( c.getLogin().length() > 16) {
			e.rejectValue("nom", "negativevalue", "Le login doit etre inferieur � 16 caract�res");
		}
		
		if (c.getMdp().length()<6) {
			e.rejectValue("nom", "negativevalue", "Le nom doit comporter au moins 6 caract�re");
		} else if ( c.getMdp().length() > 50) {
			e.rejectValue("nom", "negativevalue", "Le nom doit etre inferieur � 60 caract�res");
		}

	}

}
