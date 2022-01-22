package hashTable;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * 
 * This Class holds a generic hash table and associated methods<br>
 * 
 * @author Donald Sincennes
 *
 * @param <E> Generic type
 */
public class ChainedHashTable<E> {

	private ArrayList<ArrayList<E>> hashtable;

	/**
	 * Default constructor instantiates an array list, and inside the arraylist
	 * creates another list to act as a hashtable
	 */
	public ChainedHashTable() {
		hashtable = new ArrayList<ArrayList<E>>();
		for (int i = 0; i < 25; i++) {
			hashtable.add(new ArrayList<E>());
		}
	}

	/**
	 * Method adds a key to an arrayList
	 * 
	 * @param e key to be added
	 */
	public void add(E e) {
		int hashedKey = hashKey(e);
		hashtable.get(hashedKey).add(e);
	}

	/**
	 * Method Searched list for a given key, returns true if key matches, false if
	 * not
	 * 
	 * @param key passed key to be searched
	 * @return returns true when passed key matches a key inside the list, false if
	 *         not
	 */
	public boolean contains(E key) {
		for (ArrayList<E> entryList : hashtable) {
			for (E entry : entryList) {
				if (entryList.isEmpty()) {
					return false;
				}
				if (entry.equals(key)) {
					return true;
				}
			}
		}
		return false;
	}

	private int hashKey(E key) {
		int h = key.hashCode();
		h = h % hashtable.size();
		if (h < 0) {
			h = -h;
		}
		return h;
	}

	/**
	 * This method prints a hash table
	 */
	public void printHashtable() {
		for (int i = 0; i < hashtable.size(); i++) {
			if (hashtable.get(i).isEmpty()) {
				System.out.println("Position " + i + ": empty");
			} else {
				System.out.print("Position " + i + ": ");
				ListIterator<E> iterator = hashtable.get(i).listIterator();
				while (iterator.hasNext()) {
					System.out.print(iterator.next());
					System.out.print(", ");

				}
				System.out.println();
			}
		}
	}

}
