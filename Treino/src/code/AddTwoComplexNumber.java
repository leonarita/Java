package code;

import java.util.Scanner;

public class AddTwoComplexNumber {

    double real, img;
    
    AddTwoComplexNumber(double r, double i){
        this.real = r;
        this.img = i;
    }
    
    
    static AddTwoComplexNumber sum(AddTwoComplexNumber a1, AddTwoComplexNumber a2){
    	AddTwoComplexNumber temp = new AddTwoComplexNumber(0,0);
        
        temp.real = a1.real + a2.real;
        temp.img = a1.img + a2.img;
    
        return temp;
    }
    
    public static void main(String [] ak){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("\nEnter Real and Imaginary Part of 1st number: ");
        double real1 = scan.nextDouble();
        double img1 = scan.nextDouble();
        
        System.out.print("\nEnter Real and Imaginary Part of 2nd number: ");
        double real2 = scan.nextDouble();
        double img2 = scan.nextDouble();
        
        AddTwoComplexNumber a1 = new AddTwoComplexNumber(real1,img1);
        AddTwoComplexNumber a2 = new AddTwoComplexNumber(real2,img2);
        
        AddTwoComplexNumber temp = sum(a1,a2);
        
        System.out.println("\nSum is: "+temp.real+" + "+temp.img+"i");
        
        scan.close();
    }
}
