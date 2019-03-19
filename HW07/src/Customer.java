/**
 * An instance of this class contains all the information about a single customer
 *
 * @author - Kai Richardson
 * @version 2019-03-18
 */
class Customer {

	//Declaring our variables to hold data
	private final String name;
	private final int acc_id;
	private String address;
	private int card_num;
	private String password; //Plaintext password storage? How terrible.

	private Book[] boughtBooks;
	private int boughtBooksNum = 0;

	/**
	 * Constructor for our Customer
	 *
	 * @param nm  name
	 * @param id  ID
	 * @param add address
	 */
	Customer(String nm, int id, String add) {
		this.name = nm;
		this.acc_id = id;
		this.address = add;
	}

	/**
	 * Returns the name of the Customer
	 *
	 * @return name
	 */
	String getName() {
		return name;
	}

	/**
	 * Returns the account ID of the Customer
	 *
	 * @return account ID
	 */
	int getAcc_id() {
		return acc_id;
	}

	/**
	 * Returns the address of the customer
	 *
	 * @return address
	 */
	String getAddress() {
		return address;
	}

	/**
	 * Sets the address of the Customer to a given String
	 *
	 * @param address address to set to
	 */
	void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the card number in Integer format of the Customer
	 *
	 * @return card number
	 */
	int getCard_num() {
		return card_num;
	}

	/**
	 * Sets the card number of the Customer, in Integer format
	 *
	 * @param card_num number to set to
	 */
	void setCard_num(int card_num) {
		this.card_num = card_num;
	}

	/**
	 * Returns the password of the user... in plaintext
	 *
	 * @return a plaintext password
	 */
	String getPassword() {
		return password;
	}

	/**
	 * Sets the Customer's password to a given plaintext String
	 *
	 * @param password a plaintext password to set to
	 */
	void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the books that our customer has bought
	 *
	 * @return the bought books
	 */
	String getBoughtBooks() {
		if (this.boughtBooksNum < 1) return "None";
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= boughtBooksNum; i++) {
			sb.append(boughtBooks[i - 1].toString());
		}
		return sb.toString();
	}

	/**
	 * Returns a description of our Customer
	 *
	 * @return a description
	 */
	public String toString() {
		return "Customer [" +
				"Name = " + name + ", " +
				"Address = " + address + ", " +
				"Account ID = " + acc_id + ", " +
				"Number of Books Purchased = " + boughtBooksNum + ", " +
				"Books Purchased = " + (((boughtBooksNum > 0) && (boughtBooks.length > 0)) ? boughtBooks : "None")
				+ " ]";
	}

	/**
	 * Adds a fine Book addition to the Customer's collection
	 *
	 * @param bk  the fine addition
	 * @param num how many additions
	 */
	void addBook(Book bk, int num) {
		if (boughtBooksNum == 0) this.boughtBooks = new Book[500];

		for (int i = 0; i < num; i++) {
			this.boughtBooks[this.boughtBooksNum] = bk;
			this.boughtBooksNum++;
		}
	}

}

