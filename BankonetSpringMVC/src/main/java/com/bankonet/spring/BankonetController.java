package com.bankonet.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankonet.metier.IClientService;
import com.bankonet.model.Client;

@Controller
public class BankonetController {

	@Autowired
	private IClientService metier;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		// envoi un nouveau client dans la page index
		model.addAttribute("client", new Client());
		// envoi de la liste des clients
		model.addAttribute("listeClients", metier.listClients());
		model.addAttribute("formAction", "ajouter");
		return "index";
	}

	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	public String ajouter(@Valid Client c, BindingResult bindingResult,
			Model model) throws Exception {
		// on verifie si les valeurs dans l'objet client sont conforme au
		// controle
		if (bindingResult.hasErrors()) {
			// si erreur, renvoie de la liste des clients dans index
			model.addAttribute("listeClients", metier.listClients());
			return "index";
		}
		
		metier.addClient(c);
		// ajout du message de validation de l'ajout
		model.addAttribute("message", "Ajout d'un client");

		// on renvoi la nouvelle liste des clients avec le client ajouté
		model.addAttribute("listeClients", metier.listClients());
		// on fourni un nouveau client au formulaire
		model.addAttribute("client", new Client());
		// on retourne dans index
		return "index";
	}

	@RequestMapping(value = "/supprimer/{id}", method = RequestMethod.GET)
	public String supprimer(@PathVariable("id") int id, Model model) {

		metier.deleteClient(id);
		// on renvoi la nouvelle liste des clients avec le client ajouté
		model.addAttribute("listeClients", metier.listClients());
		// ajout du message de validation de l'ajout
		model.addAttribute("message", "Suppression du client");
		// on fourni un nouveau client au formulaire
		model.addAttribute("client", new Client());
		return "index";
	}

	@RequestMapping(value = "/editer/{id}", method = RequestMethod.GET)
	public String editer(@PathVariable("id") int id, Model model) {
		// on fourni un nouveau client au formulaire
		model.addAttribute("client", metier.editClient(id));
		// on renvoi la nouvelle liste des clients avec le client ajouté
		model.addAttribute("listeClients", metier.listClients());
		model.addAttribute("formAction", "editer/" + id);
		return "index";
	}

	@RequestMapping(value = "/editer/{id}", method = RequestMethod.POST)
	public String editerMAJ(@Valid Client c, BindingResult bindingResult,
			@PathVariable("id") int id, Model model) throws Exception {
		// on verifie si les valeurs dans l'objet client sont conforme au
		// controle
		if (bindingResult.hasErrors()) {
			// si erreur, renvoie de la liste des clients dans index
			model.addAttribute("listeClients", metier.listClients());
			return "index";
		}
		
		metier.updateClient(c);
		// ajout du message de validation de l'ajout
		model.addAttribute("message", "Mise à jour du client");
		// on renvoi la nouvelle liste des clients avec le client ajouté
		model.addAttribute("listeClients", metier.listClients());
		// on fourni un nouveau client au formulaire
		model.addAttribute("formAction", "ajouter/" + id);
		return "index";
	}

}
