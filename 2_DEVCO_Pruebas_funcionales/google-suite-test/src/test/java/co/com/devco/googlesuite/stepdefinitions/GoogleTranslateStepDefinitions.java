package co.com.devco.googlesuite.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import co.com.devco.googlesuite.questions.TheTranslatedWord;
import co.com.devco.googlesuite.userinterfaces.GoogleAppsComponent;
import co.com.devco.googlesuite.userinterfaces.GoogleHomePage;
import co.com.devco.task.Go;
import co.com.devco.task.Open;
import co.com.devco.task.SuiteUrl;
import co.com.devco.task.Translate;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class GoogleTranslateStepDefinitions {

	//Lo primero que se necesita es un actor
	private final String SUSAN = "Susan";
	
	//Actor susan = Actor.named("Susan")
	
	@Before
	public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
	}

	//Esto es a punta de expresiones regulares y se mapea con los features [(.*) Es una variable]
	
	@Given("^that Susan wants to translate a word$")
	public void thatSusanWantsToTranslateAWord() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		 theActorCalled(SUSAN).attemptsTo(
				 Go.to(SuiteUrl.GOOGLE),
				 Open.the(GoogleAppsComponent.GOOGLE_TRANSLATE));				 
	}

	@When("^she translates the word (.*) from (.*) to (.*)$")
	public void sheTranslatesTheWordCheeseFromInglésToEspañol(String theWord, String TheSourceLanguage, String TheTargetLanguage) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		//reutilizo las interacciones 
		//eL ATEEMPT TO recibe el performable y ejecuta el metodo performAs
	    theActorInTheSpotlight().attemptsTo(
	    		Translate.theWord(theWord).from(TheSourceLanguage).to(TheTargetLanguage)
	    );
	}

	@Then("^she should see the word (.*) in the screen$")
	public void sheShouldSeeTheWordQuesoInTheScreen(String theTranslatedWord) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		//Estos son los questions
	    theActorInTheSpotlight().should(seeThat(TheTranslatedWord.is(), equalTo(theTranslatedWord)));
	}
}
