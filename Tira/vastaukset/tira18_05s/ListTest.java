class ListTest
{
    public static void main (String[] args)
    {
	LinkedList l = new LinkedList ();
	System.out.println ("TEST 1 ------------------------------------------");

	System.out.println ("Inserting 1..10");
	for (int i = 1; i <= 10; ++i)
	    l.insertFront (i);
	l.print ();	
	System.out.println ("Finding all the numbers");
	for (int i = 1; i <= 10; ++i)
	    {
		if (l.find (i))
		    System.out.println ("CORRECT: " + i + " was found");
		else
		    System.out.println ("INCORRECT: " + i + " was not found");
	    }

	/* Test removal of first element */
	System.out.println ("Removing 10, testing that 10 is not found and all others are");
	if (l.delete (10) == true)
	    System.out.println ("CORRECT: removal of 10 successful");
	else
	    System.out.println ("INCORRECT: removal of 10 unsuccesfull");
	l.print ();	
	if (l.find (10) == true)
	    System.out.println ("INCORRECT: 10 is still in the list");
	else
	    System.out.println ("CORRECT: 10 is no longer in the list");

	for (int i = 1; i < 10; ++i)
	    {
		if (l.find (i))
		    System.out.println ("CORRECT: " + i + " was found");
		else
		    System.out.println ("INCORRECT: " + i + " was not found");
	    }

	/* Test removal of last element */
	System.out.println ("Removing 1, testing that it is not in the list and the rest are.");
	if (l.delete (1) == true)
	    System.out.println ("CORRECT: removal of 1 successful");
	else
	    System.out.println ("INCORRECT: removal of 1 unsuccessful");
	l.print ();	
	if (l.find (1) == true)
	    System.out.println ("INCORRECT: 1 is still in the list");
	else
	    System.out.println ("CORRECT: 1 is no longer in the list");

	for (int i = 2; i < 10; ++i)
	    {
		if (l.find (i))
		    System.out.println ("CORRECT: " + i + " was found");
		else
		    System.out.println ("INCORRECT: " + i + " was not found");
	    }

	/* Test removal in the middle */
	System.out.println ("Removing 5, testing that it is not in the list and the rest are.");
	if (l.delete (5) == true)
	    System.out.println ("CORRECT: removal of 5 succesful");
	else
	    System.out.println ("INCORRECT: removal of 5 unsuccesful");
	l.print ();	
	if (l.find (5) == true)
	    System.out.println ("INCORRECT: 5 is still in the list");
	else
	    System.out.println ("CORRECT: 5 is no longer in the list");

	for (int i = 2; i < 5; ++i)
	    {
		if (l.find (i))
		    System.out.println ("CORRECT: " + i + " was found");
		else
		    System.out.println ("INCORRECT: " + i + " was not found");
	    }
	for (int i = 6; i < 10; ++i)
	    {
		if (l.find (i))
		    System.out.println ("CORRECT: " + i + " was found");
		else
		    System.out.println ("INCORRECT: " + i + " was not found");
	    }

	System.out.println ("Testing removal of non-existing (11).");
	if (l.delete(11) == true)
	    System.out.println ("INCORRECT: the number 11 should not have been in the list");
	else
	    System.out.println ("CORRECT: the number 11 is not in the list so the deletion is unsuccesful");
	
	System.out.println ("Removing rest of the numbers");
	for (int i = 2; i < 5; ++i)
	    l.delete(i);
	for (int i = 6; i < 10; ++i)
	    l.delete(i);
	l.print ();	
	
	System.out.println ("Testing, if the list is empty");
	if (l.isEmpty() == true)
	    System.out.println ("CORRECT: the list is empty.");
	else
	    System.out.println ("INCORRECT: the list should have been empty");

	System.out.println ("Testing find on an empty list");
	if (l.find (1))
	    System.out.println ("INCORRECT: 1 was found in an empty list");
	else
	    System.out.println ("CORRECT: 1 was not found in an empty list");

	System.out.println ("Testing deletion from empty list");
	if (l.delete (1))
	    System.out.println ("INCORRECT: deletion of 1 from empty list was succesful");
	else
	    System.out.println ("CORRECT: deletion of 1 failed");

	System.out.println ("TEST 2 ------------------------------------------");
	System.out.println ("Testing sorting");
	System.out.println ("Inserting 1..10 in random order");
	l.insertFront (9);
	l.insertFront (1);
	l.insertFront (4);
	l.insertFront (3);
	l.insertFront (7);
	l.insertFront (6);
	l.insertFront (5);
	l.insertFront (2);
	l.insertFront (10);
	l.insertFront (8);
	l.print ();	
	l.sort ();
	l.print ();
	System.out.println ("Testing ordering by removing first");
	for (int i = 1; i <= 10; ++i)
	    {
		if (l.front() != i)
		    System.out.println ("INCORRECT: The first should be " 
					+ i + " but it was " + l.front());
		else
		    System.out.println ("CORRECT: The first was " + i);
		l.delete(i);
	    }
    }
}
