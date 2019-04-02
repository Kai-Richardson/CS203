/**
 * De-mosaicFilter
 * A filter to de-mosiac
 *
 * @author Kai Richardson
 * @version  4.1.2019
 *
 */
public class DemosaicFilter extends PixelGridFramework implements Filter {

    // static variables for digital camera filter -
    private static final int RED = 1;
    private static final int GREEN = 2;
    private static final int BLUE = 3;

    private static final double ADJUSTMENT = 1.28; // in order to more accurately reproduce whites

    /**
     * filter
     * de-mosaics the image
     * @param pi The PixelImage object to modify
     */
    @Override
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();  // get image data

        for (int row = 0; row < (pi.getHeight()); row++) {
            for (int col = 0; col < (pi.getWidth()); col++) {

	            int ourBlue = 0;
	            int ourRed = 0;
	            int ourGreen = 0;

	            setupLocalPixelGrid(data, row, col);

                int colorNoModify = Center.getDigCamColor();

                switch (colorNoModify){
                    case RED:
                        ourRed = tryGetColor(Center, RED);

	                    ourGreen += tryGetColor(Top, GREEN);
	                    ourGreen += tryGetColor(Bottom, GREEN);
	                    ourGreen += tryGetColor(Left, GREEN);
	                    ourGreen += tryGetColor(Right, GREEN);
	                    ourGreen /= 4;
	                    ourGreen /= ADJUSTMENT;

	                    ourBlue += tryGetColor(TopLeft, BLUE);
	                    ourBlue += tryGetColor(BottomLeft, BLUE);
	                    ourBlue += tryGetColor(BottomRight, BLUE);
	                    ourBlue += tryGetColor(TopRight, BLUE);
                        ourBlue /= 4;
                        break;

                    case GREEN:
                        ourGreen = tryGetColor(Center, GREEN);
                        //ourGreen /= 1.05;

                        ourRed += tryGetColor(Top, RED);
                        ourRed += tryGetColor(Bottom, RED);
                        ourRed /= 2;

                        ourBlue += tryGetColor(Left, BLUE);
                        ourBlue += tryGetColor(Right, BLUE);
                        ourBlue /= 2;
                        break;

                    case BLUE:
                        ourBlue = tryGetColor(Center, BLUE);

                        ourGreen += tryGetColor(Top, GREEN);
                        ourGreen += tryGetColor(Bottom, GREEN);
                        ourGreen += tryGetColor(Left, GREEN);
                        ourGreen += tryGetColor(Right, GREEN);
                        ourGreen /= 4;
	                    ourGreen /= ADJUSTMENT;

                        ourRed += tryGetColor(TopLeft, RED);
                        ourRed += tryGetColor(BottomLeft, RED);
                        ourRed += tryGetColor(BottomRight, RED);
                        ourRed += tryGetColor(TopRight, RED);
                        ourRed /= 4;
                        break;
                }

				Center.setRed(ourRed);
				Center.setGreen(ourGreen);
				Center.setBlue(ourBlue);
			}

		}
		// reset data into the PixelImage object pi
		pi.setData(data);
	}



}