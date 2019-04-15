/**
 * Hamburgers, subtype of Sandwico. Can set a fast food chain of origin, as well as a patty meat.
 */
public class Burger extends Sandwico {

	private String pattyMeat;
	private String chainOfOrigin = "";

	//constructor
	Burger(String chainOfOrigin, String pattyMeat) {
		super("Burger", "Sandwico Hamburgenese");
		addCommonCondiments();
		setBreadType("Bun");
		setPattyMeat(pattyMeat);
		setCountryOfOrigin("United States");
		setChainOfOrigin(chainOfOrigin);
		addComposingElement(getBreadType() + " x" + getNumberOfBreadSlices());
		addComposingElement("Patty - " + getPattyMeat());
	}

	/**
	 * Method to obtain the chain of origin of a Burger
	 *
	 * @return String containing the chain of origin
	 */
	private String getChainOfOrigin() {
		return chainOfOrigin;
	}

	/**
	 * Method to set the chain of origin of a Burger
	 * @param chainOfOrigin String to set the chain of origin to
	 */
	private void setChainOfOrigin(String chainOfOrigin) {
		this.chainOfOrigin = chainOfOrigin;
	}

	/**
	 * Adds common burger condiments in a wrapper class
	 */
	void addCommonCondiments() {
		addCondimentApplicable("Mustard");
		addCondimentApplicable("Ketchup");
		addCondimentApplicable("Onions");
		addCondimentApplicable("Relish");
	}

	/**
	 * Method to return the patty meat of the Burger
	 * @return String of the patty meat
	 */
	private String getPattyMeat() {
		return pattyMeat;
	}

	/**
	 * Method to set the patty meat of the Hamburger
	 * @param pattyMeat String to to set the patty meat to
	 */
	private void setPattyMeat(String pattyMeat) {
		this.pattyMeat = pattyMeat;
	}

	//Burgers have a chain of origin
	@Override
	public String toString() {
		String superValue = super.toString();
		String addString = ", Chain of Origin: " + getChainOfOrigin();

		return superValue + addString;
	}
}
