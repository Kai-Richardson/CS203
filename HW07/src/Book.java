/**
 * An instance of this class contains all the information about a single book
 *
 * @author - Kai Richardson
 * @version 1
 */
class Book {

	//Declare variables used to store data about our book
	private final int id;
	private final String title;
	private final String author;
	private final String publisher;
	private final int yearPub;

	private final int price;

	private int numCopies;
	private int numSold;

	/**
	 * Book Constructor, sets the specific instance's values to the passed ones.
	 */
	Book(int id, String title, String author, String publisher,
	     int yearPub, int price, int numCopies) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.yearPub = yearPub;
		this.price = price;
		this.numCopies = numCopies;
		this.numSold = 0;

	}

	/**
	 * Returns the ID of the book
	 *
	 * @return id
	 */
	int getID() {
		return id;
	}

	/**
	 * Returns the title of the book
	 *
	 * @return title
	 */
	String getTitle() {
		return title;
	}

	/**
	 * Returns the author of the book
	 *
	 * @return author
	 */
	String getAuthor() {
		return author;
	}

	/**
	 * Returns the publisher of the book
	 *
	 * @return publisher
	 */
	String getPublisher() {
		return publisher;
	}

	/**
	 * Returns the year published of the book
	 *
	 * @return year published
	 */
	int getYearPub() {
		return yearPub;
	}

	/**
	 * Returns the price of the book
	 *
	 * @return price
	 */
	int getPrice() {
		return price;
	}

	/**
	 * Returns the number of copies in stock of the book
	 *
	 * @return number in stock
	 */
	int getNumCopies() {
		return this.numCopies;
	}

	/**
	 * Returns the number of copies of the book we've sold
	 *
	 * @return number sold
	 */
	int getNumSold() {
		return numSold;
	}

	/**
	 * Method to handle the sale of a book given a customer and number to sell
	 *
	 * @param customer our customer to sell to
	 * @param copies   how many copies we're selling them
	 */
	void sale(Customer customer, int copies) {
		if (copies > numCopies) {
			System.out.println("Error: Attempted to sell more copies than available.");
			return;
		}
		if (copies < 0) {
			System.out.println("Error: Attempted to purchase a negative number of books.");
			return;
		}
		//If Successful...
		numCopies -= copies;
		numSold += copies;
		customer.addBook(this, copies);
	}

	/**
	 * Method to restock books and increase the number we have in stock
	 *
	 * @param increase how many books to add
	 */
	void restock(int increase) {
		if (increase < 1) {
			System.out.println("Error: Attempted to increase by < 1.");
			return;
		}
		numCopies += increase;
		if (numCopies < 1) {
			System.out.println("Error: Less than one book of " + title);
		}
	}

	/**
	 * Method to print the data of the Book in a string format
	 *
	 * @return a description of our Book
	 */
	public String toString() {
		return "Book [" +
				" ID = " + id + "," +
				" Title = " + title + "," +
				" Author = " + author + "," +
				" Publisher = " + publisher + "," +
				" Year Published = " + yearPub + "," +
				" Price = " + price + "," +
				" Copies = " + numCopies + "," +
				" Sold = " + numSold
				+ " ]";
	}
}
