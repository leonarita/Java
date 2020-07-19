package code;

import java.util.Scanner;

public class Diamong {

	public static void main(String[] args){
        
		Scanner sc=new Scanner(System.in);
        
        System.out.print("\nEnter N : ");
        int n = sc.nextInt(); 
        
        System.out.print("Enter Symbol : ");
        char c = sc.next().charAt(0);
        System.out.println();
        
        sc.close();
 
        for(int i=1; i<=n; i++){
        	System.out.print("\t");

        	for(int j=1; j<=n-i; j++)
                System.out.print(" ");

            for(int j=1; j<=i*2-1; j++)
                System.out.print(c);
            
            System.out.println();
        } 
        
        for(int i=n-1; i>0; i--){
        	System.out.print("\t");
        	
            for(int j=1; j<=n-i; j++)
                System.out.print(" ");
            
            for(int j=1; j<=i*2-1; j++)
                System.out.print(c);

            System.out.println();
        }
    }
}
