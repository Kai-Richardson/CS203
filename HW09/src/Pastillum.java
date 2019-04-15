/**
 * Pastillum Parent, child of BreadLike
 */
abstract class Pastillum extends BreadLike {

	//Pastillums always have only 1 bread slice
	Pastillum(String nameDisplay, String nameScientific, String meatFilling) {
		super(nameDisplay, nameScientific);
		setNumberOfBreadSlices(1);
		addComposingElement(meatFilling + " Filling");

	}
}
