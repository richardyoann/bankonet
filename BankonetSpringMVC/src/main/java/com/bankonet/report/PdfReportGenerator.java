/**
 * 
 */
package com.bankonet.report;

/**
 * @author ETY
 *
 */
public class PdfReportGenerator extends  ReportGenerator implements IReportGenerator {

	/* (non-Javadoc)
	 * @see com.bankonet.report.IReportGenerator#generate()
	 */
	
	public void generate() {
		System.out.println("Génération d’un rapport PDF...");

	}

	
	public void generate(String Auteur) {
		this.generate();
		System.out.println("-> Auteur : "+Auteur);
		
	}

}
