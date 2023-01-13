
class AdjacencyMatrixGraph {
    private static class Vertex {
		public int    marker;
		public int    index;  /* index in matrix */
		public Object key;    /* name for vertex */
		public Object data;  /* possible extra information */

		public int degree ();

		public Vertex (Object key, Object data) {/* N/A */}
    }
    
    private static class Edge {
		public int    marker;
		public int    weight;

		public Vertex from;
		public Vertex to;

		public Object key;    /* name for edge */
		public Object data;  /* extra information */
		
		public Edge  (Object key, Object data, Vertex from, Vertex to) {/* N/A */}
    }

    Vertex[] vertex; /* set of vertices */
    Edge[][] fromTo; /* adjacency matrix */

    /* some example operations */
    public AdjacencyMatrixGraph () {}

    public int     numVertices   () {}
    public int     numEdges      () {}
    public void    insertVertex  (Object key, Object data) {}
    public void    insertEdge    (Object fromVertexKey, Object toVertexKey, Object key, Object data) {}
    public void    removeEdge    (Object key) {}
    public void    removeVertex  (Object key) {}
    public boolean isConnected   () {}
    public boolean reachableFrom (Object vertexKey1, Object vertexKey2);
}






class EdgeListGraph {
    private static class Vertex {
		public int    marker;
		public Object key;    /* name for vertex */
		public Object data;  /* possible extra information */

		public Vertex (Object key, Object data) {/* N/A */}
    }

    private static class VertexListNode {
		Vertex         vertex;
		VertexListNode next;
		public VertexListNode (Vertex v) { /* N/A */}
    }

    private static class Edge {
		public int    marker;
		public int    weight;

		public Vertex from;
		public Vertex to;
		
		public Object key;    /* name for edge */
		public Object data;  /* extra information */

		public Edge  (Object key, Object data) {/* N/A */}
    }

    class EdgeListNode {
		Edge         edge;
		EdgeListNode next;
		public EdgeListNode (Edge e) { /* N/A */}
    }

    VertexListNode V;
    EdgeListNode   E;

    /* same operations as above */
    public EdgeListGraph () { /* N/A */ }
}




/* version 1 */
/* everything in singly-linked lists */

class AdjacencyListGraph {
    private static class Vertex {
		public int    marker;
		public Object key;    /* name for vertex */
		public Object data;  /* possible extra information */

		public EdgeListNode  inEdges;
		public EdgeListNode outEdges;

		public Vertex (Object key, Object data) {/* N/A */}
    }

    private static class VertexListNode {
		Vertex         vertex;
		VertexListNode next;
		public VertexListNode (Vertex v) { /* N/A */}
    }

    private static class Edge {
		public int    marker;
		public int    weight;

		public Vertex from;
		public Vertex to;
		
		public Object key;    /* name for edge */
		public Object data;  /* extra information */

		public Edge  (Object key, Object data) {/* N/A */}
    }

    class EdgeListNode {
		Edge         edge;
		EdgeListNode next;
		public EdgeListNode (Edge e) { /* N/A */}
    }

    VertexListNode V;
    EdgeListNode   E;

    /* same operations as above */   
    public EdgeListGraph () { /* N/A */ }
}




/* 2nd version 

  Vertex list: Sentinel is a Vertex, but not really a Vertex in the graph
  (it is skipped in searches etc).

    (*)                              (*) 
  Sentinel -> Vertex ->  Vertex -> Sentinel   (*) same vertex (makes a ring)
           <-        <-         <-

  Edge is a node in 3 lists:

  inEdges  in the to   Vertex
  outEdges in the from Vertex
  main edge list in the graph

  all three lists are double-linked and have separate sentinels.
  (i.e. each node has 2 dummy Edge-objects one in inEdges, one in outEdges)
  Deletion of an edge after it is found is just:

  inPrev.inNext   = inNext;  -- detach from in list 
  inNext.inPrev   = inPrev;
  outPrev.outNext = outNext; -- detach from out list 
  outNext.outPrev = outPrev;
  elPrev.elNext   = elNext;  -- detach from main list
  elNext.elPrev   = elPrev;

  Deletion of a vertex similarly, but also deleting the edges.

*/

class AdjacencyListGraph {
    private static class Vertex {
		public int    marker;
		public int    distance; /* for Dijkstra's algorithm */

		public Object key;      /* name for vertex */
		public Object data;    /* possible extra information */

	 	public Vertex next;     /* references in the main vertex list */
		public Vertex prev;

		public Edge   inEdges;  /* double-linked list with sentinel */	
		public Edge   outEdges; /* double-linked list with sentinel */	

		public Vertex (Object key, Object data) {/* N/A */}
    }

    private static class Edge {
		public int    marker;
		public int    weight;

		public Vertex from;
		public Vertex to;
		

		public Edge   elNext;   /* references in the graph's edge list   */
		public Edge   elPrev;   /* makes deletion of node much faster    */
		public Edge   inNext;   /* next and prev in to's inEdges list    */
		public Edge   inPrev;   
		public Edge   outNext;  /* next and prev in from's outEdges list */
		public Edge   outPrev;
		
		public Object key;    /* name for edge */
		public Object data;  /* extra information */

		public Edge  (Object key, Object data) {/* N/A */}
    }


    class EdgeListNode{ 
		Edge         edge;
		EdgeListNode next;
		public EdgeListNode (Edge e) { /* N/A */}
    }

    Vertex         vertex; /* double-linked list with sentinel */
    Edge           edges;  /* double-linked list with sentinel */
   
    public AdjacencyListGraph () { /* N/A */ }
}
