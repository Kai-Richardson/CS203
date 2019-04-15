/**
 * Big Mac subtype of Burder, will only accept Big Mac Sauce as a condiment and is always from McDonalds.
 */
class BigMac extends Burger {
	BigMac(String pattyMeat) {
		super("McDonalds", pattyMeat); //You can only get Big Macs at McDonalds
	}

	//Only Big Mac Sauce is allowed
	@Override
	void addCommonCondiments() {
		addCondimentApplicable("Big Mac Sauce");
		tryAddCondiment("Big Mac Sauce");
	}

}
