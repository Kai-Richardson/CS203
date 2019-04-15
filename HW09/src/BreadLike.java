/**
 * Bread-Like Constructions
 */
public abstract class BreadLike extends FoodObject {

	private String breadType = "White Bread";
	private Integer numberOfBreadSlices = 1;

	BreadLike(String nameDisplay, String nameScientific) {
		super(nameDisplay, nameScientific);
	}

	/**
	 * Method to return the bread type of a BreadLike
	 *
	 * @return String describing the bread-like material
	 */
	String getBreadType() {
		return breadType;
	}

	/**
	 * Method to set the bread type of a BreadLike
	 * @param breadType String describing the BreadLike's bread type
	 */
	void setBreadType(String breadType) {
		this.breadType = breadType;
	}

	/**
	 * Method to return the number of bread slices of a BreadLike
	 * @return Integer counting the number of slices
	 */
	Integer getNumberOfBreadSlices() {
		return numberOfBreadSlices;
	}

	/**
	 * Method to set the number of slices of a BreadLike
	 * @param numberOfBreadSlices Integer to set the number of slices to
	 */
	void setNumberOfBreadSlices(Integer numberOfBreadSlices) {
		this.numberOfBreadSlices = numberOfBreadSlices;
	}

	//BreadLikes have a type of bread and a specific number of slices.
	@Override
	public String toString() {

		String superValue = super.toString();
		String addString = ", Type of bread: " + breadType + ", " + "Number of slices: " + numberOfBreadSlices;

		return superValue + addString;
	}

}
