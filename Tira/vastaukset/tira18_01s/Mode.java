
import java.util.Scanner;
import java.io.*;

public class Mode {
	
	public static void FindMode(int[] table){
		int modePos = 0;
		int modeCount = 0;
		for (int j=1; j<table.length; j++){
			int count = 0;
			for (int k=0; k<table.length; k++){
				if(table[k]==table[j]){
					count = count +1;
				}
			}		
			if (count>=modeCount){
				modePos = j;
				modeCount = count; 
			}	
		}
		System.out.println("Mode is: " + table[modePos]);
	}
	
	public static void main(String[] args) throws IOException
	{
		//Reading the content of data.txt file
		File temp = new File("data.txt");
	    Scanner scan = new Scanner(temp);
	
		String content = scan.nextLine();
		String[] parts = content.split(" ");
		int[] dataset = new int[parts.length];
		
		//Content of data.txt file will be put to integer array named dataset
		for (int i=0; i<parts.length; i++){
			dataset[i]= Integer.parseInt(parts[i]);	
		}
		scan.close();
		
		if(dataset.length>0){
			FindMode(dataset);
		}				
		else{
			System.out.println("Array does not contain elements.");
		}
	}
}