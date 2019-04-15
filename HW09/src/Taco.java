/**
 * Tacos, child of Pastillum
 */
class Taco extends Pastillum {

	//Tacos are from Mexico and contain a Tortilla
	Taco(String meatFilling) {
		super("Taco", "Pastillum Tacoa", meatFilling);
		setBreadType("Tortilla");
		setCountryOfOrigin("Mexico");
		addComposingElement(getBreadType() + " x" + getNumberOfBreadSlices());
	}
}
