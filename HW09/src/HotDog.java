/**
 * Hotdogs, child of Pastillum
 */
class HotDog extends Pastillum {

	//HotDogs always are from the US and have a bread type of a Split Roll
	HotDog(String meatFilling) {
		super("Hot Dog", "Pastillum Brautcana", meatFilling);
		setBreadType("Split Roll");
		setCountryOfOrigin("United States");
		addComposingElement(getBreadType() + " x" + getNumberOfBreadSlices());
		addCommonCondiments();
	}

	/**
	 * Adds common hotdog condiments in a wrapper class
	 */
	private void addCommonCondiments() {
		addCondimentApplicable("Mustard");
		addCondimentApplicable("Ketchup");
		addCondimentApplicable("Onions");
		addCondimentApplicable("Relish");
	}
}
