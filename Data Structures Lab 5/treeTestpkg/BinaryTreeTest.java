package treeTestpkg;
import treePkg.BinaryTree;

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
public class BinaryTreeTest {

	/**
	 * main() method to test features of BinaryTree
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		int[] array = {26, 38, 34, 33, 70, 11, 25, 72, 14, 51, 13, 77, 
				6, 40, 95, 84, 50, 35, 31, 54, 88, 74, 46, 86, 57, 39, 
				85, 80, 19, 92};
		
		for(int number : array) {
			tree.insertInTree(number);
		}
		
		System.out.println("Tree display using in-order traversal:");
		tree.displayInOrder();
		
		System.out.println("\nTree display using pre-order traversal:");
		tree.displayPreOrder();
		
		System.out.println();
		
		System.out.printf("\nSearching for 26: %s", tree.search(26) ? "Found" : "NOT Found");
		System.out.printf("\nSearching for 11: %s", tree.search(11) ? "Found" : "NOT Found");
		System.out.printf("\nSearching for 38: %s", tree.search(38) ? "Found" : "NOT Found");
		System.out.printf("\nSearching for 100: %s", tree.search(100) ? "Found" : "NOT Found");
		
	}//main()

}// class
