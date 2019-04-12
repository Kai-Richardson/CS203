import java.util.ArrayList;

/**
 * The parent object of any type of food.
 *
 * @author Kai Richardson
 * @version April.12.2019
 */
public abstract class FoodObject {

	private String nameDisplay;
	private String nameScientific;

	private String countryOfOrigin = "";
	private ArrayList<String> ComposingElements = new ArrayList<>();
	private ArrayList<String> condimentsApplied = new ArrayList<>();
	private ArrayList<String> condimentsApplicable = new ArrayList<>();

	FoodObject(String nameDisplay, String nameScientific) {
		this.nameDisplay = nameDisplay;
		this.nameScientific = nameScientific;
	}

	private String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	private String getNameDisplay() {
		return nameDisplay;
	}

	private String getNameScientific() {
		return nameScientific;
	}

	private ArrayList<String> getComposingElements() {
		return ComposingElements;
	}

	void addComposingElement(String newElement) {
		ComposingElements.add(newElement);
	}

	private ArrayList<String> getCondimentsApplied() {
		return condimentsApplied;
	}

	void tryAddCondiment(String condiment) {
		if (this.getCondimentsApplicable().contains(condiment)) {
			this.condimentsApplied.add(condiment);
		}
	}

	private ArrayList<String> getCondimentsApplicable() {
		return condimentsApplicable;
	}

	void addCondimentApplicable(String condimentApplicable) {
		this.condimentsApplicable.add(condimentApplicable);
	}

	@Override
	public String toString() {
		return "Name: " + getNameDisplay() + ", " +
				"Scientific Name: " + getNameScientific() + ", " +
				"Country of Origin: " + getCountryOfOrigin() + ", " +
				"Ingredients: " + getComposingElements() + ", " +
				"Condiments: " + getCondimentsApplied();
	}
}

