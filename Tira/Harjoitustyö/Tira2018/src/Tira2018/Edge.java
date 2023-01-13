/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tira2018;

/**
 *
 * @author ti427620
 */
public class Edge {
    private Node a,b,c;
    private double weightab, weightac;
    //private Node from,to;
    //private double weight;

    public Edge(Node a, Node b, Node c, double weightab, double weightac) {
        this.a = a; //alkuperäinen Solmu
        this.b = b; //Solmun lähin naapuri
        this.c = c; //Solmun toiseksi lähin naapuri
        this.weightab = weightab; //a:n etäisyys b:stä
        this.weightac = weightac; //a:n etäisyys c:stä
    }

    /*    private Edge(Node from, Node to, double weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
    }*/
    

    public Node getA() {
        return a;
    }

    public Node getB() {
        return b;
    }

    public Node getC() {
        return c;
    }

    public double getWeightab() {
        return weightab;
    }

    public double getWeightac() {
        return weightac;
    }
}

