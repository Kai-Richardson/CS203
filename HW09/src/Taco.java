class Taco extends Pastillum {

	Taco(String meatFilling) {
		super("Taco", "Pastillum Tacoa", meatFilling);
		setBreadType("Tortilla");
		setCountryOfOrigin("Mexico");
		addComposingElement(getBreadType() + " x" + getNumberOfBreadSlices());
	}
}
