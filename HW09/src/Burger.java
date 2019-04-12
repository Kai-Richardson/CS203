/**
 * Hamburger-Like Objects
 */
public class Burger extends Sandwico {

	private String pattyMeat = "Beef";
	private String chainOfOrigin = "";

	Burger(String chainOfOrigin) {
		super("Burger", "Sandwico Hamburgenese");
		addCommonCondiments();
		setBreadType("Bun");
		setCountryOfOrigin("United States");
		setChainOfOrigin(chainOfOrigin);
		addComposingElement(getBreadType() + " x" + getNumberOfBreadSlices());
		addComposingElement("Patty - " + getPattyMeat());
		addComposingElement("Lettuce");
	}

	public String getChainOfOrigin() {
		return chainOfOrigin;
	}

	private void setChainOfOrigin(String chainOfOrigin) {
		this.chainOfOrigin = chainOfOrigin;
	}

	private void addCommonCondiments() {
		addCondimentApplicable("Mustard");
		addCondimentApplicable("Ketchup");
		addCondimentApplicable("Onions");
		addCondimentApplicable("Relish");
	}

	private String getPattyMeat() {
		return pattyMeat;
	}

	public void setPattyMeat(String pattyMeat) {
		this.pattyMeat = pattyMeat;
	}
}
