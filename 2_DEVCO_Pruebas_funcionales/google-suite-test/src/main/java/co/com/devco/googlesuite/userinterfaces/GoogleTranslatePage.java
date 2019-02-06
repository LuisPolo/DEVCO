package co.com.devco.googlesuite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GoogleTranslatePage {
	
	
//tareget tipo de objeto dentro de screenplay. Con estos son los que interactuamos.
	
	public static final Target SOURCE_LANGUAGE_OPTION = Target.the("Source Language Button").located(By.id("gt-sl-gms"));
	public static final Target TARGET_LANGUAGE_OPTION = Target.the("Target Language Button").located(By.id("gt-tl-gms"));
	//XPATH: Este es el camino que sigue para poder llegar a un elemento.
	public static final Target SOURCE_LANGUAGE = Target.the("Source Language").locatedBy("//div[@id='gt-sl-gms-menu']/table/tbody/tr/td//div[contains(text(), '{0}')]");
	public static final Target TARGET_LANGUAGE = Target.the("Target Language").locatedBy("//div[@id='gt-tl-gms-menu']/table/tbody/tr/td//div[contains(text(), '{0}')]");
	public static final Target SOURCE_LANGUAGE_TEXTAREA = Target.the("Source Language TextArea").located(By.id("source"));
	public static final Target TRANSLATE = Target.the("Translate Button").located(By.id("gt-submit"));
	public static final Target TARGET_LANGUAGE_RESULT = Target.the("Target Language Result Area").located(By.id("gt-res-dir-ctr"));
}
