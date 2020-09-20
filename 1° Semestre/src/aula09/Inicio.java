package aula09;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Inicio {

	public static void main(String[] args) throws IOException {
		
		int op = 1;

		String[] textos = new String[] { "Criar arquivo", "Excluir arquivo", "Renomear arquivo", "Mover arquivo", "Criar diretório", 
				"Excluir diretório", "Renomear diretório", "Mover diretório", "Criar arquivo e escrever", "Ler arquivo",
				"Exibir informações sobre um arquivo", "Exibir informações sobre um diretório",
				"Exibir todos os arquivos e subdiretórios de um diretório (com caminho)", "Criar arquivo temporário" };
		
		Scanner sc = new Scanner (System.in);
		String path1, path2 = null, file1 = null, file2, dir1, dir2;
		
		do {
			
			try {
				menu(textos);
				op = sc.nextInt();
				System.out.println("\n");
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println("\n\n\t\tInsira um número válido!");
				sc.nextLine();
				continue;
			}
			
			if (op == 0) {
				System.out.println("\n\n\t\tAté a próxima!");
				break;
			}
			else {
				System.out.println(textos[op-1].toUpperCase());
			}
			
			switch (op) {
			
				case 1:
					System.out.print("\tInsira o caminho: ");
					path1 = sc.nextLine();
					path1 = verifyPath(path1);
					
					System.out.print("\tInsira o arquivo: ");
					file1 = sc.nextLine();
					
					FileManipulation.createFile(path1 + file1);
					break;
			
				case 2:
					System.out.print("\tInsira o caminho: ");
					path1 = sc.nextLine();
					path1 = verifyPath(path1);
					
					System.out.print("\tInsira o arquivo: ");
					file1 = sc.nextLine();
					
					FileManipulation.deleteFile(path1 + file1);
					break;
					
				case 3:
				case 4:
					System.out.print("\tInsira o caminho atual: ");
					path1 = sc.nextLine();
					path1 = verifyPath(path1);
					
					System.out.print("\tInsira o arquivo atual: ");
					file1 = sc.nextLine();
					
					if(op == 3) {
						System.out.print("\tInsira o novo caminho: ");
						path2 = sc.nextLine();
						path2 = verifyPath(path2);
					}
					
					System.out.print("\tInsira o novo arquivo: ");
					file2 = sc.nextLine();
					
					if(FileManipulation.manipuleFile(path1 + file1, op == 3 ? path1 + file2 : path2 + file2) == 1)
						System.out.println("\n\t\t" + (op == 3 ? "Arquivo renomeado com sucesso!" : "Arquivo movido com sucesso!"));
					break;
				
				case 5:
					System.out.print("\tInsira o caminho: ");
					path1 = sc.nextLine();
					path1 = verifyPath(path1);
					
					System.out.print("\tInsira o diretório: ");
					dir1 = sc.nextLine();
					
					DirectoryManipulation.crateDirectory(path1 + dir1);
					break;
					
				case 6:
					System.out.print("\tInsira o caminho: ");
					path1 = sc.nextLine();
					path1 = verifyPath(path1);
					
					System.out.print("\tInsira o diretório: ");
					dir1 = sc.nextLine();
					
					DirectoryManipulation.deleteDirectory(path1 + dir1);
					break;
					
				case 7:
				case 8:
					System.out.print("\tInsira o caminho atual: ");
					path1 = sc.nextLine();
					path1 = verifyPath(path1);
					
					System.out.print("\tInsira o diretório atual: ");
					dir1 = sc.nextLine();
					
					if(op == 8) {
						System.out.print("\tInsira o novo caminho: ");
						path2 = sc.nextLine();
						path2 = verifyPath(path2);
					}
					
					System.out.print("\tInsira o novo diretório: ");
					dir2 = sc.nextLine();
					
					if(DirectoryManipulation.manipuleDirectory(path1 + dir1, op == 7 ? path1 + dir2 : path2 + dir2) == 1)
						System.out.println("\n\t\t" + (op == 7 ? "Diretório renomeado com sucesso!" : "Diretório movido com sucesso!"));
					break;
					
				case 9:
					System.out.print("\tInsira o caminho do arquivo: ");
					path1 = sc.nextLine();
					path1 = verifyPath(path1);
					
					System.out.print("\tInsira o arquivo: ");
					file1 = sc.nextLine();
					
					System.out.print("\tInsira o texto para inserir no arquivo: ");
					String text = sc.nextLine();
					
					FileManipulation.createAndWriteFile(path1 + "\\" + file1, text);
					
					break;
					
				case 10:
					System.out.print("\tInsira o caminho: ");
					path1 = sc.nextLine();
					path1 = verifyPath(path1);
					
					System.out.print("\tInsira o arquivo: ");
					file1 = sc.nextLine();
					
					System.out.print("\tDeseja ler o arquivo todo (t) ou apenas parte (p): ");
					String read = sc.nextLine();
					
					ArrayList<Integer> pags = null;
					
					if(read.equalsIgnoreCase("p")) {
						pags = new ArrayList<>();
						
						System.out.print("\t\tInsira a primeira linha de leitura (em número): ");
						pags.add(sc.nextInt());
						
						System.out.print("\t\tInsira a última linha de leitura (em número): ");
						pags.add(sc.nextInt());
					}
					
					FileManipulation.readFile(path1 + file1, pags);
					
					break;
					
				case 11:
					System.out.print("\tInsira o caminho: ");
					path1 = sc.nextLine();
					path1 = verifyPath(path1);
					
					System.out.print("\tInsira o arquivo: ");
					file1 = sc.nextLine();
					
					FileManipulation.informationFile(path1 + file1);
					
					break;
					
				case 12:					
				case 13:
					System.out.print("\tInsira o caminho: ");
					path1 = sc.nextLine();
					path1 = verifyPath(path1);
					
					System.out.print("\tInsira o diretório: ");
					dir1 = sc.nextLine();
					
					DirectoryManipulation.informationDirectory(path1 + dir1, op == 12 ? 1 : 2);
					
					break;
					
				case 14:
					System.out.print("\tInsira o arquivo (sem extensão): ");
					file1 = sc.nextLine();
					
					TempFileManipulation.createTempFile(file1);
					break;
			}
			
		}
		while (op != 0);
		
		sc.close();
	}
	
	public static void menu (String[] textos) {
		System.out.println("\n\nConsidere as opções abaixo: ");
		for (int i=0; i<textos.length; i++)
			System.out.println("\t" + (i+1) + "-" + textos[i]);
		System.out.println("\t0-Sair");
		System.out.print("\n\nInsira a opção desejada: ");
	}
	
	public static String verifyPath (String path) {
		if (!path.endsWith("\\"))
			path = path + "\\";
		return path;
	}
}
