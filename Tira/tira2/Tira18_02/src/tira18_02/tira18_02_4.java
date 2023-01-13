/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tira18_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author tuomo
 */
public class Tira18_02_4 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
            //Dataset 1
            File txtfile= new File("data1.txt");//Reading the content of txt file
            Scanner reader = new Scanner(txtfile);
            String content = reader.nextLine();
            String[] parts = content.split(" ");
	    int[] dataset1 = new int[parts.length];
            //Content of txt file will be put to an integer array called dataset
            int counter1=0;
	    for (int i=0; i<parts.length; i++){
		dataset1[i]= Integer.parseInt(parts[i]);	
		//System.out.print(dataset1[i] + " ");
                counter1++;
            }
            //Dataset 2
            
            txtfile= new File("data2.txt");//Reading the content of txt file
            reader = new Scanner(txtfile);
            content = reader.nextLine();
            parts = content.split(" ");
	    int[] dataset2 = new int[parts.length];
            //Content of txt file will be put to an integer array called dataset
            int counter2=0;
	    for (int i=0; i<parts.length; i++){
		dataset2[i]= Integer.parseInt(parts[i]);	
		//System.out.print(dataset2[i] + " ");
                counter2++;
	    }
            
            //Dataset 3
            
            txtfile= new File("data3.txt");//Reading the content of txt file
            reader = new Scanner(txtfile);
            content = reader.nextLine();
            parts = content.split(" ");
	    int[] dataset3 = new int[parts.length];
            //Content of txt file will be put to an integer array called dataset
            int counter3=0;
	    for (int i=0; i<parts.length; i++){
		dataset3[i]= Integer.parseInt(parts[i]);	
		//System.out.print(dataset3[i] + " ");
                counter3++;
	    }
            
            //Dataset 4
            
            txtfile= new File("data4.txt");//Reading the content of txt file
            reader = new Scanner(txtfile);
            content = reader.nextLine();
            parts = content.split(" ");
	    int[] dataset4 = new int[parts.length];
            //Content of txt file will be put to an integer array called dataset
            int counter4=0;
	    for (int i=0; i<parts.length; i++){
		dataset4[i]= Integer.parseInt(parts[i]);	
		//System.out.print(dataset4[i] + " ");
                counter4++;
	    }
            
	    System.out.println();
            System.out.println("File found. \nA for Arrays.sort \nB for BubbleSort");
            String input = scan.next();
            System.out.println();
            if(input.equalsIgnoreCase("A")){
                //data1
                long start = System.nanoTime();
                Arrays.sort(dataset1);
                long end = System.nanoTime();
                long timeInMillis = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);
                System.out.println("Arrays.sort dataset1");
                System.out.println("Time spent in ms: " + timeInMillis);
                System.out.println("Size of an array: " + counter1 + "\n");
                //data2
                start = System.nanoTime();
                Arrays.sort(dataset2);
                end = System.nanoTime();
                timeInMillis = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);
                System.out.println("Arrays.sort dataset2");
                System.out.println("Time spent in ms: " + timeInMillis);
                System.out.println("Size of an array: " + counter2 + "\n");
                //data3
                start = System.nanoTime();
                Arrays.sort(dataset3);
                end = System.nanoTime();
                timeInMillis = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);
                System.out.println("Arrays.sort dataset3");
                System.out.println("Time spent in ms: " + timeInMillis);
                System.out.println("Size of an array: " + counter3 + "\n");
                //data4
                start = System.nanoTime();
                Arrays.sort(dataset4);
                end = System.nanoTime();
                timeInMillis = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);
                System.out.println("Arrays.sort dataset4");
                System.out.println("Time spent in ms: " + timeInMillis);
                System.out.println("Size of an array: " + counter4 + "\n");
            }
            else if(input.equalsIgnoreCase("B")){
                //data1
                long start = System.nanoTime();
                BubbleSort(dataset1);
                long end = System.nanoTime();
                long timeInMillis = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);
                System.out.println("BubbleSort dataset1");
                System.out.println("Time spent in ms: " + timeInMillis);
                System.out.println("Size of an array: " + counter1 + "\n");
                System.out.println();
                //data2
                start = System.nanoTime();
                BubbleSort(dataset2);
                end = System.nanoTime();
                timeInMillis = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);
                System.out.println("BubbleSort dataset2");
                System.out.println("Time spent in ms: " + timeInMillis);
                System.out.println("Size of an array: " + counter2 + "\n");
                //data3
                start = System.nanoTime();
                BubbleSort(dataset3);
                end = System.nanoTime();
                timeInMillis = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);
                System.out.println("BubbleSort dataset3");
                System.out.println("Time spent in ms: " + timeInMillis);
                System.out.println("Size of an array: " + counter3 + "\n");
                //data4
                start = System.nanoTime();
                BubbleSort(dataset4);
                end = System.nanoTime();
                timeInMillis = TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS);
                System.out.println("BubbleSort dataset4");
                System.out.println("Time spent in ms: " + timeInMillis);
                System.out.println("Size of an array: " + counter4 + "\n");
            }
            else{
                System.out.println("Invalid input");
            }
            
            System.out.println("Bye, see you soon.");
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

	//for(int k=0; k<table.length; k++)
            //System.out.print(table[k] + " ");
	return table;
	}
}
