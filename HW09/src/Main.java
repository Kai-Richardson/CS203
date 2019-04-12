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
		BigMac bg = new BigMac("Beef");

		println("Created our foods. Testing time!");

		println("");
		hd.tryAddCondiment("Ketchup");
		hd.tryAddCondiment("Relish");
		hd.tryAddCondiment("Franz Hall"); //Won't add.
		println(hd.toString());

		println("");
		tc.addComposingElement("Shredded Lettuce");
		tc.addComposingElement("Grated Queso");
		tc.addCondimentApplicable("Hot Sauce");
		tc.tryAddCondiment("Hot Sauce");
		println(tc.toString());

		println("");
		cl.addComposingElement("Melted Cheese");
		println(cl.toString());

		println("");
		br.addComposingElement("Beans");
		br.addComposingElement("Shredded Cheese");
		br.addCondimentApplicable("BBQ Sauce");
		br.tryAddCondiment("BBQ Sauce");
		println(br.toString());

		println("");
		sb.addComposingElement("Meatballs");
		sb.addComposingElement("Tomato Sauce");
		sb.addComposingElement("Provolone");
		sb.addCondimentApplicable("Parmesean");
		sb.tryAddCondiment("Parmesean");
		sb.tryAddCondiment("Swimming Pools"); //Won't add
		println(sb.toString());

		println("");
		bg.addComposingElement("Lettuce");
		bg.tryAddCondiment("Relish"); //Won't work
		println(bg.toString());

	}

	private static void println(Object line) {
		System.out.println(line);
	}
}
