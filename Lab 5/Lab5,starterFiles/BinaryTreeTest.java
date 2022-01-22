/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * @author Algonquin College
 * @author George Kriger
 *
 */
public class BinaryTreeTest {

	/**
	 * main() method to test features of BinaryTree
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		tree.insertInTree(6);
		tree.insertInTree(3);
		tree.insertInTree(9);
		tree.insertInTree(1);
		tree.insertInTree(15);
		tree.insertInTree(7);
		
		tree.displayInOrder();
	}//main()

}// class
