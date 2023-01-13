import java.util.*;
import java.io.*;

public class Alphaorder {
	
	public static String[] Ordering(String[] table) {
		int m = 0;
		boolean swap;
		String temp = "";
		
		do {
			swap = false;
				for(int j=0; j<(table.length-1-m); j++) {
					if(table[j].compareTo(table[j+1])>0) {
						temp = table[j];
						table[j] = table[j+1];
						table[j+1] = temp;
						swap = true;
					}
				}			
			m = m + 1;
		} while(swap);
		
		return table;
	}
	
	public static void main(String[] args) throws IOException {
		//Reading the content of data3.txt file
		File temp = new File("data3.txt");
	    Scanner scan = new Scanner(temp);
		String content = scan.nextLine();
		String[] parts = content.split(" ");
		scan.close();
		
		//In result variable you can find the ordered string array.
		String[] result=Ordering(parts);
		
		for(int k=0; k<result.length; k++){
			System.out.print(result[k] + " ");		
		}
	}	
}
