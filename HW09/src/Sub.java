/**
 * Sub Sandwich
 */
class Sub extends Sandwico {

	private String localWord = "";

	Sub(String localWord) {
		super("Sub Sandwich", "Sandwico Subaqueneam");
		setNumberOfBreadSlices(1);
		setLocalWord(localWord);
		setBreadType("Long Crust Roll");
		setCountryOfOrigin("United States");
		addComposingElement(getBreadType() + " x" + getNumberOfBreadSlices());
	}

	String getLocalWord() {
		return localWord;
	}

	private void setLocalWord(String localWord) {
		this.localWord = localWord;
	}
}
