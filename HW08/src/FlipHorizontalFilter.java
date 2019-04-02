/**
 * Filter that flips the image horizontally.
 * 
 * @author Kai Richardson
 * @version  4.1.2019
 * 
 */
public class FlipHorizontalFilter implements Filter {
    // no instance variables -- no state of objects
  
    /** 
     * filter
     * flips pixel image vertically around horizontal
     * center line
     * @param pi The PixelImage object to modify
     */
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();  // get image data
    
        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth() / 2; col++) {
                // swap values across center line
                Pixel temp = data[row][col];
                data[row][col] = data[row][pi.getWidth() - col - 1];
                data[row][pi.getWidth() - col - 1] = temp;
            }
        }  
        // reset data into the PixelImage object pi
        pi.setData(data);
    }
}
