/**
 * Burritos
 */
class Burrito extends Calzoni {

	Burrito(String meatFilling) {
		super("Burrito", "Calzoni Burritoa", meatFilling);
		setCountryOfOrigin("Mexico");
		setBreadType("Tortilla");
		addComposingElement(getBreadType() + " x" + getNumberOfBreadSlices());
	}
}
