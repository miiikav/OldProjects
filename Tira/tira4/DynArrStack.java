package tira18_04;

 
class DynArrStack
{

	private int N; /* The current size of the array. */

	private Object[] A; /* The array for holding the objects of the stack. */

	

	/* n: the number of items in the stack.
	 * We do not keep a separate variable 'top' for the index of the last stack
	 * item because top = n-1.
	 */

	private int n;



	/* Constructor: initializes N to 1, n to 0 and allocates a size-N array A. */
	public DynArrStack()
	{
		N = 1;

		n = 0;
		A = new Object[N];
	}


	/* Returns true if stack is empty, and false otherwise. */
	public boolean isEmpty()
	{
		return n == 0;
	}

	

	/* Returns the current size of the array A. */
	public int arraySize()
	{
		return N;
	}

	

	

	/************** EXERCISES ARE BELOW **************/

	

	/* Insert Object x on top of the stack (= to index n).
	 * If n = N, move the stack into a new array that is twice
	 * as large (e.g. double N, create a new size N array, move
	 * the stack items from old A, and replace A by the new array).
	 */

	public void push( Object x )
	{
		/* Exercise, add your implementation here. */
            A[n]=x;
            System.out.println(n);
            if(n==N){
                Object[] B = new Object[N*2];
                B[n]=A[n];
                A=B;
            }
	}


	/* Remove Object x from top of the stack (= from index n-1) and return it.
	 * Returns null if the stack is empty.
	 * If after the removal n = N/4 and N >= 2, move the stack into a new array
	 * that is half as large (e.g. divide N by two, create a new size N array, move
	 * the stack items from old A, and replace A by the new array).
	 */
	public Object pop ()
	{
            
            if(isEmpty()){
                return null;
            }
            else{
                Object x = A[n-1];
                A[n-2] =null;
                if(n==N/4 && N >= 2){
                    Object[] B = new Object[N/2];
                    B[n]=A[n];
                    A=B;
                }
                return x;
            }
		/* Exercise, add your implementation here. */
	}
}
