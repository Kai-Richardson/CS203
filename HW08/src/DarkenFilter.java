import static java.lang.Integer.max;

/**
 * Filter that darkens the image by a noticeable amount
 *
 * @author Kai Richardson
 * @version 4.2.2019
 */
public class DarkenFilter implements Filter {

	private final static int DARK_AMT = 15;

	@Override
	public void filter(PixelImage pi) {

		DemosaicFilter df = new DemosaicFilter();

		df.filter(pi); //be sure to de-mosaic it first

		Pixel[][] data = pi.getData();  //get image data

		for (int row = 0; row < (pi.getHeight()); row++) {
			for (int col = 0; col < (pi.getWidth()); col++) {

				Pixel ourPixel = data[row][col];

				//Reduce all intensities by DARK_AMT.
				//Minimum to 0 so it doesn't underflow.
				int newRed = max(0, ourPixel.getRed() - DARK_AMT);
				int newGreen = max(0, ourPixel.getGreen() - DARK_AMT);
				int newBlue = max(0, ourPixel.getBlue() - DARK_AMT);

				ourPixel.setAllColors(newRed, newGreen, newBlue);
			}

		}
		// reset data into the PixelImage object pi
		pi.setData(data);
	}
}
