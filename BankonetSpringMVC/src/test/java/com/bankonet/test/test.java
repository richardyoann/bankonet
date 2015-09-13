package com.bankonet.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.ClientService;
import com.bankonet.metier.IClientService;
import com.bankonet.metier.ReportService;
import com.bankonet.model.Adresse;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.Personne;
import com.bankonet.model.compteCourant;
import com.bankonet.report.IReportGenerator;
import com.bankonet.report.PdfReportGenerator;
import com.bankonet.report.htmlReportGenerator;


public class test {

	public static void main(String[] args) {
		// connexion au bean.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		//création d'un client
		Client client =(Client) context.getBean("client");
		
		Client client1 = new Client("RICHARD", "Isabelle", "richardisabelle", "isabelle", new Adresse(8, "Rue de la vieille lande", "22400 Saint Alban"));
		
		compteCourant cpt = new compteCourant(new Compte("Compte cheque Isabelle RICHARD", -500F),  200F);
		System.out.println(cpt);	
		
		System.out.println(client.toString());		
		//connexion à la couche metier
		IClientService service = (IClientService) context.getBean("metier");
		//ajout d'un client en bdd
		try {
			service.addCompte(cpt);
			client1.getListeCompte().add(cpt);
			service.addClient(client);
			
			service.addClient(client1);
			
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			e.getCause();
		}	
		
		
	}
}
