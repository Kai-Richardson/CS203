/**
 * This Main function is used to test the Book and Customer classes.
 *
 * @author - Kai Richardson
 * @version 2019-03-18
 */
class Main {

	public static void main(String[] args) {

		//Init samples
		Book hike = new Book(42, "Hitchhiker's Guide to the Galaxy", "Douglas Adams",
				"Pan Books", 1979, 21, 10);

		Book albert = new Book(4, "Albert & The Deep Blue Sea", "Flourish",
				"GoonBee", 2053, 20, 4);

		Book bee = new Book(2, "Heisenbee's Great Trial", "Hufflaw Zizek",
				"GoonBee", 1043, 7, 20);

		Book shade = new Book(10, "Shade's Children", "Garth Nix",
				"HarperCollins", 1997, 32, 9);

		Customer bob = new Customer("Bob Joe", 34294, "599 South Shady Lane");

		Customer james = new Customer("James Dagett", 42069, "5000 N. Willamette Blvd.");

		Customer sally = new Customer("Sally Sloan", 11254, "10 Cheese Peak Drive");

		Customer tina = new Customer("Tina Llama", 204060, "40 Mudfootballer Boulevard");


		//Start sample printout
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

		System.out.println("hike's Author: " + hike.getAuthor());
		System.out.println("hike's ID: " + hike.getID());

		System.out.println("------------------------");
		System.out.println("bee's Title: " + bee.getTitle());
		System.out.println("bee's price: " + bee.getPrice());

		System.out.println("------------------------");
		System.out.println("albert's number of copies: " + albert.getNumCopies());
		System.out.println("albert's publisher: " + albert.getPublisher());

		System.out.println("------------------------");
		System.out.println("shade's year of publish: " + shade.getYearPub());
		System.out.println("shade's number sold: " + shade.getNumSold());


		//Here we play around with customer methods.
		System.out.println("------------------------");
		tina.setCard_num(4440);
		System.out.println("Tina's ID: " + tina.getAcc_id());
		tina.setPassword("lasagna_garfield");
		shade.sale(tina, 3);
		bee.sale(tina, 1);
		bee.restock(24);
		albert.sale(tina, 1);
		hike.sale(tina, -20); //Will produce an error

		System.out.println("------------------------");
		james.setCard_num(1234);
		System.out.println("James' ID: " + james.getAcc_id());
		System.out.println("James' Card: " + james.getCard_num());
		james.setPassword("hacked");
		james.setAddress("1337 get hacked avenue");
		hike.sale(james, 9);
		hike.sale(james, 7); //Will produce an error, so let's restock
		hike.restock(30);
		hike.sale(james, 7);
		System.out.println(james.getBoughtBooks());

		System.out.println("------------------------");
		System.out.println("Sally's Name: " + sally.getName());
		sally.setPassword("correcthorsebatterystaple");
		System.out.println("Sally's Password: " + sally.getPassword());
		System.out.println("Sally's Books: " + sally.getBoughtBooks());
		bee.sale(sally, 2);
		albert.sale(sally, 1);
		System.out.println(sally.getBoughtBooks());

		System.out.println("------------------------");
		System.out.println("Bob's Address: " + bob.getAddress());
		bob.setAddress("1049 Malona St.");
		System.out.println("Bob's New Address: " + bob.getAddress());
		System.out.println("------------------------");

		System.out.println("Samples done!");

	}

}
