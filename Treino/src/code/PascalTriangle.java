package code;

import java.util.Scanner;

public class PascalTriangle {

	static int fact(int num){
		   
		int factorial;

		for(factorial = 1; num > 1; num--)    
			factorial *= num;

		return factorial;	    
	}
	   
	static int ncr(int n,int r){	
		return fact(n) / (fact(n-r) * fact(r));	    
	}

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		int rows, i, j;
	    
		System.out.print("\nEnter number of rows: ");
		rows = scan.nextInt();
		
		scan.close();

		System.out.println("\nPascal Triangle:");

		for(i=0; i<rows; i++) {
	    
			for(j=0; j<rows-i; j++)
				System.out.print(" ");
	            
			for(j=0; j<=i; j++)
				System.out.print(" "+ncr(i, j));
	        
			System.out.println();
		}
	}
}
