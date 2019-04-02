/**
 * Filter that shifts the image to the right by 1px
 *
 * @author Kai Richardson
 * @version 4.2.2019
 */
public class ShiftRightFilter implements Filter {
	// no instance variables -- no state of objects

	/**
	 * filter
	 * shifts the image to the right by 1px
	 *
	 * @param pi The PixelImage object to modify
	 */
	public void filter(PixelImage pi) {
		Pixel[][] data = pi.getData();  // get image data

		for (int row = 0; row < pi.getHeight(); row++) {

			Pixel[] newCreatedRow = new Pixel[pi.getWidth()];

			for (int col = 0; col < pi.getWidth(); col++) {

				Pixel ourPixel = data[row][col];

				if (col == pi.getWidth() - 1) {
					newCreatedRow[0] = ourPixel;
				} else {
					newCreatedRow[col + 1] = ourPixel;
				}
			}

			data[row] = newCreatedRow;
		}
		// reset data into the PixelImage object pi
		pi.setData(data);
	}
}
