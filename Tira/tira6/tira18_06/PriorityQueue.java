/*
 * Class PriorityQueue describes an implementation of a priority queue. 
 */

public class PriorityQueue {
	/*
	 * An empty priority queue.
	 */
	public PriorityQueue() {
		_size = 0;
		_first = _last = null;
	}
	/*
	 * Returns the number of elements in the priority queue.
	 */
	public long size() {
		return _size;
	}
	/*
	 * Returns logical true if the priority queue is empty.
	 */
	public boolean isEmpty() {
		return _size == 0;
	}
	/*
	 * Insert a new key/item pair into the priority queue
	 * according to the principle of insertion sort. Hence,
	 * the nodes of the priority queue are in ascending order
	 * according to the key values.
	 */
	public void insertItem(long key, Object item) {

		/*
		 * Exercise, add your implementation here.
		 */

	}
	/*
	 * Returns the element with the smallest key, but does not
	 * remove the element from the priority queue.
	 */
	public Object minElement() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else {
			return _first.getElement();
		}
	}
	/*
	 * Returns the smallest key.
	 */
	public long minKey() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		} else {
			return _first.getKey();
		}
	}
	/*
	 * Removes and returns the item with the smallest
	 * key.
	 */
	public Object removeMinElement() {

		/*
		 * Exercise, add your implementation here.
		 */

	}
	/*
	 * Returns the item at rank k (k in [1,size]).
	 */
	public Object elementAtRank(long k) throws IndexOutOfBoundsException {
		if (k < 1 || _size < k) {
			throw new IndexOutOfBoundsException();
		} else {
			if (k <= _size/2) {
				PQNode iter = _first;
				for (long i = 1; i < k; i++) {
					iter = iter.getNext();
				}
				return iter.getElement();
			} else {
				PQNode iter = _last;
				for (long i = 1; i < _size - k + 1; i++) {
					iter = iter.getPrev();
				}
				return iter.getElement();
			}
		}
	}
	/*
	 * For testing. Returns true if isEmpty() == true or _first and _last point to the same node.
	 */
	boolean OneAndTheSame() {
		return (_first == null && _last == null) || _first.equals(_last);
	}
	private long _size;
	private PQNode _first, _last;
}
