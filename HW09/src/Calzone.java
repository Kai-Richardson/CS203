/**
 * Calzones
 */
class Calzone extends Calzoni {

	Calzone(String meatFilling) {
		super("Calzone", "Calzoni Paterprimaria", meatFilling);
		setCountryOfOrigin("Italy");
		setBreadType("Pizza Dough");
		addComposingElement(getBreadType() + " x" + getNumberOfBreadSlices());

	}
}
