package hashTableTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import hashTable.ChainedHashTable;

/**
 * Starter file for Lab6 for CST8130-Fall2021
 * @author George Kriger
 */
public class PostalCodeSearchTest {

	/**
	 * main() which opens and read CSV file of Canadian postal codes
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {

		ChainedHashTable<String> cht = new ChainedHashTable<String>();
		String filename = "ottawa_postal_codes_prefix_only.csv";
		Path file = Paths.get(filename);
		try (BufferedReader input = Files.newBufferedReader(file)) {
			String line = null;
			while ((line = input.readLine()) != null) {
				cht.add(line);
			}//while
		}
		catch (IOException ioException) {
			System.err.println("Error opening file");
			ioException.printStackTrace();
		} 
		
//		cht.printHashtable();
		System.out.println("\nGenerating random prefixes... \n");
		
		for(int i=0; i<10; i++) {
			String rand = getRandomPrefix();
			System.out.printf("Retrieving: %s\n", cht.contains(rand) ? rand + " found" : rand + " NOT found");
		}
//		cht.remove("K2K");
//		cht.remove("0");
//		cht.printHashtable();
	}// main()

	final static SecureRandom rand = new SecureRandom();
	final static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final static String number = "0123456789";

	/**
	 * randomly generate a prefix using the correct format for Canadian postal codes
	 * 
	 * @return randomly generated prefix of the postal code
	 */
	public static String getRandomPrefix() {
		int randA = rand.nextInt(alpha.length());
		int randN = rand.nextInt(number.length());

		return "K" + number.charAt(randN) + alpha.charAt(randA);
	}// getRandomPrefix()

}// class
