/**
 * Calzoni Parent, child of BreadLike
 */
abstract class Calzoni extends BreadLike {

	private String meatFilling;

	//calzonis always just have one spherical slice
	Calzoni(String nameDisplay, String nameScientific, String filling) {
		super(nameDisplay, nameScientific);
		this.setNumberOfBreadSlices(1);
		setMeatFilling(filling);
		this.addComposingElement(this.meatFilling);
	}

	/**
	 * Method to  get the meat filling of a Calzoni
	 *
	 * @return String representation of the meat filling
	 */
	private String getMeatFilling() {
		return meatFilling;
	}

	/**
	 * Method to set the meat filling of the Calzoni
	 * @param meatFilling String to set the meat filling to
	 */
	private void setMeatFilling(String meatFilling) {
		this.meatFilling = meatFilling;
	}

	//All Calzonis have a Meat Filling of some sort.
	@Override
	public String toString() {
		String superValue = super.toString();
		String addString = ", Meat Filling: " + getMeatFilling();

		return superValue + addString;
	}
}
