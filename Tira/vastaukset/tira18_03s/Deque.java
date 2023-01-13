/*
Tietorakenteet - kaksiloppuinen jono

Data structures - double ended queue
*/

class Deque
{
	/*
	 boolean IsEmpty ()
	 palauttaa true, jos jono on tyhj‰, muutoin false.

	 returns true, if queue is empty, false otherwise 
	*/
	public boolean IsEmpty ()
	{
		return head == null;
	}

	/*
	void insertFirst (Object o)
	laittaa olion o jonon ensimm‰iseksi

	inserts object o to the front of the queue
	*/
	public void insertFirst (Object o)
	{
		DoubleLinkNode n = new DoubleLinkNode (o);
		if (IsEmpty ())
			head = tail = n;
		else
		{
			n.next = head;
			head.prev = n;
			head = n;
		}
	}

	/*
	Object removeFirst ()
	palauttaa jonon ensimm‰isen alkion
	palauttaa null, jos jono on tyhj‰
	(voisi olla parempi  k‰sitell‰ virhe poikkeuksella, 
	mutta j‰tet‰‰n se tekem‰tt‰ yksinkertaisuuden vuoksi)

	returns first object in the queue, null if queue is empty
	*/
	public Object removeFirst () {
		Object result = null;
		if (! IsEmpty ()) {
			result = head.data;
			head = head.next;
			if (head != null) 
				// linkki edelliseen irti, ettei j‰‰ muistiin roikkumaan
				head.prev = null; 
			else
				// tail irti, ettei j‰‰ viimeinen alkio roikkumaan
				tail = null;
		}
		return result;
	}

	/* 
	void insertLast (Object o)
	laittaa olion o jonon viimeiseksi

	inserts object o to the back of the queue
	*/

	public void insertLast (Object o) {
	    DoubleLinkNode n = new DoubleLinkNode (o);
	    if (IsEmpty ())
			head = tail = n;
	    else {
		    n.prev = tail;
		    tail.next = n;
		    tail = n;
        }
	}

	/* 
	Object removeLast ()
	poistaa ja palauttaa jonon viimeisen alkion
	palauttaa null, jos jono on tyhj‰
	(voisi olla parempi  k‰sitell‰ virhe poikkeuksella, 
	mutta j‰tet‰‰n se tekem‰tt‰ yksinkertaisuuden vuoksi)

	Removes and returns the last object in the queue, null if queue is empty
	*/

	public Object removeLast () {
		Object result = null;

        if (! IsEmpty ()) {
            result = tail.data;
            tail = tail.prev;
            if (tail != null)
	    	// linkki seuraavaan irti, ettei jaa muistiin roikkumaan
                tail.next = null;
            else
	    	// head irti, ettei jaa ensimmainen alkio roikkumaan
                head = null;
        }
        return result;
   
	}


	/* 
	 void Reverse ()
	K‰‰nt‰‰ jonon alkiot p‰invastaiseen j‰rjestykseen

	reverses the order of the objects in the queue
	*/
	
	public void Reverse ()
	{
		DoubleLinkNode tmp;
		for (DoubleLinkNode i = head; i != null; i = i.prev)
		{
		  tmp = i.next;
		  i.next = i.prev;
		  i.prev = tmp;
		}
		tmp = head;
		head = tail;
		tail = tmp;
	}
    
	private DoubleLinkNode head;
	private DoubleLinkNode tail;
}
