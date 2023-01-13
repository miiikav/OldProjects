/*
  BinarySearchTree.java
  Simple Binary Search Tree with keys of type int and data of type Object
*/

class BinarySearchTree
{
    public BinarySearchTree ()
    {}

    public boolean isEmpty () {
		return root == null;
    }

    /*
       Insert new node with key to tree; doesn't have to handle
       duplicate keys (you can assume that the user will use different 
       keys)
    */
    public void insert (int key, Object data) {
		/* exercise */
    }

    /*
      Finds data of node with key, returns null if key is not found.
    */
    public Object find (int key) {
		/* exercise */
		return null;
    }

    /*
      Deletes node with key, returns false if deletion is unsuccessful 
      (e.g. node is not found)
    */
    public boolean delete (int key) {
		/* exercise */
		return false;
    }

    private BinaryTreeNode root;


    /* Consistency check of tree order */
    public boolean checkTreeOrder () {
		return checkTreeOrderRec (root, 
				  java.lang.Integer.MIN_VALUE,
				  java.lang.Integer.MAX_VALUE);
    }
    
    private boolean checkTreeOrderRec (BinaryTreeNode n, int low, int high) {
		boolean result = true;
		if (n != null) {
			if ((n.key <= low) || (n.key >= high)) {
				System.out.println ("ERROR in tree order: should be " + low + " < " + n.key + " < " + high + ".");
				result = false;
			}
			else {
				result = checkTreeOrderRec (n.left,    low, n.key)
				    && checkTreeOrderRec (n.right, n.key, high);
			}
		}
		return result;
    }
}
