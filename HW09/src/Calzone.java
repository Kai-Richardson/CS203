/**
 * Calzones, subtype of Calzoni
 */
class Calzone extends Calzoni {

	//Calzones are always from Italy and made of Pizza Dough
	Calzone(String meatFilling) {
		super("Calzone", "Calzoni Paterprimaria", meatFilling);
		setCountryOfOrigin("Italy");
		setBreadType("Pizza Dough");
		addComposingElement(getBreadType() + " x" + getNumberOfBreadSlices());

	}
}
