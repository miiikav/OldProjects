/*
   Graph

   Simple adjacency matrix-based graph with n nodes numbered from
   0 to n-1. 
*/


import java.util.Random;

class Graph {
    /*
       class Edge

       Implements the Comparable interface so edges can be put to the 
       minHeap or similar priority queue or sorted on weight.
    */

    public static class Edge implements Comparable {
		public int     weight;     /* weight of edge               */
		public int     vertex1;    /* nodes attached to            */
		public int     vertex2;
		public int     marker;     /* marker for use in algorithms */

		public Edge (int vertex1, int vertex2, int weight) {
		    this.vertex1  = vertex1;
		    this.vertex2  = vertex2;
		    this.weight   = weight;
		}

		/* for printing and debugging; lower number vertex first */
		public String toString() {
		    if (vertex1 < vertex2)
				return "{" + vertex1 + "," + vertex2 + "} w = " + weight;
		    else
				return "{" + vertex2 + "," + vertex1 + "} w = " + weight;
		}
		
		/*
		  int otherEnd (int thisEnd)

		  returns the other end of the edge given the other,
		  useful for undirected graphs - note: no error checking,
		  so thisEnd _must_ be one of the ends of the edge.
		*/

		public int otherEnd (int thisEnd) {
		    return vertex1 == thisEnd ? vertex2 : vertex1;
		}
		

		/* Comparable interface: 

		   compareTo returns >  0 when this.weight > other.weight
	 	             returns == 0 when this.weight == other.weight
	 	             returns <  0 when this.weight < other.weight

		   this enables us to sort the edges in ascending order or use
		   a heap structure in some of the algorithms
		*/
		public int compareTo (Object other) {
		    /* this could also be written as:

		       if (weight < ((Edge)other).weight)
		          return -1;
	               else if (weight == ((Edge)other).weight))
		          return 0;
	               else 
		          return 1;
			  
	 	       to fulfill the Comparable interface, but the 
		       solution below is nicer.
		    */
		       
		    return weight - ((Edge)other).weight;
		}
    }

    /*
        class Vertex 
	
		Represents a vertex in the graph. Nothing much here, just a marker 
		for use in algorithms and room for expansion if/when needed
     */
    public static class Vertex {
		public int    marker;
		public Vertex ufParent; /* parent in UNION-FIND */
		public int    ufWeight; /* weight in UNION-FIND _when root of tree_ */

		public Vertex () {
		    marker = 0;
		}
    }

    /*
       fromTo is the adjacency matrix
       if there is an edge from v to w then fromTo[v][w] is non-null
       and contains the edge object.
    */
    private Edge[][] fromTo;

    /* vertex is the array of vertex classes representing the graph */
    private Vertex[] vertex; 




    /* some markers for algorithms */
    /* markers for vertices */
    private static final int VERTEX_CLEAR     = 0;
    private static final int VERTEX_NOT_FOUND = 1;
    private static final int VERTEX_FOUND     = 2;
    /* markers for edges */
    private static final int EDGE_CLEAR         = 0;
    private static final int EDGE_NOT_FOUND     = 1;
    private static final int EDGE_FOUND         = 2;
    private static final int DFS_DISCOVERY_EDGE = 3;
    private static final int DFS_BACK_EDGE      = 4;
    private static final int BFS_DISCOVERY_EDGE = 5;
    private static final int BFS_CROSS_EDGE     = 6;




    /* create a graph with vertexCount vertices and no edges */
    public Graph (int vertexCount) {
		this.vertex = new Vertex[vertexCount];
		for (int i = 0; i < vertexCount; ++i)
		    this.vertex[i] = new Vertex ();
		this.fromTo = new Edge[vertexCount][vertexCount];
    }

    /* adds an undirected edge (from, to) with weight weight */
    public void addUndirectedEdge (int from, int to, int weight) {
		fromTo[from][to] = new Edge(from, to, weight);
		/* note: the object is in two places in the matrix, when you mark
		   fromTo[u][v] then you also mark fromTo[v][u]                   */
		fromTo[to][from] = fromTo[from][to];
    }

    /* return true if there exists an edge (from, to) */
    public boolean hasEdgeFromTo (int from, int to) {
		return fromTo[from][to] != null;
    }

    /* prints the adjacency matrix "." if no edge, weight if edge */
    public void printMatrix () {
		for (int i = 0; i < vertex.length; ++i) {
			for (int j = 0; j < vertex.length; ++j){
				if (fromTo[i][j] != null)
				    System.out.print (fromTo[i][j].weight + " ");
				else
				    System.out.print (". ");
			}
			System.out.println();
		}
    }

    /* prints the edges after DFS: 
     * the edges are divided into discovery and back edges */
    public void printEdgesAfterDFS () {
		/* the upper triangular part of the matrix is enough 
		   since the graph is undirected                     */
		for (int i = 0; i < vertex.length; ++i)
		    for (int j = i+1; j < vertex.length; ++j)
				if (fromTo[i][j] != null) {
					System.out.print ("(" + i + ", " + j + ") ");
					switch (fromTo[i][j].marker) {
					    case DFS_DISCOVERY_EDGE:
							System.out.println ("DISCOVERY");
							break;
					    case DFS_BACK_EDGE:
							System.out.println ("BACK");
							break;
					    default:
							System.out.println ("NOT IN DFS TREE");
					    }
				}
    }

    public void printEdgesAfterBFS () {
		/* the upper triangular part of the matrix is enough 
		   since the graph is undirected                     */
		for (int i = 0; i < vertex.length; ++i)
		    for (int j = i+1; j < vertex.length; ++j)
				if (fromTo[i][j] != null) {
					System.out.print ("(" + i + ", " + j + ") ");
					switch (fromTo[i][j].marker) {
					    case BFS_DISCOVERY_EDGE:
							System.out.println ("DISCOVERY");
							break;
					    case BFS_CROSS_EDGE:
							System.out.println ("CROSS");
							break;
					    default:
							System.out.println ("NOT IN BFS TREE");
					    }
				}
    }


    /* set markers in all vertices to val */
    private void setVertexMarkers (int val) {
		for (int i = 0; i < vertex.length; ++i)
		    vertex[i].marker = val;
    }

    /* set markers in all edges to val */
    private void setEdgeMarkers (int val) {
		for (int i = 0; i < vertex.length; ++i)
		    for (int j = 0; j < vertex.length; ++j)
				if (fromTo[i][j] != null)
				    fromTo[i][j].marker = val;
    }

    /* perform depthFirstSearch starting at node n */
    public void depthFirstSearch (int n) {
		setEdgeMarkers   (EDGE_NOT_FOUND);    /* clear markers from edges    */
		setVertexMarkers (VERTEX_NOT_FOUND);  /* clear markers from vertices */
		depthFirstSearchRec (n);              /* start recursive routine     */
    }

    /* recursive part */
    private void depthFirstSearchRec (int v) {
		System.out.println (v);
		/* mark vertex found so we don't loop forever in case of a cycle */
		vertex[v].marker = VERTEX_FOUND;
		for (int w = 0; w < vertex.length; ++w) 
		    if (hasEdgeFromTo (v, w) && fromTo[v][w].marker == EDGE_NOT_FOUND) {
			    /* see if (v,w) leads to a new vertex */
			    if (vertex[w].marker != VERTEX_FOUND) {
				    /* yes => this is a discovery edge */
				    fromTo[v][w].marker = DFS_DISCOVERY_EDGE;
				    depthFirstSearchRec (w);
				}
			    else {
				    /* no => this is a back edge */
				    fromTo[v][w].marker = DFS_BACK_EDGE;
				}
			}
    }

    /* test if the graph is connected using a depth first search */
    public boolean isConnected () {
		boolean connected = true;
		/* perform search starting at vertex 0 */
		depthFirstSearch(0);
		/* see if we found all nodes in the search */
		for (int i = 0; connected && i < vertex.length; ++i)
		    if (vertex[i].marker != VERTEX_FOUND)
				/* nope => this graph is not connected */
				connected = false;
		return connected;
    }

    /* 
       public void breadthFirstSearch (int v)    
       
       Performs breadth-first search on the graph starting from node v
       using a Queue.
    */
    public void breadthFirstSearch (int v) {
		setVertexMarkers (VERTEX_NOT_FOUND);
		setEdgeMarkers   (EDGE_CLEAR);

		Queue q = new Queue ();
		q.enqueue (new Integer (v));

		vertex[v].marker = VERTEX_FOUND;

		while (! q.isEmpty ()) {
			v = ((Integer)(q.dequeue())).intValue();
			System.out.println (v);
			/* Go through all the undiscovered edges from v*/
			for (int i = 0; i < vertex.length; ++i)
			    if (hasEdgeFromTo (v, i) && fromTo[v][i].marker == EDGE_CLEAR) {
				    /* Have we found the other end already ? */
				    if (vertex[i].marker != VERTEX_FOUND) {
					    /* no => DISCOVERY edge */
					    fromTo[v][i].marker = BFS_DISCOVERY_EDGE;
					    vertex[i].marker = VERTEX_FOUND;
					    /* put the found vertex in the queue */
					    q.enqueue (new Integer (i));   
					}
				    else {
					    /* yes => CROSS edge */
					    fromTo[v][i].marker = BFS_CROSS_EDGE;
					}
				}
		}
    }
	
    /*
      makeCompleteGraph (int vertexCount)

      Create complete graph with vertexCount vertices and all possible
      undirected edges with weight 1.
     
      e.g. complete graphs for n = 2, 3, 4

       A-B  A---B  A-B
             \ /   |X|
	      	  C    C-D
    */

    public static Graph makeCompleteGraph (int vertexCount) {
		Graph result = new Graph (vertexCount);
		for (int i = 0; i < vertexCount; ++i)
		    for (int j = i+1; j < vertexCount; ++j)
				result.addUndirectedEdge (i, j, 1);
		return result;
    }

    private static Random r = new Random ();
    
    /*
      makeRandomGraph (int vertexCount, int edgeCount, int minWeight, int maxWeight);

      Create random graph with vertexCount vertices and edgeCount edges
      with minWeight <= edge weight <= maxWeight.
    */
					 
    public static Graph makeRandomGraph (int vertexCount, int edgeCount, int minWeight, int maxWeight) {
		/* make new graph with vertexCount vertices */
		Graph result = new Graph (vertexCount);
		/* insert edgeCount random edges into the graph */
		for (int i = 0; i < edgeCount; ++i) {
			int v, w;
			int edgeWeight = minWeight + r.nextInt(maxWeight - minWeight + 1);
			do {
			    v = r.nextInt(vertexCount);
			    w = r.nextInt(vertexCount);
			} while (v == w || result.hasEdgeFromTo(v, w));
			result.addUndirectedEdge (v, w, edgeWeight);
		}
		return result;
    }
}
