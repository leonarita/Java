package testes.email.v1;

public class Main {

    public static void main(String[] args) {
         
    	Email email = new Email("EMAIL", 
        		"TESTE 01", 
        		"a1@gmail.com");
    	
    	Email email2 = new Email("EMAIL", 
        		"TESTE 02", 
        		"a2@hotmail.com");
        
        Thread t1 = new Thread(email);
        Thread t2 = new Thread(email2);
        
        while(true) {
        	t1.run();
        	t2.run();
        }
        

    }
    
}
