/**
 * Hotdog-Like structures
 */
class HotDog extends Pastillum {


	HotDog(String meatFilling) {
		super("Hot Dog", "Pastillum Brautcana", meatFilling);
		setBreadType("Split Roll");
		setCountryOfOrigin("United States");
		addComposingElement(getBreadType() + " x" + getNumberOfBreadSlices());
		addCommonCondiments();
	}

	private void addCommonCondiments() {
		addCondimentApplicable("Mustard");
		addCondimentApplicable("Ketchup");
		addCondimentApplicable("Onions");
		addCondimentApplicable("Relish");
	}
}
