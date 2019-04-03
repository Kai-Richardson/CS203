/**
 * A Framework to setup local pixel grids based around a single pixel
 *
 * @author Kai Richardson
 * @version 4.2.2019
 */
class PixelGridFramework {

	Pixel TopLeft;
	Pixel Top;
	Pixel TopRight;

	Pixel Left;
	Pixel Center;
	Pixel Right;

	Pixel BottomLeft;
	Pixel Bottom;
	Pixel BottomRight;

	//Attempts to return a pixel at a specified position in given array
	private Pixel tryGetPixel(int row, int col, Pixel[][] arr) {
		Pixel result;

		try {
			result = arr[row][col];
		} catch (ArrayIndexOutOfBoundsException exception) {
			result = null; //we're at an image border, so let's set it to null so we detect later
		}

		return result;
	}

	//Attempts to assign one pixel's values to another given pixel
	void trySetPixel(Pixel toMove, Pixel toReplace) {
		try {
			toReplace.setAllColors(toMove.getRed(), toMove.getGreen(), toMove.getBlue());
		} catch (Exception ignored) {
		}
	}

	//Attempts to get the color of a given pixel
	int tryGetColor(Pixel px, int color) {

		if (px == null) {
			return 128; //border, let's set at middle brightness
		}

		return px.getComponentById(color);
	}

	//Returns the brightness of a pixel
	int tryGetBrightness(Pixel px) {
		int result = 0;

		try {
			result += px.getRed();
			result += px.getBlue();
			result += px.getGreen();
			result /= 3;
		} catch (NullPointerException exception) {
			result = 0; //we're at an image border, pass 0 to use later
		}

		return result;
	}

	//sets up a local pixel grid given an array and a row/col
	void setupLocalPixelGrid(Pixel[][] data, int row, int col) {
		TopLeft = tryGetPixel(row - 1, col - 1, data);
		Top = tryGetPixel(row - 1, col, data);
		TopRight = tryGetPixel(row - 1, col + 1, data);

		Left = tryGetPixel(row, col - 1, data);
		Center = tryGetPixel(row, col, data);
		Right = tryGetPixel(row, col + 1, data);

		BottomLeft = tryGetPixel(row + 1, col - 1, data);
		Bottom = tryGetPixel(row + 1, col, data);
		BottomRight = tryGetPixel(row + 1, col + 1, data);
	}
}
