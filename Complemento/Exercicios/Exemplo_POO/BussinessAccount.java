package Exemplo_POO;

public class BussinessAccount extends Account{
	 
	private double loanLimite;
	
	public BussinessAccount() {
		super();
	}

	public BussinessAccount(int number, String holder, double balance,double loanLimite) {
		super(number, holder, balance);
		this.loanLimite = loanLimite;
	}

	public double getLoanLimite() {
		return loanLimite;
	}

	public void setLoanLimite(double loanLimite) {
		this.loanLimite = loanLimite;
	}
	
	public void loan(double amount) {
		
		if (amount <= loanLimite ) {
			balance +=amount*0.10;
			
		}
	}
}