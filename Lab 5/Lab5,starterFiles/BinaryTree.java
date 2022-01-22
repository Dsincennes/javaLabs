
/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 *  
 * @author Algonquin College
 * @author George Kriger
 *
 */

public class BinaryTree {
	BinaryTreeNode root = null;

	/**
	 * create new node with these contents and insert in the proper location
	 * using BST logic
	 * @param newData
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

}// class
