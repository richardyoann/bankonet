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

		"nom", "nom.empty", "Le nom est demandé");

		ValidationUtils.rejectIfEmptyOrWhitespace(e,

		"prenom", "prenom.empty", "Le prénom est demandé");
		ValidationUtils.rejectIfEmptyOrWhitespace(e,

		"login", "login.empty", "Le login est demandé");

		ValidationUtils.rejectIfEmptyOrWhitespace(e,

		"mdp", "mdp.empty", "Le mot de passe est demandé");
		
		Client c = (Client) obj;		
		if (c.getNom().length()<3) {
			e.rejectValue("nom", "negativevalue", "Le nom doit comporter au moins 3 caractére");
		} else if ( c.getNom().length() > 60) {
			e.rejectValue("nom", "negativevalue", "Le nom doit etre inferieur à 60 caractéres");
		}
		
		if (c.getPrenom().length()<3) {
			e.rejectValue("nom", "negativevalue", "Le prénom doit comporter au moins 3 caractére");
		} else if ( c.getNom().length() > 60) {
			e.rejectValue("nom", "negativevalue", "Le prénom doit etre inferieur à 60 caractéres");
		}
		
		if (c.getLogin().length()<12) {
			e.rejectValue("nom", "negativevalue", "Le login doit comporter au moins 12 caractére");
		} else if ( c.getLogin().length() > 16) {
			e.rejectValue("nom", "negativevalue", "Le login doit etre inferieur à 16 caractéres");
		}
		
		if (c.getMdp().length()<6) {
			e.rejectValue("nom", "negativevalue", "Le nom doit comporter au moins 6 caractére");
		} else if ( c.getMdp().length() > 50) {
			e.rejectValue("nom", "negativevalue", "Le nom doit etre inferieur à 60 caractéres");
		}

	}

}
