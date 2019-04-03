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
    static void configure(SnapShop theShop) {
        // set default directory
        theShop.setDefaultDirectory("./Images/");
     
        theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");

        theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");

        theShop.addFilter(new DemosaicFilter(), "De-mosaic");

        theShop.addFilter(new DarkenFilter(), "Darken");

        theShop.addFilter(new EdgeFilter(), "Detect Edges");

        theShop.addFilter(new CorruptFilter(), "Corrupt");

        theShop.addFilter(new ShiftRightFilter(), "Shift Right");

    }
    
    /** 
     * main
     * creates a new SnapShop object
     */
    public static void main(String[] args) {
      SnapShop theShop = new SnapShop();
    }  
}
