/**
 * EdgeFilter
 * A class to detect edges
 *
 * Also implemented half-tone coloring
 *
 * @author Kai Richardson
 * @version 4.3.2019
 */
public class EdgeFilter extends PixelGridFramework implements Filter {

	private final static int JND = 17; //Just Noticeable Difference

	@Override
	public void filter(PixelImage pi) {

		DemosaicFilter df = new DemosaicFilter();

		df.filter(pi); //be sure to de-mosaic it first

		Pixel[][] data = pi.getData();  // get image data

		Boolean[][] edgeHolder = new Boolean[pi.getHeight()][pi.getWidth()];

		//Fill the edgeHolder with a values telling if each pixel in the image is an edge
		for (int row = 0; row < (pi.getHeight()); row++) {
			for (int col = 0; col < (pi.getWidth()); col++) {
				setupLocalPixelGrid(data, row, col);

				int ourBrightness = tryGetBrightness(Center);

				boolean weAreEdge = false;

				if (isEdge(ourBrightness, TopLeft) ||
						isEdge(ourBrightness, Top) ||
						isEdge(ourBrightness, TopRight) ||

						isEdge(ourBrightness, Left) ||
						isEdge(ourBrightness, Right) ||

						isEdge(ourBrightness, BottomLeft) ||
						isEdge(ourBrightness, Bottom) ||
						isEdge(ourBrightness, BottomRight)) {
					weAreEdge = true;
				}
				edgeHolder[row][col] = weAreEdge;
			}
		}

		for (int row2 = 0; row2 < (pi.getHeight()); row2++) {
			for (int col2 = 0; col2 < (pi.getWidth()); col2++) {

				if (edgeHolder[row2][col2]) {
					data[row2][col2].setAllColors(255, 255, 255);
				} else {
					data[row2][col2].setAllColors(0, 0, 0);
				}

			}
		}


		// reset data into the PixelImage object pi
		pi.setData(data);

	}

	private boolean isEdge(int baseBrightness, Pixel px) {
		return tryGetBrightness(px) - baseBrightness > JND || baseBrightness - tryGetBrightness(px) > JND;
	}


}
