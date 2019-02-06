package co.com.devco.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Go implements Task {

	private String url;
	
	public Go (String url) {
		this.url = url;
		
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		//Este metodo es el que se ejecuta cuando lo llama una tarea.
		actor.attemptsTo(
					Open.url(url),
					Click.on(co.com.devco.googlesuite.userinterfaces.GoogleAppsComponent.GOOGLE_APPS)
				);
	}
	
	public static Performable to(SuiteUrl app) {
		//me permite intervenir en tiempo de ejecucion de esa prueba para desde alli construir la documentacion viva. Le mando la
		//clase que quiero crear y los parametros de esa clase
		return instrumented(Go.class, app.url());
		
	}
}
