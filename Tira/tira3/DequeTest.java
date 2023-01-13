
class DequeTest
{
	public static void main (String[] args)
	{
		Deque dq = new Deque ();
		System.out.println ("Testi #1");
		System.out.println ("Lukuja jonon alkuun:");
		for (int i = 0; i < 10; ++i)
		{
			dq.insertFirst (new Integer (i));
			System.out.print (" " + i);
		}
		System.out.println ();
		System.out.println ("Lukuja jonon alusta:");    
		while (! dq.IsEmpty ())
		{
			System.out.print (" " + (Integer)dq.removeFirst());
		}
		/* Ota kommentit pois, niin voit testata omaa toteutustasi */
		/*
		// testi kirjoitus ja luku lopusta
		System.out.println ();
		System.out.println ("Testi #2");
		System.out.println ("Lukuja jonon loppuun:");    
		for (int i = 0; i < 10; ++i)
		{
			dq.insertLast (new Integer (i));
			System.out.print (" " + i);
		}
		System.out.println ();
		System.out.println ("Lukuja jonon lopusta:");    
		while (! dq.IsEmpty ())
		{
			System.out.print (" " + (Integer)dq.removeLast());
		}
		
		//testi kirjoitus alkuun ja luku lopusta 
		System.out.println ();
		System.out.println ("Testi #3");
		System.out.println ("Lukuja jonon alkuun:");    
		for (int i = 0; i < 10; ++i)
		{
			dq.insertFirst (new Integer (i));
			System.out.print (" " + i);
		}
		System.out.println ();
		System.out.println ("Lukuja jonon lopusta:");    
		while (! dq.IsEmpty ())
		{
		System.out.print (" " + (Integer)dq.removeLast());
		}
		// testi kirjoitus alkuun, reverse ja sitten uusi luku lopusta 
		System.out.println ();
		System.out.println ("Testi #4");
		System.out.println ("Lukuja jonon alkuun:");    
		for (int i = 0; i < 10; ++i)
		{
			dq.insertFirst (new Integer (i));
			System.out.print (" " + i);
		}
		*/
		
		System.out.println ();
		System.out.println ("Reverse");
		dq.Reverse();
		System.out.println ("Lukuja jonon lopusta:");    
		while (! dq.IsEmpty ())
		{
			System.out.print (" " + (Integer)dq.removeLast());
		}
		
	}
}
