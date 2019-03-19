public class Main {

	public static void main(String[] args) {

		Book hike = new Book(42, "Hitchhiker's Guide to the Galaxy", "Douglas Adams",
				"Pan Books", 1979, 21, 10, 0);

		Book albert = new Book(4, "Albert & The Deep Blue Sea", "Flourish",
				"GoonBee", 2053, 20, 4, 0);

		Book bee = new Book(2, "Heisenbee's Great Trial", "Hufflaw Zizek",
				"GoonBee", 1043, 7, 20, 0);

		Book shade = new Book(10, "Shade's Children", "Garth Nix",
				"HarperCollins", 1997, 32, 9, 0);

		Customer bob = new Customer("Bob Joe", 34294, "599 South Shady Lane");

		Customer james = new Customer("James Dagett", 42069, "5000 N. Willamette Blvd.");

		Customer sally = new Customer("Sally Sloan", 11254, "10 Cheese Peak Drive");

		Customer tina = new Customer("Tina Llama", 204060, "40 Mudfootballer Boulevard");

		System.out.println("------------------------");
		System.out.println("Here are our customers:");
		System.out.println(bob.toString());
		System.out.println(james.toString());
		System.out.println(sally.toString());
		System.out.println(tina.toString());
		System.out.println("-----------------------");
		System.out.println("Here are our books:");
		System.out.println(hike.toString());
		System.out.println(albert.toString());
		System.out.println(bee.toString());
		System.out.println(shade.toString());
		System.out.println("------------------------");

		tina.setCard_num(4440);
		tina.setPassword("lasagna_garfield");
		tina.addBook(shade, 3);

		james.setCard_num(1234);
		System.out.println("James' ID:" + james.getAcc_id());
		System.out.println("James' Card:" + james.getCard_num());
		james.setPassword("hacked");
		james.addBook(hike, 12);
		james.addBook(hike, 7);

		System.out.println("Sally's Name: " + sally.getName());
		sally.setPassword("correcthorsebatterystaple");
		System.out.println("Sally's Password: " + sally.getPassword());
		System.out.println("Sally's Books: " + sally.getBoughtBooks());
		sally.addBook(bee, 2);
		sally.addBook(albert, 1);
		System.out.println(sally.getBoughtBooks());

		System.out.println(bob.getAddress());


	}

}
