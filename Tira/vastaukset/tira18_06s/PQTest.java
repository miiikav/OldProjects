/*
 * A class for testing the priority queue.
 */

public class PQTest {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		System.out.println("Testing insertion...");
		pq.insertItem(5,"A");
		pq.insertItem(9,"C");
		pq.insertItem(-5,"Z");
		pq.insertItem(3,"B");
		pq.insertItem(7,"D");
		pq.insertItem(-1,"G");
		pq.insertItem(10,"P");
		pq.insertItem(3,"H");
		System.out.print("After several insertions, the priority queue has the form [");
		for (int i = 1; i <= pq.size(); i++) {
			System.out.print(pq.elementAtRank(i));
			if (i < pq.size()) {
				System.out.print(",");
			}
		}
		System.out.println("] (should be [Z,G,H,B,A,D,C,P] or [Z,G,B,H,A,D,C,P] depending on the ordering of keys with equal values).");
		System.out.println("OneAndTheSame() returned '" + pq.OneAndTheSame() + "' (should have returned 'false').");
		System.out.println("Testing removal...");
		System.out.println("removeMinElement() returned '" + pq.removeMinElement() + "' (should have returned 'Z').");
		System.out.println("removeMinElement() returned '" + pq.removeMinElement() + "' (should have returned 'G').");
		System.out.println("removeMinElement() returned '" + pq.removeMinElement() + "' (should have returned 'H' or 'B' depending on the ordering of keys with equal values).");
		System.out.println("size() returned '" + pq.size() + "' (should have returned '5').");
		System.out.println("Removing some more...");
		while (pq.size() > 1) {
			pq.removeMinElement();
		}
		System.out.println("OneAndTheSame() returned '" + pq.OneAndTheSame() + "' (should have returned 'true').");
		System.out.println("removeMinElement() returned '" + pq.removeMinElement() + "' (should have returned 'P').");
		System.out.println("Finally, size() returned '" + pq.size() + "' (should have returned '0') and OneAndTheSame() returned '" + pq.OneAndTheSame() + "' (should have returned 'true').");
	}
}
