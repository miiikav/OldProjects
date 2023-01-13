class BinarySearchTree {

    public boolean isEmpty () {
		return root == null;
    }

    public void insert (int key, Object data) {
		if (isEmpty ()) {
			root = new BinaryTreeNode (key, data);
	    }
		else {
			BinaryTreeNode curr, prev;
			prev = curr = root; 
			// searching until curr is null 
			while (curr != null) {
				prev = curr;
				if (key < curr.key)
				    curr = curr.left;
				else
				    curr = curr.right;
		    }
			BinaryTreeNode n = new BinaryTreeNode (key, data);
			if (key < prev.key)
			    prev.left = n;
			else
			    prev.right = n;
	    }
    }

    public Object find (int key) {
		BinaryTreeNode curr = root;
		// searching until curr is null or the given key is found
		while (curr != null && curr.key != key) {
			if (key < curr.key)
			    curr = curr.left;
			else
			    curr = curr.right;
	    }
	    // returning null if curr==null or curr.data if curr!=null
		return curr == null ? null : curr.data; 
    }

    public boolean delete (int key) {
		boolean found = false;
		BinaryTreeNode  curr = root;
		BinaryTreeNode  parent = null;

		// moving through the tree starting from the root:
		// looping until the target node (curr) has the key that we are 
	    // looking for or curr is null, parent points to the parent of curr
		while (curr != null && curr.key != key) { 
			parent = curr;
			if (key < curr.key)
			    curr = curr.left;
			else 
			    curr = curr.right;
	    }   

		if (curr != null) { 
		    found = true;

		    // curr has no children, we can just delete curr node
		    if (curr.left == null && curr.right == null) {
				if (curr == root)
				    root = null;
				else if (parent.left == curr)
				    parent.left = null;
				else
				    parent.right = null;
		    }

		    // curr has only right child, we replace curr with the existing child
		    else if (curr.left == null) {
				if (curr == root)
				    root = curr.right;
				else if (parent.left == curr)
				    parent.left = curr.right;
				else
				    parent.right = curr.right;				
		    }

		    // cur has only left child, we replace curr with the existing child
		    else if (curr.right == null) {
				if (curr == root)
				    root = curr.left;
				else if (parent.left == curr)
				    parent.left = curr.left;
				else
				    parent.right = curr.left;
		    }

		    // curr has two children, things get more complicated 
		    // 6. Sanakirjat / p.332 
		    else  {
			    BinaryTreeNode min = curr.right; // taking the right subtree of curr
			    BinaryTreeNode minParent = curr;

			    // moving through the curr's right subtree in order to find the leftmost node
			    while (min.left != null) {
					minParent = min;
					min = min.left;
			    } 
			    // after this loop min is the leftmost node of the right subtree of curr, 
			    // and we also know its parent (minParent)

			    // starting to move min to replace the deleted node (curr): 
			    // linking the left child of deleted node to min
				min.left = curr.left; 

				// if min was the right child of the deleted node (curr) we are almost ready;
				// otherwise we need to do some extra linking tasks
			    if (min != curr.right) {
			    	// re-linking the only child of min: it replaces the min node
					minParent.left = min.right; 
					// linking the right child of deleted node to min 
					min.right = curr.right;      
			    }

			    // checking if deleted was the root
			    if (curr == root) 
					root = min;
				// if not root then linking min to the parent of deleted (curr)
			    else if (parent.left == curr) 
					parent.left = min;
			    else
			    	parent.right = min;
		    }
	    } 

	    // returning false if there was no entry for given key in the tree
		return found;
    }

    private BinaryTreeNode root;
    

    /****************************************************************************************************/


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
