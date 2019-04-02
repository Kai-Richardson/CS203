/**
 * SnapShopConfiguration
 * A class to configure the SnapShop application
 * 
 * @author Kai Richardson
 * @version  4.1.2019
 * 
 */
public class SnapShopConfiguration {
    /**
     * configure
     * Method to configure the SnapShop.  
     * Call methods like addFilter
     * and setDefaultFilename in this method.
     * @param theShop   The SnapShop application
     */
    public static void configure(SnapShop theShop) {
        // set default directory
        theShop.setDefaultDirectory("./Images/");
     
        theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");

        theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");

        theShop.addFilter(new DemosaicFilter(), "De-mosaic");
        // add other filters you write here:
        // the arguments to addFilter are a Filter object, followed by the 
        // text you want shown on the button
    }
    
    /** 
     * main
     * creates a new SnapShop object
     */
    public static void main(String args[]) {
      SnapShop theShop = new SnapShop();
    }  
}
