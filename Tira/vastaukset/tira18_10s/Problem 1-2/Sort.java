/* Sorting Excercises */

import java.util.Random;

class Sort {
	public static void main (String[] args) {
		/* Test the sorting algorithms */
		int[] a = null;
		boolean ok = true;

		/* Insertion sort */
		a = randomArray(40);
		insertSort(a);
		if ( isSorted(a) != true) {
			System.out.println ("insertSort produced wrong result: ");
			printArray (a);
		}
		else 
			System.out.println ("insertSort seems to be ok!");

		/* Selection sort */
		a = randomArray(40);
		selectSort(a);
		if ( isSorted(a) != true) {
			System.out.println ("selectSort produced wrong result: ");
			printArray (a);
		}
		else 
			System.out.println ("selectSort seems to be ok!");

		/* Mergesort */
		a = randomArray(40);
		mergeSort(a);
		if ( isSorted(a) != true) {
			System.out.println ("mergeSort produced wrong result: ");
			printArray (a);
		}
		else
			System.out.println ("mergeSort seems to be ok!");

	}

	public static void insertSort (int[] tab) {
		for (int i = 1; i < tab.length; ++i) {
			int j = i;
			int x = tab[i];
			// finding the right place by checking table values at indices 0,...,i-1
			while (j > 0 && tab[j-1] > x) {
				tab[j] = tab[j-1];
				--j;
			}		
			tab[j] = x;
		}
	}

	public static void selectSort (int[] tab) {
		for (int i = 0; i < tab.length; ++i) {
			int minidx = i;
			int min = tab[i];
			for (int j = i+1; j < tab.length; ++j) {
				if (tab[j] < min) {
					min = tab[j];
					minidx = j;
				}
			}
			int tmp = tab[i];
			tab[i] = tab[minidx];
			tab[minidx] = tmp;
		}
	}
	
	public static void mergeSort (int[] tab) {
		mergeSort(tab, 0, tab.length-1);
	}

	private static void mergeSort(int []A, int low, int high) {
		int midPoint = (low + high)/2;
		if(low < high) {
			mergeSort(A, low, midPoint);
			mergeSort(A, midPoint+1, high);
			inplaceMerge(A, low, high, midPoint);
		}
	}
	
	/* This straightforward in-place merging results in performance O(n^2)
		Obtaining O(n log n) is a bit tricky, but possible by changing the way
		the splits/merges are done. */


	private static void inplaceMerge(int [] A, int low, int high, int midPoint) {
		int leftStart = low;
		int rightStart = midPoint + 1;
		int tmp = 0;
		int i = 0;
		while((leftStart < rightStart) && (rightStart <= high)) {
			if(A[leftStart] > A[rightStart]) {
				tmp = A[rightStart];
				for(i = rightStart; i > leftStart; i--) 
					A[i] = A[i-1];
				A[leftStart] = tmp;
				rightStart++;
			}
			leftStart++;
		}
	}

	private static Random qsr = new Random ();    

	/* 
	partition 

	chooses random pivot element from A[low..high], partitions 
	A[low..high] with respect to it and returns the final index p of the 
	pivot element thus after the call the following holds:
		A[i] <= A[p] when low <= i <= p     and 
		A[p] <= A[i] when   p <= i <= high
	*/

	private static int partition (int[] A, int low, int high) {
		int pivot, tmp, l, r;
		pivot = low + qsr.nextInt(high - low + 1);
		l = low;
		r = high-1;
		tmp = A[pivot];
		A[pivot] = A[high];
		A[high] = tmp;
		pivot = high;
		do {
			tmp = A[l];
			A[l] = A[r];
			A[r] = tmp;
			for(; l <= r && A[l] < A[pivot]; ++l)
			;
			for(; l <= r && A[pivot] < A[r]; --r)
			;
		}
		while (l <= r);
		tmp = A[l];
		A[l] = A[pivot];
		A[pivot] = tmp;
		return l;
	}

    public static void quickSort (int[] tab) {
		/* Exercise! */
	}


	/* Helper-functions for testing */

	public static boolean isSorted (int[] a) {
		boolean sorted = true;
		for (int i = 0; sorted && i < a.length; ++i) {
			if (a[i] != i) 
				sorted = false;
		}
		return sorted;
	}

	private static void printArray (int[] tab) {
		System.out.print ("(");
		for (int i = 0; i < tab.length-1; ++i) 
			System.out.print (tab[i] + " ");
		System.out.println (tab[tab.length-1] + ")");
	}

	private static Random r = new Random ();

	private static int[] randomArray (int n) {
		int[] keys = new int [n];
		for (int i = 0; i < n; ++i) {
			keys[i] = i;
		}
		for (int i = 0; i < n; ++i) {
			int pos = i + r.nextInt(n-i);
			int tmp = keys[pos];
			keys[pos] = keys[i];
			keys[i] = tmp;
		}
		return keys;
	}
}
