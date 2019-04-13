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
