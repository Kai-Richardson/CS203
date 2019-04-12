/**
 * Calzoni Parent
 */
abstract class Calzoni extends BreadLike {

	private String meatFilling = "";

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
}
