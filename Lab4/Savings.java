/*
 * Assessment: Lab 4
 * Student Name: Donald Sincennes
 * Due Date: 07/1/21
 * Description: A banking system, that holds accounts and processes fees or interest.
 * Professor Name: Dr. James Mwandi
 */

/**
 * Class that has interest for a savings account.
 * @author Donald Sincennes
 * @version 1.0
 * @since 11.0
 */
public class Savings extends Account {

	protected double interestRate;

	// contrustor adds interest rate to instance variable
	public Savings() {
		this.interestRate = 0.0399;
	}

	/**
	 * updates balance of savings account by adding monthly interest
	 */
	@Override
	public void updateBalance() {
		balance += (interestRate / 12 * balance);
	}
}
