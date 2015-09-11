package com.bankonet.metier;

import com.bankonet.report.IReportGenerator;

public class ReportService {
	private IReportGenerator r;
	private String Auteur;
	
	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return Auteur;
	}


	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		Auteur = auteur;
	}


	public void generateAnnualReport() {
	r.generate(Auteur);	

	}
	

	/**
	 * getteur 
	 * @return the r
	 */
	public IReportGenerator getR() {
		return r;
	}

	/**
	 * setteur
	 * @param r the r to set
	 */
	public void setR(IReportGenerator r) {
		this.r = r;
		
	}

	
	/**
	 * Constructeur par default
	 */
	public ReportService() {
		
	}

	/**
	 * constructeur parametre pour l'injection par constructeur
	 * @param r
	 */
	public ReportService(IReportGenerator r) {		
		this.r = r;
	}
	
	
	
}
