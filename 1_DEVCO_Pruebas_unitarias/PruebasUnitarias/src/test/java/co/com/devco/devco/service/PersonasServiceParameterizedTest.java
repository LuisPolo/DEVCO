package co.com.devco.devco.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.com.devco.devco.model.Persona;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith (JUnitParamsRunner.class)
public class PersonasServiceParameterizedTest {

	//Patron builder: Object model entregue una persona sin nombre o con edad menor que 0
	private static final Object[] getPersonas() {
		return new Object [ ] {
				null,
				new Persona ("Luis", "", 36),
				new Persona ("", "Polo", 36),
				new Persona ("Luis", "Polo", -10)			
				
		};	

	}	
		
	@Test
	@Parameters (method = "getPersonas")
	public void constructordebeSetearLasPersonas(Persona persona) {
		try {
			PersonaService personaservice = new PersonaService();
			personaservice.presentarPersona(persona);
		}catch (Exception ex) {
			Assert.assertTrue(ex instanceof Exception);
			
		}			
	}
	
	
	
}
