/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * 
 *          Student Name: Donald Sincennes
 * 			Student ID: 041011305
 * 
 */
class Node {

	/**
	 * data item
	 */
	public int mData;
	/**
	 * next node in list
	 */
	public Node next;
	/**
	 * previous node in list
	 */
	public Node previous;

	/**
	 * Default constructor, instantiates data to d
	 * @param d node
	 */
	public Node(int d) // constructor
	{
		mData = d;
	}

	/**
	 * displays node data
	 */
	public void displayNode() {
		System.out.print(mData + " ");
	}
} // end class Node

/**
 * Class contains Doubly Linked List methods
 */
class DoublyLinked {
	/**
	 * First node in list
	 */
	private Node first;
	/**
	 * Last node in list
	 */
	private Node last;

	/**
	 * constructor initializing first and last nodes to null
	 */
	public DoublyLinked  () {
		first = null;
		last = null;
	}

	/**
	 * Method is checking if Linked List is empty
	 * @return returns true or false if list is empty
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 *  Method inserts value at the front of list.
	 * @param num value to be inserted
	 */
	public void insertFirst(int num) {
		Node newNode = new Node(num);

		if (isEmpty())
			last = newNode;
		else
			first.previous = newNode;
		newNode.next = first;
		first = newNode;
	}

	/**
	 * Method inserts value at end of the list
	 * @param num Value to be inserted at end of list
	 */
	public void insertLast(int num) {
		Node newNode = new Node(num);
		if (isEmpty())
			first = newNode;
		else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
	}

	/**
	 * Method inserts value after specific value specified
	 * @param numToFind value that you want to include a number after
	 * @param newNumber value to be inserted
	 * @return returns true if complete
	 */
	public boolean insertAfter(int numToFind, int newNumber) { // (assumes non-empty list)
		Node current = first;
		while (current.mData != numToFind) {
			current = current.next;
			if (current == null)
				return false;
		}
		Node newNode = new Node(newNumber);

		if (current == last) {
			newNode.next = null;
			last = newNode;
		} else {
			newNode.next = current.next;

			current.next.previous = newNode;
		}
		newNode.previous = current;
		current.next = newNode;
		return true;
	}

	/**
	 * Deleted first node in a linked list
	 * @return returns First node
	 */
	public Node deleteFirstNode() {
		if(isEmpty()){
			return null;
		}
		if(first.next == null){
			last = null;
		}
		else{
			first.next.previous = null;
		}
		first = first.next;

		return first;
	}

	/**
	 * Method Deletes last node in a linked list
	 * @return returns last node
	 */
	public Node deleteLastNode() {
		if(isEmpty()){
			return null;
		}
		if(last.previous == null){
			first = null;
		}
		else{
			last.previous.next = null;
		}
		last = last.previous;
		return last;
	}

	/**
	 * finds, deletes and returns the node that contains the given int value
	 * @param number Value to be searched within the Linked list
	 * @return returns found node if it is found.
	 */
	public Node searchAndDelete(int number) {
		if(first == null){
			return null;
		}
		Node currentNode = first;
		while(currentNode != null && currentNode.mData != number){
			currentNode = currentNode.next;
		}
		if(currentNode == null){ // If no number is found
			return null;
		}
		if(currentNode == first){ // Update current head node
			first = currentNode.next;
			if(first != null) {
				first.previous = null;
			}
		}
		else if(currentNode == last){ // Update current tail node
			last = last.previous;
			last.next = null;
		}else { // if node is found in middle of linked list
			Node previousNode = currentNode.previous;
			previousNode.next = currentNode.next;
			currentNode.next.previous = currentNode.previous;
		}
		return currentNode;
	}

	/**
	 * display data from first node to last node
	 */
	public void printForwards() {
		if(first == null){
			return;
		}
		System.out.print("Linked List: [From first_to_last]: ");
		System.out.print(first.mData);
		Node current = first.next;
		while(current != null){
			System.out.printf(", %d", current.mData);
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * display data from last node  to first node
	 */
	public void printBackwards() {
		if(first == null){
			return;
		}
		System.out.print("Linked List: [From last_to_first]: ");
		System.out.print(last.mData);
		Node current = last.previous;
		while(current != null){
			System.out.printf(", %d", current.mData);
			current = current.previous;
		}
		System.out.println();
	}
} // end class DoublyLinkedList

