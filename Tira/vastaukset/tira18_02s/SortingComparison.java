import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class SortingComparison {
	
	public static void BubbleSort(int[] table){
		System.out.println("Array size is: " + table.length);

		int m = 0;
		boolean swap;
		int temp = 0;
		
		double start = System.nanoTime();
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
		double stop = System.nanoTime();
		
		double difference = stop - start;
		System.out.println("Bubble sort algorithm sorted table in time: " + difference + " ns");
	}
	
	
	public static void main(String[] args) throws IOException
	{
		//Reading the content of data1.txt file
		File temp1 = new File("data1.txt");
	    Scanner scan1 = new Scanner(temp1);
		String content1 = scan1.nextLine();
		String[] parts1 = content1.split(" ");
		int[] dataset1 = new int[parts1.length];
		for (int i=0; i<parts1.length; i++){
			dataset1[i]= Integer.parseInt(parts1[i]);	
		}
		scan1.close();
		
		
		//Reading the content of data2.txt file
		File temp2 = new File("data2.txt");
	    Scanner scan2 = new Scanner(temp2);
		String content2 = scan2.nextLine();
		String[] parts2 = content2.split(" ");
		int[] dataset2 = new int[parts2.length];
		for (int i=0; i<parts2.length; i++){
			dataset2[i]= Integer.parseInt(parts2[i]);	
		}
		scan2.close();
		
		//Reading the content of data3.txt file
		File temp3 = new File("data3.txt");
	    	Scanner scan3 = new Scanner(temp3);
		String content3 = scan3.nextLine();
		String[] parts3 = content3.split(" ");
		int[] dataset3 = new int[parts3.length];
		for (int i=0; i<parts3.length; i++){
			dataset3[i]= Integer.parseInt(parts3[i]);	
		}
		scan3.close();
		
		//Reading the content of data4.txt file
		File temp4 = new File("data4.txt");
	    	Scanner scan4 = new Scanner(temp4);
		String content4 = scan4.nextLine();
		String[] parts4 = content4.split(" ");
		int[] dataset4 = new int[parts4.length];
		for (int i=0; i<parts4.length; i++){
			dataset4[i]= Integer.parseInt(parts4[i]);	
		}
		scan4.close();

		
		
		if(dataset1.length>0){
			BubbleSort(dataset1);
			double start1 = System.nanoTime();
			Arrays.sort(dataset1);
			double end1 = System.nanoTime();
			double diff1 = end1 - start1;
			System.out.println("Sort function from the Arrays class sorted the array in time: " + diff1 + " ns");
		}				
		else{
			System.out.println("Array does not contain elements.");
		}
		
		System.out.println();
		if(dataset2.length>0){
			BubbleSort(dataset2);
			double start2 = System.nanoTime();
			Arrays.sort(dataset2);
			double end2 = System.nanoTime();
			double diff2 = end2 - start2;
			System.out.println("Sort function from the Arrays class sorted the array in time: " + diff2 + " ns");
		}				
		else{
			System.out.println("Array does not contain elements.");
		}
		
		
		System.out.println();
		if(dataset3.length>0){
			BubbleSort(dataset3);
			double start3 = System.nanoTime();
			Arrays.sort(dataset3);
			double end3 = System.nanoTime();
			double diff3 = end3 - start3;
			System.out.println("Sort function from the Arrays class sorted the array in time: " + diff3 + " ns");
		}				
		else{
			System.out.println("Array does not contain elements.");
		}
		
		System.out.println();
		if(dataset4.length>0){
			BubbleSort(dataset4);
			double start4 = System.nanoTime();
			Arrays.sort(dataset4);
			double end4 = System.nanoTime();
			double diff4 = end4 - start4;
			System.out.println("Sort function from the Arrays class sorted the array in time: " + diff4 + " ns");
		}				
		else{
			System.out.println("Array does not contain elements.");
		}
		
		}
}