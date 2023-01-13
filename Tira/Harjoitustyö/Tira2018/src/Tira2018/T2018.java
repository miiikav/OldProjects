package Tira2018;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Float;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class T2018{
	
private	String line;
private float x[];
private float y[];
private void readInput(){

	  x=new float[400];
          y=new float[400];
	 try {
            BufferedReader br = new BufferedReader( new FileReader("Tdata.txt"));
            for(int i=0; i<400; i++){
                line=br.readLine();
                String[] values=line.split(",");
                x[i]=Float.parseFloat(values[0]);
                y[i]=Float.parseFloat(values[1]);
                System.out.print(x[i]+" , "+y[i]+"\n");
              
         }
	 } catch(IOException e)
	 {
	    System.out.println("File not found.");
	 }
}

private void writeOutput(){
	
    
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        for(int i=0; i<10; i++){
            bw.write(Float.toString(x[i]));
            bw.write(",");
            bw.write(Float.toString(y[i]));
            bw.newLine();
        }
        bw.close();
		 
    } catch (IOException e) {
    System.err.format("IOException: %s%n", e);
}
  System.out.println("Tiedosto kirjoitettu");
}

private void BFSOutput(){
	
    
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("BFS.txt"));
        for(int i=0; i<10; i++){
            bw.write(Float.toString(x[i]));
            bw.write(",");
            bw.write(Float.toString(y[i]));
            bw.newLine();
        }
        bw.close();
		 
    } catch (IOException e) {
    System.err.format("IOException: %s%n", e);
}
  System.out.println("Tiedosto kirjoitettu");
}
private void DFSOutput(){
	
    
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("DFS.txt"));
        for(int i=0; i<10; i++){
            bw.write(Float.toString(x[i]));
            bw.write(",");
            bw.write(Float.toString(y[i]));
            bw.newLine();
        }
        bw.close();
		 
    } catch (IOException e) {
    System.err.format("IOException: %s%n", e);
}
  System.out.println("Tiedosto kirjoitettu");
}





public static void main(String[] args){
    
    T2018 ht=new T2018();
    ht.readInput();
    ht.writeOutput();
    double wab = Integer.MAX_VALUE;
    double wac = 0;

    ArrayList<Node> nodelist = new ArrayList<>();
    ArrayList<Node> reversenodelist = new ArrayList<>();
    for(int i=0; i<400; i++){
        Node n = new Node(ht.x[i],ht.y[i]);
        nodelist.add(n);
        reversenodelist.add(n);
        
    }
    
    Node n = null;
    Node b = null;
    Node c = null;
    Collections.reverse(reversenodelist);
    LinkedList<Edge> neighbors_list= new LinkedList<>();
    for(int i=0; i<400; i++){
        float currentx = nodelist.get(i).getX();
        float currenty = nodelist.get(i).getY();
        n = new Node(currentx,currenty);
        for(int i2=0; i2<400; i2++){
            float comparex = reversenodelist.get(i2).getX();
            float comparey = reversenodelist.get(i2).getY();
            Node n2 = new Node(comparex,comparey);
            double d=n.euclidean(n2);
            if(d==0){
            }
            else if(d<wab) {
                wac=wab;
                wab=d;
                c=b;
                b=n2;
            }
            else{
            }
        }
        Edge e = new Edge(n,b,c,wab,wac);
        neighbors_list.add(e);
        wab = Integer.MAX_VALUE;
        wac = 0;
    }
    

        for(int i=0; i<400; i++){ //tulostaa solmun ja sen lähinaapureiden kordinaatit
    System.out.println("--------------------------");
    System.out.println(i+" "+neighbors_list.get(i).getA()+" kordinaatit: "+neighbors_list.get(i).getA().getX()+" "+neighbors_list.get(i).getA().getY());
    System.out.println("  "+neighbors_list.get(i).getB()+" kordinaatit: "+neighbors_list.get(i).getB().getX()+" "+neighbors_list.get(i).getB().getY()+" väli: "+neighbors_list.get(i).getWeightab());
    System.out.println("  "+neighbors_list.get(i).getC()+" kordinaatit: "+neighbors_list.get(i).getC().getX()+" "+neighbors_list.get(i).getC().getY()+" väli: "+neighbors_list.get(i).getWeightac());
    System.out.println("---------------------------");
    }

    Graph g = new Graph(400);
            
    for(int i=0; i<400; i++){
        Edge get = neighbors_list.get(i);
        g.addUndirectedEdge(get.getA(),get.getB(),get.getWeightab());
    }
    //g.depthFirstSearch (0);
    //g.breadthFirstSearch (0);
    //double distance=n.euclidean(n);
    //for(int i=0; i<400; i++){
        //Node o =(Node) nodelist.get(i);
        //double distance=n.euclidean(?);
    //}

}
}