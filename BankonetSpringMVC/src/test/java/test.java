import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.ClientService;
import com.bankonet.metier.IClientService;
import com.bankonet.metier.ReportService;
import com.bankonet.model.Adresse;
import com.bankonet.model.Client;
import com.bankonet.model.Personne;
import com.bankonet.report.IReportGenerator;
import com.bankonet.report.PdfReportGenerator;
import com.bankonet.report.htmlReportGenerator;


public class test {

	public static void main(String[] args) {
		// connexion au bean.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		//création d'un client
		Client client =(Client) context.getBean("client");
		System.out.println(client.toString());		
		//connexion à la couche metier
		IClientService service = (IClientService) context.getBean("metier");
		//ajout d'un client en bdd
		try {
			service.addClient(client);
			service.addClient(new Client("RICHARD", "Isabelle", "richardisabelle", "isabelle", new Adresse(8, "Rue de la vieille lande", "22400 Saint Alban")));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			e.getCause();
		}	
		
		
	}
}
