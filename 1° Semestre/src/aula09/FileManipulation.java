package aula09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class FileManipulation {

	public static void createFile(String path) throws IOException {
		File file = new File(path);
		
		if(!file.exists()) {
			file.createNewFile();
			System.out.println("\n\t\tArquivo criado com sucesso!");
		}
		else {
			System.out.println("\n\t\tArquivo já existe!");
		}
	}
	
	public static void deleteFile(String path) throws IOException {
		File file = new File(path);
		
		if(file.exists()) {
			file.delete();
			System.out.println("\n\t\tArquivo deletado com sucesso!");
		}
		else {
			System.out.println("\n\t\tArquivo não existe!");
		}
	}
	
	public static int manipuleFile(String path1, String path2) throws IOException {
		File file1 = new File(path1);
		File file2 = new File(path2);
		
		if(file1.exists()) {
			file1.renameTo(file2);
			return 1;
		}
		else {
			System.out.println("\n\t\tArquivo não existe!");
			return 0;
		}
	}

	public static void createAndWriteFile(String path, String text) throws IOException {
		createFile(path);
		
		FileWriter fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);
		
		if(new File(path).length() == 0) {
			bw.write(text);
		}
		else {
			bw.append(text);
		}
		System.out.println("Inserido com sucesso!");
		bw.close();

	}
	
	public static void readFile(String path, ArrayList<Integer> pags) throws IOException {
		File file = new File(path);
		
		if(file.exists()) {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			
			String linha;
			
			System.out.println("\n\nCONTEUDO SOLICITADO");
			if (pags == null) {
				
				while((linha = br.readLine()) != null) {
					System.out.println("\t" + linha);
				}
				
			}
			else {
				
				for(int i=1; i<pags.get(0); i++) {
					br.readLine();
				}
				
				for(int i=pags.get(0); i<=pags.get(1); i++) {
					linha = br.readLine();
					
					if(linha != null)
						System.out.println("\t" + linha);
				}
			}
			
			br.close();
		}
		else {
			System.out.println("\n\t\tArquivo não existe!");
		}
	}

	public static void informationFile(String path) {
		File file = new File(path);
		
		if(file.exists()) {
			System.out.println("\n\nCONTEUDO SOLICITADO");
			
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(file.lastModified());
			String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(cal.getTime());
			
			System.out.println("\tÚltima modificação: " + dataHora);
			System.out.println("\tCaminho: " + file.getPath());
			System.out.println("\tDiretório pai: " + file.getParent());
			System.out.println("\tTamanho: " + file.length() + " bytes");
		}
		else {
			System.out.println("\n\t\tArquivo não existe!");
		}
	}
}
