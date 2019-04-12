/**
 * Bread-Like Constructions
 */
public abstract class BreadLike extends FoodObject {

	private String breadType = "White Bread";
	private Integer numberOfBreadSlices = 1;

	BreadLike(String nameDisplay, String nameScientific) {
		super(nameDisplay, nameScientific);
	}

	String getBreadType() {
		return breadType;
	}

	void setBreadType(String breadType) {
		this.breadType = breadType;
	}

	Integer getNumberOfBreadSlices() {
		return numberOfBreadSlices;
	}

	void setNumberOfBreadSlices(Integer numberOfBreadSlices) {
		this.numberOfBreadSlices = numberOfBreadSlices;
	}

	@Override
	public String toString() {

		String superValue = super.toString();
		String addString = ", Type of bread: " + breadType + ", " + "Number of slices: " + numberOfBreadSlices;

		return superValue + addString;
	}

}
