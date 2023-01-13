import java.util.Scanner;
import java.io.*;

public class maxmin {

	public static void Maximum(int[] table) {
		int a = table[0];
		for (int j = 1; j < table.length; j++) {
			if (a <= table[j]) {
				a = table[j];
			}
		}
		System.out.println("Maximum value is: " + a);
	}

	public static void Minimum(int[] table) {
		int a = table[0];
		for (int j = 1; j < table.length; j++) {
			if (table[j] <= a) {
				a = table[j];
			}
		}
		System.out.println("Minimum value is: " + a);
	}

	public static void main(String[] args) throws IOException {
		//Reading the content of data.txt file
		File temp = new File("data.txt");
		Scanner scan = new Scanner(temp);

		String content = scan.nextLine();
		String[] parts = content.split(" ");
		int[] dataset = new int[parts.length];

		//Content of data.txt file will be put to integer array named dataset
		for (int i = 0; i < parts.length; i++) {
			dataset[i] = Integer.parseInt(parts[i]);
		}
		scan.close();

		if (dataset.length > 0) {
			Maximum(dataset);
			Minimum(dataset);
		} 
		else {
			System.out.println("Array does not contain elements.");
		}
	}
}