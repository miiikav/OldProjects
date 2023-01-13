/* Sorting Exercises */

import java.util.Random;

class Sort {
	
    public static class ListNode {
		public ListNode (int data, ListNode next) {
		    this.data = data;
		    this.next = next;
		}
		public int      data;
		public ListNode next;
    }

    public static void main (String[] args) {
		if (testSelectSort ()) {
			System.out.println ("Timing selection sort.");
			timeSelectSort (10);
			timeSelectSort (100);
			timeSelectSort (1000);
			timeSelectSort (2000);
			timeSelectSort (3000);
			timeSelectSort (4000);
		}

		if (testInsertSort ()) {
			System.out.println ("Timing insertion sort.");
			timeInsertSort (10);
			timeInsertSort (100);
			timeInsertSort (1000);
			timeInsertSort (2000);
			timeInsertSort (3000);
			timeSelectSort (4000);
		}
		
		if (testBubbleSort ()) {
			System.out.println ("Timing bubble sort.");
			timeBubbleSort (10);
			timeBubbleSort (100);
			timeBubbleSort (1000);
			timeBubbleSort (2000);
			timeBubbleSort (3000);
		}
		
		if (testQuickSort ()) {
			System.out.println ("Timing quick sort.");
			timeQuickSort (10);
			timeQuickSort (100);
			timeQuickSort (1000);
			timeQuickSort (2000);
			timeQuickSort (3000);
			timeQuickSort (4000);
			timeQuickSort (5000);
			timeQuickSort (10000);
			timeQuickSort (20000);
		}

		if (testMergeSort ()) {
			System.out.println ("Timing merge sort.");
			timeMergeSort (10);
			timeMergeSort (100);
			timeMergeSort (1000);
			timeMergeSort (2000);
			timeMergeSort (3000);
			timeMergeSort (4000);
			timeMergeSort (5000);
			timeMergeSort (10000);
			timeMergeSort (20000);
		}

		if (testHeapSort ()) {
			System.out.println ("Timing heap sort.");
			timeHeapSort (10);
			timeHeapSort (100);
			timeHeapSort (1000);
			timeHeapSort (2000);
			timeHeapSort (3000);
			timeHeapSort (4000);
			timeHeapSort (5000);
			timeHeapSort (10000);
			timeHeapSort (20000);
		}
		testQuickSelect ();
		testIntervalSelect ();
    }	

    /* Slow O(n^2) sorting algorithms */
    
    public static int[] bubbleSort (int [] tab) {
		boolean swap = false;
		int j = 0;
		do {
		    swap = false;
		    for (int i = 0; i < tab.length-j-1; ++i) {
			    if (tab[i] > tab[i+1]) {
				    int tmp = tab[i];
				    tab[i] = tab[i+1];
				    tab[i+1] = tmp;
				    swap = true;
				}
			}
		    ++j;
		} while (swap);
		return tab;
    }

    public static int[] insertSort (int[] tab) {
		/* exercise */
		return tab;
    }
    
    public static int[] selectSort (int[] tab) {
		/* exercise */
		return tab;
    }

    /* Faster O(n log n) sorting algorithms */

    /* Heap sort */
    
    /* percolateDown, takes element at index i down to it's place
       int the max heap ending at last heap index = table index + 1 
       used in heapsort */
    private static int percolateDown (int[] table, int i, int last) {
	    /* exercise */
		return i;
    }

    public static int[] heapSort (int[] tab) {
		/* exercise */
		return tab;
    }
    
    /* Merge sort */

    /* 
       split 

       splits the list n into two halves: n will refer to the head of
       the smaller half and reference to the head of the larger half 
       (in case of odd length) is returned 
    */
    private static ListNode split (ListNode n) {
		int len = 0;
		for (ListNode i = n; i != null; i = i.next)
		    ++len;
		len /= 2;
		ListNode r;
		for (r = n; len > 1; --len)
		    r = r.next;
		ListNode result = r.next;
		r.next = null;
		return result;
    }

    /*
      merge
      
      Takes two sorted lists a and b and merges them into a longer sorted list
      and returns the new list. Lists a and b are destroyed.
    */

    private static ListNode merge (ListNode a, ListNode b) {
		ListNode result = null;
		if (a == null) 
			result = b;
		else if (b == null) 
			result = a;
		else {
			ListNode r;
			//determining the head for the result list
			if (a.data < b.data) {
				result = r = a;
				a = a.next;
			}
			else {
				result = r = b;
				b = b.next;
			}
			while (a != null && b != null) {
				if (a.data < b.data) {
					r.next = a;
					a = a.next;
				}
				else {
					r.next = b;
					b = b.next;
				}
				r = r.next;
			}
			if (a == null)
			    r.next = b;
			else
			    r.next = a;
		}
		return result;
    }
    
    /* 
       mergeSort

       takes a reference to the head of the list to be sorted as input and 
       returns head of the sorted list
    */
    public static ListNode mergeSort (ListNode n) {
		if (n != null && n.next != null) {
			ListNode a = split (n);
			a = mergeSort (a);
			n = mergeSort (n);
			n = merge (a, n);
		}
		return n;
    }


    /*
      Quicksort
    */
   
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

    /* 
       recursive part of quickSort 
       sorts tab[low..high] with quick sort 
    */
    private static void quickSort (int[] tab, int low, int high) {
		/* exercise */
    }
    
    /*
       part to start the recursion 
    */
    public static int[] quickSort (int[] tab) {
		/* exercises */
		return tab;
    }

    /* Variations on quicksort */

    /*
      quickSelect
      
      returns the ith element in the table tab, where low <= i <= high,
      if it was sorted without completely sorting it
    */
    
    private static int quickSelect (int[] tab, int i) {
		/* exercise hint: make a recursive subroutine as in quicksort */
		return 0;
    }
    
    /*
      intervalSelect
      
      returns the table with interval tab[l..h] in the order it would be if 
      the table was completely sorted without completely sorting the table.

    */

    public static int[] intervalSelect (int[] tab, int l, int h) {
		/* exercise (see previous hint) */
		return tab;
    }

    /* Testing and timing */

    public static boolean testSelectSort () {
		int[] a = null;
		boolean ok = true;
		System.out.println ("Testing selection sort.");
		for (int i = 0; ok && i < 10; ++i) {
			a = randomArray(20);
			a = selectSort (a);
			ok = isSorted(a);
		}
		if (! ok) {
			System.out.println ("Error: Incorrectly sorted, result was: ");
			printArray (a);
		}
		else {
			System.out.println ("Test passed.");
		}
		return ok;
    }

    public static boolean testBubbleSort () {
		int[] a = null;
		boolean ok = true;
		System.out.println ("Testing bubble sort.");
		for (int i = 0; ok && i < 10; ++i) {
			a = randomArray(20);
			a = bubbleSort (a);
			ok = isSorted(a);
		}
		if (! ok) {
			System.out.println ("Error: Incorrectly sorted, result was: ");
			printArray (a);
		}
		else {
			System.out.println ("Test passed.");
		}
		return ok;
    }

    public static boolean testInsertSort () {
		int[] a = null;
		boolean ok = true;
		System.out.println ("Testing insertion sort.");
		for (int i = 0; ok && i < 10; ++i) {
			a = randomArray(20);
			a = insertSort (a);
			ok = isSorted(a);
		}
		if (! ok) {
			System.out.println ("Error: Incorrectly sorted, result was: ");
			printArray (a);
		}
		else {
			System.out.println ("Test passed.");
		}
		return ok;
    }

    public static boolean testHeapSort () {
		int[] a = null;
		boolean ok = true;
		System.out.println ("Testing heap sort.");
		for (int i = 0; ok && i < 10; ++i) {
			a = randomArray(20);
			a = heapSort (a);
			ok = isSorted(a);
		}
		if (! ok) {
			System.out.println ("Error: Incorrectly sorted, result was: ");
			printArray (a);
		}
		else {
			System.out.println ("Test passed.");
		}
		return ok;
    }

    public static boolean testQuickSort () {
		int[] a = null;
		boolean ok = true;
		System.out.println ("Testing quick sort.");
		for (int i = 0; ok && i < 10; ++i) {
			a = randomArray(20);
			a = quickSort (a);
			ok = isSorted(a);
		}
		if (! ok) {
			System.out.println ("Error: Incorrectly sorted, result was: ");
			printArray (a);
		}
		else {
			System.out.println ("Test passed.");
		}
		return ok;
    }

    public static boolean testMergeSort () {
		ListNode a = null;
		boolean ok = true;
		System.out.println ("Testing merge sort.");
		for (int i = 0; ok && i < 10; ++i) {
			a = randomList(20);
			a = mergeSort (a);
			ok = isSorted(a);
		}
		if (! ok) {
			System.out.println ("Error: Incorrectly sorted, result was: ");
			printList (a);
		}
		else {
			System.out.println ("Test passed.");
		}
		return ok;
    }

    public static boolean testQuickSelect () {
		int[] tab = null; 
		int[] pos = null;
		int i = 0;
		int j = 0;
		int x = 0;
		boolean ok = true;
		System.out.println ("Testing quickSelect");
		for (i = 0; ok && i < 10; ++i) {
			tab = randomArray(20);
			pos = randomArray(20);
			for (j = 0; ok && j < 10; ++j) {
				x = quickSelect (tab, pos[j]);
				if (x != pos[j] || tab[x] != pos[j])
				    ok = false;
			}
		}
		if (! ok) {
			System.out.println ("Error: quickselect returned " + x + " from quickselect(tab, " + pos[j] + ") should be " + pos[j] + ". Array after selection: ");
			printArray (tab);
		}
		else {
			System.out.println ("Test passed.");
		}
		return ok;
    }

    public static boolean testIntervalSelect () {
		int[] tab = null; 
		int[] pos = null;
		int low = 0;
		int high = 0;
		boolean ok = true;
		System.out.println ("Testing intervalSelect");
		for (int i = 0; ok && i < 100; ++i) {
			tab = randomArray(20);
			pos = randomArray(20);
			low = pos[0];
			high = pos[1];
			if (low > high) {
				int tmp = low;
				low = high;
				high = tmp;
			}
			tab = intervalSelect (tab, low, high);
			for (int j = low; ok && j <= high; ++j) {
				if (tab[j] != j)
				    ok = false;
			}
		}
		if (! ok) {
			System.out.println ("Error: intervalSelect(tab,  " + low + ", " + high + ") returned ");
			printArray (tab);
		}
		else {
			System.out.println ("Test passed.");
		}
		return ok;
    }


    public static boolean isSorted (int[] a){
		boolean sorted = true;
		for (int i = 0; sorted && i < a.length; ++i)
		    if (a[i] != i)
			sorted = false;
		return sorted;
    }

    public static boolean isSorted (ListNode a) {
		boolean sorted = true;
		for (int i = 0; sorted && a != null; a = a.next, ++i)
		    if (a.data != i)
			sorted = false;
		return sorted;
    }

    public static void timeSelectSort(int n) {
		int[][] a = new int[30][];
		long time = 0;
		long start;
		long end;
		for (int i = 0; i < 30; ++i)
		    a[i] = randomArray (n);
		System.gc();
		start = System.currentTimeMillis ();
		for(int i = 0 ; i < 30; ++i)
		    selectSort (a[i]);
		end = System.currentTimeMillis ();
		time = end - start;
		System.out.println ("Selectsort " + n + ": " + (time/30.0) + " ms");
    }

    public static void timeInsertSort(int n) {
		int[][] a = new int[30][];
		long time = 0;
		long start;
		long end;
		for (int i = 0; i < 30; ++i)
		    a[i] = randomArray (n);
		System.gc();
		start = System.currentTimeMillis ();
		for(int i = 0 ; i < 30; ++i)
		    insertSort (a[i]);
		end = System.currentTimeMillis ();
		time = end - start;
		System.out.println ("Insertsort " + n + ": " + (time/30.0) + " ms");
    }

    public static void timeBubbleSort(int n) {
		int[][] a = new int[30][];
		long time = 0;
		long start;
		long end;
		for (int i = 0; i < 30; ++i)
		    a[i] = randomArray (n);
		System.gc();
		start = System.currentTimeMillis ();
		for(int i = 0 ; i < 30; ++i)
		    bubbleSort (a[i]);
		end = System.currentTimeMillis ();
		time = end - start;
		System.out.println ("Bubblesort " + n + ": " + (time/30.0) + " ms");
    }

    public static void timeQuickSort(int n) {
		int[][] a = new int[30][];
		long time = 0;
		long start;
		long end;
		for (int i = 0; i < 30; ++i)
		    a[i] = randomArray (n);
		System.gc();
		start = System.currentTimeMillis ();
		for(int i = 0 ; i < 30; ++i)
		    heapSort (a[i]);
		end = System.currentTimeMillis ();
		time = end - start;
		System.out.println ("Quicksort " + n + ": " + (time/30.0) + " ms");
    }

    public static void timeHeapSort(int n) {
		int[][] a = new int[30][];
		long time = 0;
		long start;
		long end;
		for (int i = 0; i < 30; ++i)
		    a[i] = randomArray (n);
		System.gc();
		start = System.currentTimeMillis ();
		for(int i = 0 ; i < 30; ++i)
		    heapSort (a[i]);
		end = System.currentTimeMillis ();
		time = end - start;
		System.out.println ("Heapsort " + n + ": " + (time/30.0) + " ms");
    }

    public static void timeMergeSort(int n) {
		ListNode[] a = new ListNode[30];
		long time = 0;
		long start;
		long end;
		for (int i = 0; i < 30; ++i)
		    a[i] = randomList (n);
		System.gc();
		start = System.currentTimeMillis ();
		for(int i = 0 ; i < 30; ++i)
		    a[i] = mergeSort (a[i]);
		end = System.currentTimeMillis ();
		time = end - start;
		System.out.println ("Mergesort " + n + ": " + (time/30.0) + " ms");
    }

    private static void printList (ListNode n) {
		System.out.print ("(");
		while (n != null)
		    {
			System.out.print (n.data);
			if (n.next != null)
			    System.out.print (" ");
			n = n.next;
		    }
		System.out.println (")");	
    }

    private static void printArray (int[] tab) {
		System.out.print ("(");
		for (int i = 0; i < tab.length-1; ++i)
		    System.out.print (tab[i] + " ");
		System.out.println (tab[tab.length-1] + ")");
    }
				    
    private static ListNode arrayToList (int[] tab) {
		ListNode result = null;
		for (int i = tab.length-1; i >= 0; --i)
		    result = new ListNode (tab[i], result);
		return result;
    }

    private static ListNode randomList (int n) {
		return arrayToList (randomArray(n));
    }

    private static Random r = new Random ();

    private static int[] randomArray (int n) {
		int[] keys = new int [n];
		for (int i = 0; i < n; ++i)
		    keys[i] = i;
		for (int i = 0; i < n; ++i) {
			int pos = i + r.nextInt(n-i);
			int tmp = keys[pos];
			keys[pos] = keys[i];
			keys[i] = tmp;
		}
		return keys;
    }
}
