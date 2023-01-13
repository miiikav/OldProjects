package Tira18_03;

/*
Tietorakenteet - kaksiloppuinen jono

Data structures - double ended queue
*/

class Deque
{

    private int size;
	/*
	 boolean IsEmpty ()
	 palauttaa true, jos jono on tyhj�, muutoin false.

	 returns true, if queue is empty, false otherwise 
	*/
	public boolean IsEmpty ()
	{
		return head == null;
                
	}

	/*
	void insertFirst (Object o)
	laittaa olion o jonon ensimm�iseksi

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
                        size++;
		}
	}

	/*
	Object removeFirst ()
	palauttaa jonon ensimm�isen alkion
	palauttaa null, jos jono on tyhj�, parempi olisi k�sitell� virhe
	poikkeuksella, mutta j�tet��n se tekem�tt� yksinkertaisuuden vuoksi

	Removes and returns the first object in the queue, null if queue is empty
	*/
	public Object removeFirst ()
	{
		Object result = null;
		if (! IsEmpty ())
		{
			result = head.data;
			head = head.next;
                        
			if (head != null) 
				// linkki edelliseen irti, ettei j�� muistiin roikkumaan
				head.prev = null; 
			else
				// tail irti, ettei j�� viimeinen alkio roikkumaan
				tail = null;
                        size--;
		}
		return result;
	}

	/* 
	void insertLast (Object o)
	laittaa olion o jonon viimeiseksi

	inserts object o to the back of the queue
	*/

	public void insertLast (Object o)
	{
		DoubleLinkNode n = new DoubleLinkNode (o);
		if (IsEmpty ())
                    head = tail = n;
                else
		{
			tail.next = n;
			n.prev = tail;
			tail = n;
                        size++;
		}
	}

	/* 
	Object removeLast () poistaa jonon viimeisen alkion.
	Jos jono on tyhj�, palautetaan null.
	
	Removes and returns the last object in the queue, null if queue is empty
	*/

	public Object removeLast ()
	{
		/* harjoitusteht�v� */
		Object result = null;
		if (! IsEmpty ())
		{
		    result = tail.data;
                    
                    tail = findNode(size);
                    if(size<0){
                        head=null;
                    }    
			if (tail != null) 
				// linkki edelliseen irti, ettei j�� muistiin roikkumaan
				tail.prev = null;
                                
			else
				// tail irti, ettei j�� viimeinen alkio roikkumaan
				tail = null;
                    size--;

		}
		return result;
	}


	/* 
	void Reverse ()
	K��nt�� jonon alkiot p�invastaiseen j�rjestykseen

	reverses the order of the objects in the queue
	*/
	//aikakompleksisuus O(n)
    public void Reverse (){
        DoubleLinkNode next=null;
        DoubleLinkNode current = head; 
        DoubleLinkNode prev=null;
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        head = prev; 
    }

	private DoubleLinkNode head;
	private DoubleLinkNode tail;
        private DoubleLinkNode findNode(int target) {
            if (! IsEmpty ()) {

                // Aloitetaan listan p��st�.
                DoubleLinkNode node = head;

                // Kelataan oikeaan kohtaan.
                    for (int i = 0; i < target; i++)
                        //System.out.print(i);//System.out.print(target);
                        node = node.next;
                // Palautetaan.
                return node;
            }

            // Virheellinen paikka.
            else
                return null;
   }
}
