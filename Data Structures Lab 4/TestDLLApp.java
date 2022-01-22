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
class TestDLLApp {
	/**
	 * Method main, Drives program.
	 * @param args string array args
	 */
	public static void main(String[] args) {

		DoublyLinked NewLL = new DoublyLinked();

		NewLL.insertFirst(20);
		NewLL.insertFirst(42);
		NewLL.insertFirst(63);
		NewLL.insertFirst(93);

		NewLL.insertLast(9);
		NewLL.insertLast(34);
		NewLL.insertLast(51);

		NewLL.printForwards();
		NewLL.printBackwards();

		NewLL.deleteFirstNode();
		NewLL.deleteLastNode();
		NewLL.searchAndDelete(9);

		NewLL.printForwards();

		NewLL.insertAfter(20, 69);
		NewLL.insertAfter(34,77);

		NewLL.printForwards();

	} // end of main() method
} // end class TestDLLApp
