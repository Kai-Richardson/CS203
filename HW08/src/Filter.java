/**
 * Filter Interface -
 * Specifies a filter method to modify images
 *
 * @author Tammy VanDeGrift
 * @version Oct. 31, 2007
 * <p>
 * !!! DO NOT MODIFY THIS INTERFACE !!!
 */
public interface Filter {
	/* interface filter. All filters should implement this interface */

	/**
	 * Modify the image according to your algorithm
	 *
	 * @param theImage The image to modify
	 */
	void filter(PixelImage theImage);
}
