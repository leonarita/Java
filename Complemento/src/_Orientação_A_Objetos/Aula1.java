package _Orienta��o_A_Objetos;

//EXERCICIO: CRIE UMA CLASSE QUE CALCULE A M�DIA DE UM ALUNO QUE ESTUDA SEMESTRALMENTE

//Importando a classe
import javax.swing.JOptionPane;

//Criando a classe

//visibilidade classe nomeClasse = nomeArquivo
public class Aula1
{
	
/*	Vari�veis globais
	float valor1 = 0.0f;
	float valor2 = 0.0f;
	float media = 0.0f;
	String primeiro, segundo;
*/

	//M�todo principal
	public static void main (String args[])
	{
		//Vari�veis locais
		float valor1 = 0.0f;
		float valor2 = 0.0f;
		float media = 0.0f;
		String primeiro, segundo;
	
		System.out.println ("Calculo da m�dia");
		
		//Exibindo a caixa de di�logo
		JOptionPane.showConfirmDialog (null, "Calculo da m�dia");
		
		//Recebendo o primeiro valor
		primeiro = JOptionPane.showInputDialog ("Entre com a primeira nota: ");
		
		//Converter texto em n�mero
		valor1 = Float.parseFloat (primeiro);
		
		//Recebendo o segundo valor
		segundo = JOptionPane.showInputDialog ("Entre com a segunda nota: ");
		
		//Converter texto em n�mero
		valor2 = Float.parseFloat (segundo);
		
		//Calculando a m�dia
		media = (valor1 + valor2)/2;
		
		//Exibindo resultado
//		JOptionPane.showMessageDialog (null, "A m�dia � " + media);
		
		if (media>=6)
			JOptionPane.showMessageDialog (null, "A m�dia � " + media + "\nVoc� est� aprovado! ");
		else
			JOptionPane.showMessageDialog (null, "A m�dia � " + media + "\nVoc� est� reprovado! ");

		System.exit(0);
	}
}