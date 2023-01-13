class GraphTest {
    public static void main (String[] args) {
		/* Let's make this graph with edges weights 1 */
		/* 
	              0--1  4
		          | /|
	              |/ |
		          2  3    */

		Graph g = new Graph(5);
		g.addUndirectedEdge (0,1,1); /* 0-1 */
		g.addUndirectedEdge (0,2,1); /* 0-2 */
		g.addUndirectedEdge (1,2,1); /* 1-2 */
		g.addUndirectedEdge (1,3,1); /* 1-3 */
		System.out.println ("Adjacency matrix of graph: ");
		g.printMatrix ();
		System.out.println ();
		System.out.println ("Depth first search from 0: (notice that 4 is not found)");
		g.depthFirstSearch (0);
		System.out.println ("Edges after DFS => ");
		g.printEdgesAfterDFS ();
		System.out.println ("Depth first search from 1: (notice again that 4 is not found)");
		g.depthFirstSearch (1);
		System.out.println ("Edges after DFS => ");
		g.printEdgesAfterDFS ();
		


		/* Let's make a random graph with 5 vertices, 4 edges with
		   weights between 1 and 3 */
		Graph h = Graph.makeRandomGraph (5, 4, 1, 3);
		System.out.println ("Adjacency matrix of random graph: ");
		h.printMatrix ();
		System.out.println ();
		System.out.println ("Depth first search from 0: ");
		h.depthFirstSearch (0);
		System.out.println ("Edges after DFS => ");
		h.printEdgesAfterDFS ();

		/* Let's make this graph with edges weights 1 */
		/* 
	              0--1--5
	              |\ |
	              | \|
	              2--3
	              |   \
	              |    \
	              4     6
	        */
		Graph q = new Graph(7);
		q.addUndirectedEdge (0,1,1); /* 0-1 */
		q.addUndirectedEdge (0,2,1); /* 0-2 */
		q.addUndirectedEdge (0,3,1); /* 0-3 */
		q.addUndirectedEdge (1,3,1); /* 1-3 */
		q.addUndirectedEdge (1,5,1); /* 1-5 */
		q.addUndirectedEdge (2,3,1); /* 2-3 */
		q.addUndirectedEdge (2,4,1); /* 2-4 */
		q.addUndirectedEdge (3,6,1); /* 3-6 */
		System.out.println ();
		System.out.println ("Breadth first search from 0: ");
		q.breadthFirstSearch (0);
		System.out.println ("Edges after BFS => ");
		q.printEdgesAfterBFS ();
    }
}
