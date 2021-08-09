/*
 * Assessment: Lab 4
 * Student Name: Donald Sincennes
 * Due Date: 07/1/21
 * Description: A banking system, that holds accounts and processes fees or interest.
 * Professor Name: Dr. James Mwandi
 */

/**
 * Class that has fees for a checkings account.
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */

public class Checking extends Account {

	protected double fees;

	/**
	 * sets fee for Checking account
	 */
	public Checking() {	// constructor that sets 13.50$ fee for checking accounts.
		this.fees = 13.50;
	}

	/**
	 *  Updates checking balance by processing fee's.
	 */
	@Override
	public void updateBalance() {
		balance -= fees;
	}
}
