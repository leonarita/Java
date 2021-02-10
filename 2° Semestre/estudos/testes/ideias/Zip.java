package testes.ideias;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		if(!new File("C:\\Teste").exists()) {
			new File("C:\\Teste").mkdirs();
		}

		generateZip("Material-LP1A3.zip", "Linguagem de Programação I");
		generateZip("Material-BD2A3.zip", "Bancos de Dados II");
		
				
	}
	
	private static void generateZip(String filenameZip, String nameFolder) throws FileNotFoundException, IOException {
		
		File file = new File("C:\\Teste\\" + filenameZip);
		
		try(ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(file))) {
			
			zip.putNextEntry(new ZipEntry("Introdução.pdf"));
			zip.write(Files.newInputStream(Path.of("D:\\ADS\\3° Semestre\\" + nameFolder, "0-Apresentação da Disciplina.pdf")).readAllBytes());
			zip.closeEntry();
			
			zip.putNextEntry(new ZipEntry("Lembrete.txt"));

			zip.write(
				(
					"Esse zip é destinado para estudantes do IFSP da disciplina "
					+ filenameZip.substring(filenameZip.indexOf("-") + 1, filenameZip.indexOf("."))
					
					+ "\n\n=== SIGLAS === \n"
					+ "- IFSP  : \t Instituto Federal de Educação, Ciência e Tecnologia de São Paulo \n"
					+ "- " + filenameZip.substring(filenameZip.indexOf("-") + 1, filenameZip.indexOf(".")) + " : \t " + nameFolder + " \n"
				)
			.getBytes());
			
			zip.closeEntry();
						
			for(File f: new File("D:\\ADS\\3° Semestre\\" + nameFolder).listFiles()) {
				
//				System.out.println(f.getName());
								
				if(f.isFile() && f.getName().endsWith(".pdf") && !f.getName().startsWith("0")) {
					
					String prefix = f.getName().substring(1, 2).equals("-") ?
							"0" + f.getName().substring(0, 1) : f.getName().substring(0, 1) + f.getName().substring(1, 2);
					
					zip.putNextEntry(new ZipEntry("aula" + prefix + ".pdf"));
					
					try (InputStream is = new FileInputStream(f)) {
						zip.write(is.readAllBytes());
					}
					
					zip.closeEntry();
					
				}
			}
		}
	}
}
