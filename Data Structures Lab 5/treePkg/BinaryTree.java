package treePkg;

/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 *  
 * @author Algonquin College
 * @author George Kriger
 * @author Donald Sincennes
 *
 */
public class BinaryTree {
	BinaryTreeNode root = null;

	/**
	 * create new node with these contents and insert in the proper location
	 * using BST logic
	 * @param newData data to be inserted into the tree
	 */
	public void insertInTree(int newData) {
		if (root == null)
			root = new BinaryTreeNode(newData);
		else
			root.insert(newData);
	}

	/**
	 * Display tree contents using inorder traversal
	 */
	public void displayInOrder() {
		displayInOrder(root);
	}

	/**
	 * Start at subtree and display tree contents using inorder traversal
	 * @param subRoot starting location in tree
	 */
	private void displayInOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		displayInOrder(subRoot.getLeft());
		System.out.print(" " + subRoot.getData() + " ");
		displayInOrder(subRoot.getRight());
	}
	
	/**
	 * Display tree contents using preorder traversal
	 */
	public void displayPreOrder() {
		displayPreOrder(root);
	}

	/**
	 * Start at root and display tree contents using preorder traversal
	 * @param subRoot starting location in tree
	 */
	private void displayPreOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		System.out.print(" " + subRoot.getData() + " ");
		displayPreOrder(subRoot.getLeft());
		displayPreOrder(subRoot.getRight());
	}
	
	
	/**
	 * This method searches for a key in a tree, searches left subtree if key is less
	 * than the root, or right if it is greater until it reaches null.
	 * 
	 * @param key passed to search the Binary Tree.
	 * @return returns true if key is found, false if it is not found.
	 */
	public boolean search(int key) {
		if(root == null) {
			return false;
		}
		BinaryTreeNode tempRoot = root;
		while(tempRoot != null) {
			if (key < tempRoot.getData())
				tempRoot = tempRoot.getLeft();
			else if (key > tempRoot.getData())
				tempRoot = tempRoot.getRight();
			else 
				return true;
		}
		return false;
	}

}// class
