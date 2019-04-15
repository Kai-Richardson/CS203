/**
 * Sandwico Parent, child of BreadLike
 */
abstract class Sandwico extends BreadLike {

	//Sandwicos are always composed to two slices
	Sandwico(String nameDisplay, String nameScientific) {
		super(nameDisplay, nameScientific);
		this.setNumberOfBreadSlices(2);
	}
}
