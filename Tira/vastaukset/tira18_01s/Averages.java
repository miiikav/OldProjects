
import java.util.Scanner;
import java.io.*;
import java.lang.Math;

public class Averages {
	
	public static void AriAve(int[] table) {
		
		double size = table.length;
		double sum = 0;
		for (int j=0; j < table.length; j++) {
			sum = sum + table[j];
		}
		double result = sum/size;
		
		System.out.println("Arithmetic average is: " + result);
	}
	
	public static void HarAve(int[] table){
		
		double size = table.length;
		double sum = 0;
		for (int j=0; j < table.length; j++) {
			sum = sum + (double)1/table[j];
		}
		double result = size/sum;
		
		System.out.println("Harmonic average is: " + result);
	}
	
	public static void GeoAve(int[] table) {
		
		double size = table.length;
		double prod = 1;
		for (int j=0; j < table.length; j++) {
			prod = prod*table[j];
		}

		double exponent = 1/size;
		
		double result = Math.pow(prod,exponent);
		
		System.out.println("Geometric average is: " + result);
	}
	
	public static void main(String[] args) throws IOException {

		//Reading the content of data.txt file
		File temp = new File("data2.txt");
	    Scanner scan = new Scanner(temp);
	
		String content = scan.nextLine();
		String[] parts = content.split(" ");
		int[] dataset = new int[parts.length];
		
		//Content of data.txt file will be put to integer array named dataset
		for (int i=0; i < parts.length; i++) {
			dataset[i]= Integer.parseInt(parts[i]);	
		}
		scan.close();
		
		if(dataset.length>0) {
			AriAve(dataset);
			HarAve(dataset);
			GeoAve(dataset);
		}
		else {
			System.out.println("Array does not contain elements.");
		}			
	}	
}