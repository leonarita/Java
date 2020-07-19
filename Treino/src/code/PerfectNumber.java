package code;

import java.util.Scanner;

public class PerfectNumber {

	public static void main(String arg[]){
	    
		long n, sum = 0;
        
		Scanner scan = new Scanner(System.in);
        
	    System.out.print("\nEnter a number: ");
        n = scan.nextLong();
        
        scan.close();
        
	    int i = 1;
	    
	    while(i <= n/2){
	 
	    	if(n%i==0)
	    		sum += i;

	    	i++;
	    }
        
	    if(sum == n){
	    	System.out.println(n+" is a perfect number\n");
	    }
	    else
	    	System.out.println(n+" is not a perfect number\n"); 
	}
}
