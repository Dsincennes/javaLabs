
import java.security.SecureRandom;
import java.util.Random;

/**
 * Starter file for Assigment3 for CST8130-Fall2021
 * 
 * @author George Kriger
 *
 */
public class PostalCodeEntry {
	private String prefix;
	private String place_name;
	private String province;
	private String latitude;
	private String longitude;

	/**
	 * class that corresponds one entry/row in CSV file of Canadian postal codes
	 * 
	 * @param prefix     the first portion of the postal code
	 * @param place_name name of the place corresponding to the postal code
	 * @param province   province where the place is located
	 * @param latitude   latitude of the centre of the postal code
	 * @param longitude  longitude of the centre of the postal code
	 */
	public PostalCodeEntry(String prefix, String place_name, String province, String latitude, String longitude) {
		this.prefix = prefix;
		this.place_name = place_name;
		this.province = province;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * no-argument constructor set all instance variables to null
	 */
	public PostalCodeEntry() {
	}

	/**
	 * constructor that uses an array to initialize the class
	 * 
	 * @param fields array of String corresponding to: <br>
	 *               prefix <br>
	 *               place_name <br>
	 *               province <br>
	 *               latitude <br>
	 *               longitude
	 */
	public PostalCodeEntry(String[] fields) {
		this(fields[0], fields[1], fields[2], fields[3], fields[4]);
	}

	/**
	 * prefix is first 3 characters of the postal code <br>
	 * Correct format is: ALPHAnumberALPHA <br>
	 * where ALPHA is an upper-case chosen from A through Z
	 * 
	 * @return the first portion of the postal code
	 */
	public String getPrefix() {
		return prefix;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s\n", prefix, place_name, province, latitude, longitude);
	}

	// create random generator once. To be used for the life of main(). Global
	// visibility
	// provide a seed value to get same random sequence
	// remove seed after testing
//	final static SecureRandom rand = new SecureRandom("abcdefghijklmnop".getBytes());
	
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
	}// getRandom()

}// class
