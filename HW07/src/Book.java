public class Book {

	private int id;
	private String title;
	private String author;
	private String publisher;
	private int yearPub;

	private int price;

	private int numCopies;
	private int numSold;

	public Book(int id, String title, String author, String publisher,
	            int yearPub, int price, int numCopies, int numSold) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.yearPub = yearPub;
		this.price = price;
		this.numCopies = numCopies;
		this.numSold = numSold;

	}

	public int getID() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getYearPub() {
		return yearPub;
	}

	public int getPrice() {
		return price;
	}

	public int getNumCopies() {
		return numCopies;
	}

	public int getNumSold() {
		return numSold;
	}

	public void sale(Customer customer, int copies) {
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

	public void restock(int increase) {
		if (increase < 1) {
			System.out.println("Error: Attempted to increase by < 1.");
			return;
		}
		numCopies += increase;
		if (numCopies < 1) {
			System.out.println("Error: Less than one book of " + title);
		}
	}

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
