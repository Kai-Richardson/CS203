/**
 * Calzoni Parent
 */
abstract class Calzoni extends BreadLike {

	private String meatFilling;

	Calzoni(String nameDisplay, String nameScientific, String filling) {
		super(nameDisplay, nameScientific);
		this.setNumberOfBreadSlices(1);
		setMeatFilling(filling);
		this.addComposingElement(this.meatFilling);
	}

	private String getMeatFilling() {
		return meatFilling;
	}

	private void setMeatFilling(String meatFilling) {
		this.meatFilling = meatFilling;
	}

	@Override
	public String toString() {
		String superValue = super.toString();
		String addString = ", Meat Filling: " + getMeatFilling();

		return superValue + addString;
	}
}
