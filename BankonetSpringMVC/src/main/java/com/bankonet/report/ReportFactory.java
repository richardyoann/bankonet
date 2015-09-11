/**
 * 
 */
package com.bankonet.report;

/**
 * @author ETY
 *
 */
public class ReportFactory {
	
	public static ReportGenerator createReport(String reportType)
	{
		if ("html".equals(reportType)){
			return new htmlReportGenerator();
		}
		else if ("pdf".equals(reportType)){
			return new PdfReportGenerator();
		}
		else  throw new IllegalArgumentException("Impossible de créer un rapport car le type n'est pas connu" );
			
		
	}
	
}
