package aula09;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DirectoryManipulation {

	public static void crateDirectory(String path) {
		File dir = new File(path);
		
		if(!dir.exists()) {
			if(dir.mkdirs())
				System.out.println("\n\t\tDiretório criado com sucesso!");
		}
		else {
			System.out.println("\n\t\tDiretório já existe!");
		}
	}
	
	public static void deleteDirectory(String path) {
		File dir = new File(path);
		
		if(dir.exists()) {
			if(dir.delete())
				System.out.println("\n\t\tDiretório excluído com sucesso!");
			else
				System.out.println("\n\t\tCaminho inválido!");
		}
		else {
			System.out.println("\n\t\tDiretório não existe!");
		}
	}
	
	public static int manipuleDirectory(String path1, String path2) {
		File dir1 = new File(path1);
		File dir2 = new File(path2);
		
		if(dir1.exists()) {
			if(dir1.renameTo(dir2))
				return 1;
			else 
				System.out.println("\n\t\tCaminho inválido!");
		}
		else {
			System.out.println("\n\t\tDiretório não existe!");
		}
		
		return 0;
	}
	
	public static void informationDirectory(String path, int op) {
		File dir = new File(path);
		
		if(dir.exists()) {
			System.out.println("\n\nCONTEUDO SOLICITADO");
			
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(dir.lastModified());
			String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(cal.getTime());
			
			System.out.println("\tÚltima modificação: " + dataHora);
			System.out.println("\tCaminho: " + dir.getPath());
			System.out.println("\tDiretório pai: " + dir.getParent());
			
			if(op == 1) {
				System.out.println("\tArquivos e diretórios existentes (sem caminho): ");
				for(String a : dir.list())
					System.out.println("\t\t" + a);
			}
			else if(op == 2) {
				System.out.println("\tArquivos e diretórios existentes (com caminho): ");
				for(File a : dir.listFiles())
					System.out.println("\t\t" + a);
			}
		}
		else {
			System.out.println("\n\t\tDiretório não existe!");
		}
	}
}
