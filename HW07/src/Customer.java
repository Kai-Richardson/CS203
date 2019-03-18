/**
 * An instance of this class contains all the information about a single customer
 *
 * @author - Kai Richardson
 * @version 1
 */
public class Customer {
	private String name;
	private int acc_id;
	private String address;
	private int card_num;
	private String password; //Plaintext password storage? How terrible.

	private Book[] boughtBooks = new Book[500];
	private int boughtBooksNum = 0;


	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCard_num(int card_num) {
		this.card_num = card_num;
	}

	public String getName() {
		return name;
	}

	public int getAcc_id() {
		return acc_id;
	}

	public String getAddress() {
		return address;
	}

	public int getCard_num() {
		return card_num;
	}

	public String getPassword() {
		return password;
	}

	public String getBoughtBooks() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < boughtBooksNum; i++) {
			sb.append(boughtBooks[i].toString());
		}
		return sb.toString();
	}

	public String toString() {
		return "Customer [" +
				"Name = " + name + ", " +
				"Address = " + address + ", " +
				"Account ID = " + acc_id + ", "
				+ " ]";
	}

	public Customer(String nm, int id, String add) {
		this.name = nm;
		this.acc_id = id;
		this.address = add;
	}

	public void addBook(Book bk, int num) {
		for (int i = 0; i < num; i++) {
			this.boughtBooks[boughtBooksNum + 1] = bk;
			boughtBooksNum++;
		}
	}


}

