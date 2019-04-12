/**
 * Pastillum Parent
 */
abstract class Pastillum extends BreadLike {

	private String meatFilling;

	Pastillum(String nameDisplay, String nameScientific, String meatFilling) {
		super(nameDisplay, nameScientific);
		this.meatFilling = meatFilling;
		this.setNumberOfBreadSlices(1);
	}
}
