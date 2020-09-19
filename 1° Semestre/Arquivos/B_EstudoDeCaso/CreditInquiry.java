package B_EstudoDeCaso;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreditInquiry {

	private final static MenuOption[] choices = MenuOption.values();

	public static void main(String[] args) {
	
		// obt�m a solicita��o do usu�rio (por exemplo, saldo zero, credor ou devedor)
		MenuOption accountType = getRequest();

		while (accountType != MenuOption.END) {
	
			switch (accountType) {

				case ZERO_BALANCE:
					System.out.printf("%nAccounts with zero balances:%n");
					break;
	
				case CREDIT_BALANCE:
					System.out.printf("%nAccounts with credit balances:%n");
					break;
	
				case DEBIT_BALANCE:
					System.out.printf("%nAccounts with debit balances:%n");
					break;
					
				default:
					System.out.printf("%nAccounts nonexistent:%n");
					break;
			}
			
			readRecords(accountType);
			
			// obt�m a solicita��o do usu�rio
			accountType = getRequest(); 
		}
	}

	// obt�m a solicita��o do usu�rio
	private static MenuOption getRequest() {

		int request = 4;
		
		// exibe op��es de solicita��o
		System.out.printf("%nEnter request%n%s%n%s%n%s%n%s%n", " 1 - List accounts with zero balances", 
				" 2 - List accounts with credit balances", " 3 - List accounts with debit balances", " 4 - Terminate program");
		
		Scanner input;
		
		try {
			input = new Scanner(System.in);

			// insere a solicita��o de usu�rio
			do {
	
				System.out.printf("%n? ");
				request = input.nextInt();
			} while ((request < 1) || (request > 4));
			
		}
		catch (NoSuchElementException noSuchElementException) {
			System.err.println("Invalid input. Terminating.");
		}
		
		// retorna o valor enum da op��o
		return choices[request - 1]; 
	}

	// l� registros de arquivo e exibe somente os registros do tipo apropriado continua
	private static void readRecords(MenuOption accountType) {
		
		// abre o arquivo e processa o conte�do
		try (Scanner input = new Scanner(Paths.get("clients.txt"))) {
	
			// mais dados para ler
			while (input.hasNext()) {
				
				int accountNumber = input.nextInt();
				String firstName = input.next();
				String lastName = input.next();
				double balance = input.nextDouble();

				// se o tipo for a conta adequada, exibe o registro
				if (shouldDisplay(accountType, balance))
					System.out.printf("%-10d%-12s%-12s%10.2f%n", accountNumber, firstName, lastName, balance);
				else
					// descarta o restante do registro atual
					input.nextLine(); 
			}
		}
		catch (NoSuchElementException | IllegalStateException | IOException e) {
			System.err.println("Error processing file. Terminating.");
			System.exit(1);
		}
	}

	// utiliza o tipo de registro para determinar se registro deve ser exibido
	private static boolean shouldDisplay(MenuOption accountType, double balance) {
	
		if ((accountType == MenuOption.CREDIT_BALANCE) && (balance < 0))
			return true;
		else if ((accountType == MenuOption.DEBIT_BALANCE) && (balance > 0))
			return true;
		else if ((accountType == MenuOption.ZERO_BALANCE) && (balance == 0))
			return true;

		return false;
	}
}
