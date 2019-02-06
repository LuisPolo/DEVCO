package co.com.devco.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import co.com.devco.task.Builder.TranslateTheWord;

import static co.com.devco.googlesuite.userinterfaces.GoogleTranslatePage.*;

public class Translate implements Task {
	
	private String theWord;
	private String theSourceLanguage;
	private String theTargetLanguage;	
	
	
	public Translate(String theWord, String theSourceLanguage, String theTargetLanguage) {		
		this.theWord = theWord;
		this.theSourceLanguage = theSourceLanguage;
		this.theTargetLanguage = theTargetLanguage;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub}
		//El actor intenta hacer...
		actor.attemptsTo(
				Click.on(SOURCE_LANGUAGE_OPTION),
				Click.on(SOURCE_LANGUAGE.of(theSourceLanguage)),
				Click.on(TARGET_LANGUAGE_OPTION),
				Click.on(TARGET_LANGUAGE.of(theTargetLanguage)),
				Enter.theValue(theWord).into(SOURCE_LANGUAGE_TEXTAREA),
				Click.on(TRANSLATE)
		);		
	}
	
	//Se crea un builder no para crear un objeto de negocio sino una tarea
	public static TranslateTheWord theWord(String theWord) {
		
		return new TranslateTheWord(theWord);
		
	}
	

}
