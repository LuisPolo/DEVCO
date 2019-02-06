package co.com.devco.googlesuite.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/google_translate.feature",
		glue = {"co.com.devco.googlesuite.stepdefinitions"},
		snippets = SnippetType.CAMELCASE
)
public class GoogleTranslateRunner {

}
