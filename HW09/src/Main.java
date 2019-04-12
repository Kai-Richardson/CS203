/**
 * Main class for testing purposes
 *
 * @author Kai Richardson
 * @version April.12.2019
 */
public class Main {

	public static void main(String[] args) {

		//Create a bunch of food items to test on
		HotDog hd = new HotDog("Sausage");
		Taco tc = new Taco("Beef");

		Calzone cl = new Calzone("Pepperoni");
		Burrito br = new Burrito("Chicken");

		Sub sb = new Sub("Hoagie");
		Burger bg = new Burger("McDonalds");

		println("Created our foods. Testing time!");

		sb.addComposingElement("Meatballs");
		sb.addComposingElement("Tomato Sauce");
		sb.addComposingElement("Provolone");
		sb.addCondimentApplicable("Parmesean");
		sb.tryAddCondiment("Parmesean");
		sb.tryAddCondiment("Swimming Pools");
		println(sb.toString());
		println("Local Word for our Sub: " + sb.getLocalWord());

	}

	private static void println(Object line) {
		System.out.println(line);
	}
}
