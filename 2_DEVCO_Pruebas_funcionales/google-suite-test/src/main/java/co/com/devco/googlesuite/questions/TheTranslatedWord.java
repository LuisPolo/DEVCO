package co.com.devco.googlesuite.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import static co.com.devco.googlesuite.userinterfaces.GoogleTranslatePage.*;

public class TheTranslatedWord implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		
		return Text.of(TARGET_LANGUAGE_RESULT).viewedBy(actor).asString();
	}
	
	public static TheTranslatedWord is() {		
		return new TheTranslatedWord();
	}
}
