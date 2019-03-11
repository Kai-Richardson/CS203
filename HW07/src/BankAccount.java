/**
 * BankAccount class stores information about a person's
 * bank account and implements actions of withdrawing
 * and depositing money.
 * VERSION 2:
 * - instance variables are private
 * - add get and set methods
 * - add equals method
 * - add toString method
 *
 * @author Tammy VanDeGrift, updated by Rajaa Alqudah
 * @version 2
 */
public class BankAccount {

	// instance variables
	private String name; // person's name associated with account
	private int number; // account number
	private double balance; // total dollars in account


	/**
	 * updateName
	 * changes name associated with account
	 *
	 * @param newName new name associated with account
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * getName
	 * returns the name associated with the bank account
	 *
	 * @return name associated with account
	 */
	public String getName() {
		return name;
	}

	/**
	 * getNumber
	 * returns the account number
	 *
	 * @return number associated with account
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * getBalance
	 * returns the balance associated with account
	 *
	 * @return balance of account
	 */
	public double getBalance() {
		return balance;
	}


	/**
	 * equals
	 * determines if the BankAccount objects are equal
	 *
	 * @param account BankAccount object that is part of
	 *                the comparison
	 * @return true if the two BankAccounts are equal and
	 * false, otherwise
	 */
// example of writing an equals method - it is a good
// idea to write an equals method for each class you
// create

// this.name refers to the instance variable name for
// the current object to which this method is applied
	public boolean equals(BankAccount account) {
		return ((this.name.equals(account.name)) &&
				(this.number == account.number) &&
				(this.balance == account.balance));
	}

	public String toString() {
		return "BankAccount [ Name = " + name + ", Number = " +
				number + ", Balance = " + balance + " ]";
	}

////////////////////////////////////////////////////////////
// The following methods are from the first
// version of the BankAccount class
////////////////////////////////////////////////////////////


	/**
	 * initialize
	 * initializes the BankAccount name and number
	 * and sets balance to 0.0
	 *
	 * @param holdersName   person's name associated with account
	 * @param accountNumber account number
	 */

	// we will see a new way to initialize BankAccount objects
	// in a few lectures
	public void initialize(String holdersName, int accountNumber) {
		// assign instance variables
		name = holdersName;
		number = accountNumber;
		balance = 0.0; // initialize balance to 0 dollars
	}

	/**
	 * deposit
	 * puts in money to account balance
	 *
	 * @param amount deposit amount
	 * @return true if deposit was successful and
	 * false if the deposit could not take place
	 */
	public boolean deposit(double amount) {
		if (amount < 0) {
			return false;
		} else {
			balance = balance + amount;
			return true;
		}
	}

	/**
	 * withdraw
	 * removes money from account if balance is available
	 *
	 * @param amount withdrawal amount
	 * @return true if withdrawal completed successfully
	 * and false if withdrawal could not take place
	 */
	public boolean withdraw(double amount) {
		if (amount < 0) {
			return false;
		} else if (amount <= balance) {
			balance = balance - amount;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * transferFrom
	 * transfers amount from another BankAccount object
	 *
	 * @param account the account from which money is transferred
	 * @param amount  the amount of money to transfer
	 * @return true if transfer was successful and false if not
	 */
	public boolean transferFrom(BankAccount account, double amount) {
		boolean withdrawalOK;
		withdrawalOK = account.withdraw(amount);
		if (!withdrawalOK) {
			return false;
		}
		boolean depositOK = this.deposit(amount);
		if (!depositOK) {
			return false;
		}
		return true;
	}


	/**
	 * printAccountInfo
	 * prints information associated with account object
	 */
	public void printAccountInfo() {
		System.out.print("BANK ACCOUNT INFO [");
		System.out.print("Name: " + name);
		System.out.print(", Number: " + number);
		System.out.println(", Balance: " + balance + " ]");
		System.out.println();
	}
}