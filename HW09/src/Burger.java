/**
 * Hamburger-Like Objects
 */
public class Burger extends Sandwico {

	private String pattyMeat;
	private String chainOfOrigin = "";

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

	private String getChainOfOrigin() {
		return chainOfOrigin;
	}

	private void setChainOfOrigin(String chainOfOrigin) {
		this.chainOfOrigin = chainOfOrigin;
	}

	void addCommonCondiments() {
		addCondimentApplicable("Mustard");
		addCondimentApplicable("Ketchup");
		addCondimentApplicable("Onions");
		addCondimentApplicable("Relish");
	}

	private String getPattyMeat() {
		return pattyMeat;
	}

	private void setPattyMeat(String pattyMeat) {
		this.pattyMeat = pattyMeat;
	}

	@Override
	public String toString() {
		String superValue = super.toString();
		String addString = ", Chain of Origin: " + getChainOfOrigin();

		return superValue + addString;
	}
}
