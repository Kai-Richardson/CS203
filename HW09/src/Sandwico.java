/**
 * Sandwico Parent
 */
abstract class Sandwico extends BreadLike {

	Sandwico(String nameDisplay, String nameScientific) {
		super(nameDisplay, nameScientific);
		this.setNumberOfBreadSlices(2);
	}
}
