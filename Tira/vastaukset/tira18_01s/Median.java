import java.util.Scanner;
import java.io.*;

public class Median {
	
	public static int FindMedian(int[] sortedTable){
		int n = sortedTable.length;
		int medianValue = 0;
		if (n%2!=0){
			medianValue = sortedTable[(n-1)/2]; 
		}else{
			medianValue = (sortedTable[n/2]+sortedTable[n/2-1])/2;
		}
		
		return medianValue;
	}
	
	public static int[] BubbleSort(int[] table){
		int m = 0;
		boolean swap;
		int temp = 0;
		
		do{
			swap = false;
				for(int j=0; j<(table.length-1-m); j++){
					if(table[j]>table[j+1]){
						temp = table[j];
						table[j] = table[j+1];
						table[j+1] = temp;
						swap = true;
					}
				}			
			m = m + 1;
		}while(swap);
		
		for(int k=0; k<table.length; k++)
			System.out.print(table[k] + " ");
		
		return table;
	}
	
	
	public static void main(String[] args) throws IOException
	{
		//Reading the content of data.txt file
		File temp = new File("data.txt");
	    Scanner scan = new Scanner(temp);
	
		String content = scan.nextLine();
		String[] parts = content.split(" ");
		int[] dataset = new int[parts.length];
		
		//Content of data.txt file will be put to an integer array called dataset
		for (int i=0; i<parts.length; i++){
			dataset[i]= Integer.parseInt(parts[i]);	
			System.out.print(dataset[i] + " ");
		}
		System.out.println();
		scan.close();
		
		if(dataset.length>0){
			int[] sorted = BubbleSort(dataset);
			int result = FindMedian(dataset);
			System.out.println();
			System.out.println("Median is: " + result);
		}				
		else{
			System.out.println("Array does not contain elements.");
		}
	}
}