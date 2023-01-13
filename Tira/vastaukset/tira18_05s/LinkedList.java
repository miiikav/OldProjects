/* Yksinkertainen int-alkioita sis�lt�v� yhteen suuntaan linkitetty lista,
   jonka viimeisen solmun next alkio on null, ja head on listan ensimm�inen
   alkio tai null, jos lista on tyhj�. */

class LinkedList {

    public LinkedList () {
		this.head = null;
    }

    /* palauttaa true, jos lista on tyhj�, muutoin false */
	/* returns true, if list is empty, otherwise false */
    public boolean isEmpty () {
		return head == null;
    }

    /* palauttaa listan ensimm�isen alkion, olettaen, ettei lista  ole tyhj� */
	/* returns the element from a list supposing that the list is nonempty */
    public int front () {
		return head.data;
    }

    /* tulostaa listan */
	/* prints the content of a list */ 
    public void print () {
		System.out.print("(");
		for (ListNode i = head; i != null; i = i.next)
		    System.out.print(i.data + " ");
		System.out.println(")");
    }

    /* lis�� alkion x listan alkuun */
	/* adds an element x to the beginning of a list */
    public void insertFront (int x) {
		ListNode n = new ListNode ();
		n.data = x;
		n.next = head;
		head = n;
    }

    /* palauttaa true, jos x on listassa, muutoin false */
	/* returns true, if x is in a list, otherwise false */
    public boolean find (int x) {
    	for (ListNode i = head; i != null; i = i.next)
    		if (i.data == x)
    			return true;
    	return false;  
	}

    /* poistaa alkion x ensimm�isen esiintym�n listasta ja palauttaa true,
       jos poisto onnistui. Ep�onnistuneen poiston tapauksessa palautetaan
       false (siis jos alkiota ei l�ydy tai lista on tyhj�) */
	   
	/* removes the first occurrence of an element x from a list and returns 
	true, if remove was successful. In a non-successful case false is returned
	(if element cannot be found or list is empty) */ 	
    public boolean delete (int x) {
    	ListNode i = head;
    	ListNode temp = head;
    	
    	if (head == null)
    		return false;
    	if (head.data == x) {
    		head = head.next;
    		return true;
    	}
    	while (i.next != null) {
    		temp = i.next;
    		if (temp.data == x) {
    			i.next = temp.next;
    			return true;
    		}
    		i = i.next;
    	}
    	return false;  
    }

    /* lajittelee listan nousevaan j�rjestykseen */
	/* sorts the list into ascending order */
    public void sort () {
		if (head != null) {
			ListNode i = head.next;
			head.next = null; 
			while (i != null) {
				ListNode t;
				if (i.data < head.data) {
					t = i.next; 
					i.next = head;
					head = i;
					i = t;
				}
				else {
					ListNode j = head;
					for (; j.next != null && j.next.data < i.data; j = j.next) 
					    ;
					t = i;
					i = i.next;
					t.next = j.next;
					j.next = t; 
				}
			}
		}
    }

    public ListNode head;
}
