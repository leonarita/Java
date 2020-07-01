package Exemplo_POO;

public class programa {
	  
	public static void main(String[] args) {
    
	Account aac1 = new Account(1, "Anselmo o lindo", 0.0);  
	aac1.deposit(200);	
	System.out.println(aac1.balance);
	
	aac1.wihtdraw(15);
	System.out.println(aac1.balance);
  }
  
}
