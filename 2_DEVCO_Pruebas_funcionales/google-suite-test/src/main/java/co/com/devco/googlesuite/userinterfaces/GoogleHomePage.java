package co.com.devco.googlesuite.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class GoogleHomePage extends PageObject {
	
	public static final Target POP_UP = Target.the("Privacy Pop Up").locatedBy("//a[@class='gb_Ba gb_Cd gb_ld']");

}
