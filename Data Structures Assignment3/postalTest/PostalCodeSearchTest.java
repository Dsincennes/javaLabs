package postalTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import postalCode.PostalCodeEntry;

/**
 * Starter file for Assigment3 for CST8130-Fall2021
 * 
 * @author George Kriger
 */

public class PostalCodeSearchTest {

	/**
	 * main() which opens and read CSV file of Canadian postal codes
	 * 
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {

		String filename = "ottawa_postal_codes.csv";
		int randomSize = 10;
		Path file = Paths.get(filename);
		try (BufferedReader input = Files.newBufferedReader(file)) {
			String line = null;
			HashMap<String, PostalCodeEntry> postal = new HashMap<>();
			while ((line = input.readLine()) != null) {
				String[] postalCodeInfo = line.split(",");
				PostalCodeEntry pce = new PostalCodeEntry(postalCodeInfo[0], postalCodeInfo[1],
						postalCodeInfo[2], postalCodeInfo[3], postalCodeInfo[4]);
				postal.put(postalCodeInfo[0], pce);
			}
			for (int i = 0; i < randomSize; i++) { // Loop 10 times for 10 random postal codes
				String randomPostal = PostalCodeEntry.getRandomPrefix(); // Generate prefixes
				System.out.printf("Retrieving: %s\n\t %s", randomPostal, // print the postal code info if found
						(postal.get(randomPostal) != null) ? postal.get(randomPostal) : "NOT Found");
				System.out.println();
			}
		} catch (IOException ioException) {
			System.err.println("Error opening file");
			ioException.printStackTrace();
		}
	}// main()

}// class
