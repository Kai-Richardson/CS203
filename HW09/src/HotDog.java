/**
 * Hotdog-Like structures
 */
public class HotDog extends Pastillum {


	public HotDog(String meatFilling) {
		super("Hot Dog", "Pastillum Brautcana", meatFilling);
		addCommonCondiments();
	}

	private void addCommonCondiments() {
		addCondimentApplicable("Mustard");
		addCondimentApplicable("Ketchup");
		addCondimentApplicable("Onions");
		addCondimentApplicable("Relish");
	}
}
