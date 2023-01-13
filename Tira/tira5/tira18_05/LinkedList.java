/* Simple linked list that contains ints. The last node has null in the 
   reference to next and head is the reference to the first node in the list
   or null if the list is empty */

class LinkedList
{
    public LinkedList ()
    {
	this.head = null;
    }

    /* returns true, if the list is empty, else false */
    public boolean isEmpty ()
    {
	return head == null;
    }

    /* returns the first element of the list, assuming that the list is not empty */
    public int front ()
    {
	return head.data;
    }

    /* prints the list */
    public void print ()
    {
	System.out.print("(");
	for (ListNode i = head; i != null; i = i.next)
	    System.out.print(i.data + " ");
	System.out.println(")");
    }

    /* inserts x into the beginning of the list */
    public void insertFront (int x)
    { /* excercise */    }

    /* returns true, if x is in the list, else false */
    public boolean find (int x)
    { /* excercise */ return true;  } 

    /* removes the first occurrence of x from the list and returns true
       if the removal was successful. In the case of unsuccesful removal
       (i.e. list is empty of x is not in the list) returns false */
    public boolean delete (int x)
    { /* excercise */  return true;  } 

    /* sorts the list in ascending order */
    public void sort ()
    { /* excercise */  } 
    
    public ListNode head;
}
