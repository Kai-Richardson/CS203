/**
 * Sub Sandwich, child of Sandwico
 */
class Sub extends Sandwico {

	//The localized word for a given Sub
	private String localWord = "";

	//Subs always are on a Long Crust Roll and are from the United States
	Sub(String localWord) {
		super("Sub Sandwich", "Sandwico Subaqueneam");
		setNumberOfBreadSlices(1);
		setLocalWord(localWord);
		setBreadType("Long Crust Roll");
		setCountryOfOrigin("United States");
		addComposingElement(getBreadType() + " x" + getNumberOfBreadSlices());
	}

	/**
	 * Method to obtain the local word of a Sub
	 *
	 * @return String representing the local word of a Sub
	 */
	private String getLocalWord() {
		return localWord;
	}

	/**
	 * Method to set the local word of a Sub
	 * @param localWord String to set the local word of the Sub to
	 */
	private void setLocalWord(String localWord) {
		this.localWord = localWord;
	}

	//Subs have a local word, so let's include it
	@Override
	public String toString() {
		String superValue = super.toString();
		String addString = ", Also known as a: " + getLocalWord();

		return superValue + addString;
	}
}
