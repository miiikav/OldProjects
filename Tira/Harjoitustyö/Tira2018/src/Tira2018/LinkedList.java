/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tira2018;

/**
 *
 * @author tuomo
 */
/* Yksinkertainen int-alkioita sisältävä yhteen suuntaan linkitetty lista,
   jonka viimeisen solmun next alkio on null, ja head on listan ensimmäinen
   alkio tai null, jos lista on tyhjä. */

class LinkedList {

    /*    public LinkedList () {
    this.head = null;
    }
    
    /* palauttaa true, jos lista on tyhjä, muutoin false */
    /* returns true, if list is empty, otherwise false */
    /*    public boolean isEmpty () {
    return head == null;
    }
    
    /* palauttaa listan ensimmäisen alkion, olettaen, ettei lista  ole tyhjä */
    /* returns the element from a list supposing that the list is nonempty */
    /*    public int front () {
    return head.data;
    }*/

    /* tulostaa listan */
	/* prints the content of a list */ 
    /*public void print () {
    System.out.print("(");
    for (Node i = head; i != null; i = i.next)
    System.out.print(i.data + " ");
    System.out.println(")");
    }*/

    /* lisää alkion x listan alkuun */
	/* adds an element x to the beginning of a list */
    /*    public void insertFront (int x) {
    Node n = new Node ();
    n.data = x;
    n.next = head;
    head = n;
    }*/

    /* palauttaa true, jos x on listassa, muutoin false */
	/* returns true, if x is in a list, otherwise false */
    /*    public boolean find (int x) {
    for (Node i = head; i != null; i = i.next)
    if (i.data == x)
    return true;
    return false;
    }*/

    /* poistaa alkion x ensimmäisen esiintymän listasta ja palauttaa true,
       jos poisto onnistui. Epäonnistuneen poiston tapauksessa palautetaan
       false (siis jos alkiota ei löydy tai lista on tyhjä) */
	   
	/* removes the first occurrence of an element x from a list and returns 
	true, if remove was successful. In a non-successful case false is returned
	(if element cannot be found or list is empty) */ 	
    /*    public boolean delete (int x) {
    Node i = head;
    Node temp = head;
    
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
    }*/

    /* lajittelee listan nousevaan järjestykseen */
	/* sorts the list into ascending order */
    /*    public void sort () {
    if (head != null) {
    Node i = head.next;
    head.next = null;
    while (i != null) {
    Node t;
    if (i.data < head.data) {
    t = i.next;
    i.next = head;
    head = i;
    i = t;
    }
    else {
    Node j = head;
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
    
    public Node head;*/
}
