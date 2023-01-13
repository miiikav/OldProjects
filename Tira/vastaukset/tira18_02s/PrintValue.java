import java.util.Scanner;
import java.io.*;
import java.lang.Math;

public class PrintValue {
	
	public static void main(String[] args) throws IOException
	{
		
		System.out.print("Give a positive integer n: ");
		Scanner scan = new Scanner(System.in);
		
		double value = scan.nextDouble();
		scan.close();

		//We use the 2 base logarithm when printing the values.
		
		System.out.println("6n = "+6*value);
		if(0<value){
			System.out.println("3log n = " + 3*(Math.log(value)/Math.log(2)));
		}
		else{
			System.out.println("Value of 3log n cannot be evaluated.");
		}
		
		if(0<value){
			System.out.println("n^(1/2)log n = " + Math.sqrt(value)*(Math.log(value)/Math.log(2)));
		}
		else{
			System.out.println("Value of n^(1/2)log n cannot be evaluated.");
		}
		
		System.out.println("5n^2 = "+5*Math.pow(value,2.0));
		System.out.println("n^(1/2) = " + Math.sqrt(value));
		System.out.println("42 = 42");
		
		double temp = 1;
		for(int i=1; i<=value; i++){
			temp = temp*i;
		}
		
		System.out.println("n! = " + temp);
		
		if(1<value){
		System.out.println("7loglog n = "+ 7*(Math.log(Math.log(value)/Math.log(2))/Math.log(2)));
		}
		else{
			System.out.println("Value of 7loglog n cannot be evaluated.");
		}
		
		if(0<value){
			System.out.println("nlog n = " + value*(Math.log(value)/Math.log(2)));
		}
		else{
			System.out.println("Value of nlog n cannot be evaluated.");
		}
		
		
			
		
		
	}
}