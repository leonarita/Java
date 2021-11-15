package br.com.maven.pocs.pdf.to.txt;

import java.io.IOException;

public class App {
	
	private static final String PDF_PATH = 
			"D:\\ADS\\3° Semestre\\Desenvolvimento Web I\\Complemento\\Exercicios - Resolução\\5-Resolução dos Exercícios.pdf";
	
	private static final String TXT_PATH = 
			"D:\\ADS\\3° Semestre\\Desenvolvimento Web I\\Complemento\\Exercicios - Resolução\\Resolucao.txt";
	
	public static void main(String... args) throws IOException {
		PdfToTxtConverter pdfToTxtConverter = new PdfToTxtConverter();
		pdfToTxtConverter.parsePdf(PDF_PATH, TXT_PATH);
	}

}
