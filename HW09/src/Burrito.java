/**
 * Burrito, a subtype of Calzoni.
 */
class Burrito extends Calzoni {

	//Burritos are always from Mexico and have a bread type of Tortilla
	Burrito(String meatFilling) {
		super("Burrito", "Calzoni Burritoa", meatFilling);
		setCountryOfOrigin("Mexico");
		setBreadType("Tortilla");
		addComposingElement(getBreadType() + " x" + getNumberOfBreadSlices());
	}
}
