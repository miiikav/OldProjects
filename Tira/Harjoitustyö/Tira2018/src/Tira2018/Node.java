/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tira2018;
import java.util.LinkedList;
import java.lang.Math;
import java.util.Stack;
import javax.swing.tree.DefaultMutableTreeNode;
/**
 *
 * @author ti427620
 */
public class Node {

    /*
    * Attribuutit.
    *
    */
    private float x; //Pisteen x-koordinaatti.
    private float y; //Pisteen y-koordinaatti. 
    private boolean visited;
    private LinkedList<Edge> neighbors; //Linkit pisteen “naapureihin”
    

    /*
    * Rakentajat.
    *
    */
    public Node(float x, float y)
    {
        this.x = x;
        this.y = y;
        this.neighbors = new LinkedList<>();
        this.visited = false;
        
    }

    
    /*
     * Aksessorit.
     *
     */
    

    public LinkedList<Edge> getNeighbors() {
        return neighbors;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    
    
     /*
     * Metodit.
     *
     */
    
    public double euclidean(Node n) {
        double x = n.getX() - this.getX();
        double y = n.getY() - this.getY();
        x = Math.pow(x, 2);
        y = Math.pow(y, 2);
        double xy =x+y;
        return Math.sqrt(xy);
    }
}