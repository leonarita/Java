package I_Conceitos_Iniciais;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class S_Arquivos 
{
	public static class ManipuladorArquivo 
	{
	    public static void leitor(String path) throws IOException {
	        BufferedReader buffRead = new BufferedReader(new FileReader(path));
	        String linha = "";
	        
	        while (true)
	        {
	            if (linha != null)
	                System.out.println(linha);
	            else
	                break;
	            
	            linha = buffRead.readLine();
	        }
	        
	        buffRead.close();
	    }
	 
	    public static void escritor(String path) throws IOException 
	    {
	        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
	        String linha = "";
	        Scanner in = new Scanner(System.in);
	        System.out.println("Escreva algo: ");
	        linha = in.nextLine();
	        buffWrite.append(linha + "\n");
	        buffWrite.close();
	        in.close();
	    }
	}
	
	public static void main(String args[]) throws IOException 
	{
        String path = "I_Conceitos_Iniciais\file.txt";
 
        ManipuladorArquivo.escritor(path);
        ManipuladorArquivo.leitor(path);
    }
}