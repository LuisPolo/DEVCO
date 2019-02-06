package co.com.devco.googlesuite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GoogleAppsComponent {
	
	public static final Target GOOGLE_APPS = Target.the("Google Apps Button").located(By.id("gbwa"));
	public static final Target GOOGLE_TRANSLATE = Target.the("Google Translate Option").located(By.id("gb51"));
	public static final Target YOUTUBE = Target.the("Youtube Option").located(By.id("gb36"));

}
