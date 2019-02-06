package co.com.devco.task.Builder;

import co.com.devco.task.Translate;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TranslateTheWord {

	private String theWord;
	private String theSourceLanguage;
	
	public TranslateTheWord(String theWord) {	
		this.theWord = theWord;
	}
	
	public TranslateTheWord from (String theSourceLanguage) {
		this.theSourceLanguage = theSourceLanguage;
		return this;
	}
	
	public Performable to(String theTargetLanguage) {
		return  instrumented(Translate.class, theWord, theSourceLanguage, theTargetLanguage);
		
	}
	
}
