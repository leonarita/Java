package _Orientação_A_Objetos;

//EXERCICIO: CRIE UMA CLASSE QUE CALCULE A MÉDIA DE UM ALUNO QUE ESTUDA SEMESTRALMENTE

//Importando a classe
import javax.swing.JOptionPane;

//Criando a classe

//visibilidade classe nomeClasse = nomeArquivo
public class Aula1
{
	
/*	Variáveis globais
	float valor1 = 0.0f;
	float valor2 = 0.0f;
	float media = 0.0f;
	String primeiro, segundo;
*/

	//Método principal
	public static void main (String args[])
	{
		//Variáveis locais
		float valor1 = 0.0f;
		float valor2 = 0.0f;
		float media = 0.0f;
		String primeiro, segundo;
	
		System.out.println ("Calculo da média");
		
		//Exibindo a caixa de diálogo
		JOptionPane.showConfirmDialog (null, "Calculo da média");
		
		//Recebendo o primeiro valor
		primeiro = JOptionPane.showInputDialog ("Entre com a primeira nota: ");
		
		//Converter texto em número
		valor1 = Float.parseFloat (primeiro);
		
		//Recebendo o segundo valor
		segundo = JOptionPane.showInputDialog ("Entre com a segunda nota: ");
		
		//Converter texto em número
		valor2 = Float.parseFloat (segundo);
		
		//Calculando a média
		media = (valor1 + valor2)/2;
		
		//Exibindo resultado
//		JOptionPane.showMessageDialog (null, "A média é " + media);
		
		if (media>=6)
			JOptionPane.showMessageDialog (null, "A média é " + media + "\nVocê está aprovado! ");
		else
			JOptionPane.showMessageDialog (null, "A média é " + media + "\nVocê está reprovado! ");

		System.exit(0);
	}
}