import java.util.ArrayList;

/**
 * The parent object of any type of food.
 *
 * @author Kai Richardson
 * @version April.12.2019
 */
public abstract class FoodObject {

	private String nameDisplay = "Food Item";
	private String nameScientific = "Latin Latin";

	private String countryOfOrigin = "";
	private ArrayList<String> ComposingElements = new ArrayList<String>();
	private ArrayList<String> condimentsApplied = new ArrayList<String>();
	private ArrayList<String> condimentsApplicable = new ArrayList<String>();

	FoodObject(String nameDisplay, String nameScientific) {
		this.nameDisplay = nameDisplay;
		this.nameScientific = nameScientific;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getNameDisplay() {
		return nameDisplay;
	}

	public String getNameScientific() {
		return nameScientific;
	}

	public ArrayList<String> getComposingElements() {
		return ComposingElements;
	}

	void addComposingElement(String newElement) {
		ComposingElements.add(newElement);
	}

	public ArrayList<String> getCondimentsApplied() {
		return condimentsApplied;
	}

	public void tryAddCondiment(String condiment) {
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
		return "Name: " + nameDisplay + ", " +
				"Scientific Name: " + nameScientific + ", " +
				"Ingredients: " + ComposingElements + ", " +
				"Condiments: " + condimentsApplied;
	}
}

