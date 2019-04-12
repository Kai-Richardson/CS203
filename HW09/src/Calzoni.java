/**
 * Calzoni Parent
 */
abstract class Calzoni extends BreadLike {

	private String meatFilling;

	Calzoni(String nameDisplay, String nameScientific, String filling) {
		super(nameDisplay, nameScientific);
		this.setNumberOfBreadSlices(1);
		this.meatFilling = filling;
		this.addComposingElement(this.meatFilling);
	}

	public String getMeatFilling() {
		return meatFilling;
	}

	public void setMeatFilling(String meatFilling) {
		this.meatFilling = meatFilling;
	}

	@Override
	public String toString() {
		String superValue = super.toString();
		String addString = ", Meat Filling: " + getMeatFilling();

		return superValue + addString;
	}
}
