/**
 * Pastillum Parent
 */
abstract class Pastillum extends BreadLike {

	Pastillum(String nameDisplay, String nameScientific, String meatFilling) {
		super(nameDisplay, nameScientific);
		setNumberOfBreadSlices(1);
		addComposingElement(meatFilling + " Filling");

	}
}
